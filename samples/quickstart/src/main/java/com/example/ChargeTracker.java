package com.example;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.api.ChargeApi;
import io.elepay.client.charge.pojo.ChargeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * In-memory registry of charges created through this demo app. Holds the
 * last-known status so the index page has something to render.
 *
 * <p>State advances by two mechanisms, mirroring a real integration:
 * <ul>
 *   <li><b>Webhook (primary).</b> {@code WebhookController} decodes signed
 *       {@code charge.*} events and calls {@link #applyWebhook(String, String)}.</li>
 *   <li><b>On-demand reconciliation.</b> The merchant can hit "Refresh" on a
 *       row, which triggers {@link #refresh(String)} — a one-shot
 *       {@code retrieveCharge} against the REST API. This is what a real
 *       backend would do on a user-initiated "check my payment" action or
 *       from a batch reconciliation job, <em>not</em> in a per-charge polling
 *       loop.</li>
 * </ul>
 *
 * Deliberately <em>not</em> a {@code @Scheduled} poller: that pattern doesn't
 * generalize past a toy app and would obscure the webhook-is-primary lesson.
 */
@Component
public class ChargeTracker {

    private static final Logger log = LoggerFactory.getLogger(ChargeTracker.class);
    private static final int MAX_ENTRIES = 50;

    public static class Tracked {
        public final String id;
        public final String orderNo;
        public final Instant createdAt;
        public final String amountCurrency;
        public final String paymentMethod;
        public volatile String status;
        public volatile Instant lastUpdatedAt;
        public volatile String lastUpdatedBy; // "webhook" | "refresh" | "create" | "return"

        Tracked(ChargeDto charge) {
            this.id = charge.getId();
            this.orderNo = charge.getOrderNo();
            this.createdAt = Instant.now();
            this.amountCurrency = charge.getAmount() + " " + charge.getCurrency();
            this.paymentMethod = charge.getPaymentMethod();
            this.status = charge.getStatus();
            this.lastUpdatedAt = this.createdAt;
            this.lastUpdatedBy = "create";
        }

        // Thymeleaf accessors
        public String getId() { return id; }
        public String getOrderNo() { return orderNo; }
        public String getCreatedAt() { return createdAt.toString(); }
        public String getAmountCurrency() { return amountCurrency; }
        public String getPaymentMethod() { return paymentMethod; }
        public String getStatus() { return status == null ? "" : status; }
        public String getLastUpdatedAt() { return lastUpdatedAt == null ? "" : lastUpdatedAt.toString(); }
        public String getLastUpdatedBy() { return lastUpdatedBy == null ? "" : lastUpdatedBy; }
    }

    private final ChargeApi chargeApi;
    private final EventStore events;
    private final Map<String, Tracked> byId = Collections.synchronizedMap(new LinkedHashMap<>());
    private final ObjectMapper mapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    public ChargeTracker(ChargeApi chargeApi, EventStore events) {
        this.chargeApi = chargeApi;
        this.events = events;
    }

    public void track(ChargeDto charge) {
        Tracked t = new Tracked(charge);
        synchronized (byId) {
            byId.put(t.id, t);
            while (byId.size() > MAX_ENTRIES) {
                Iterator<String> it = byId.keySet().iterator();
                it.next();
                it.remove();
            }
        }
        events.record(new EventStore.Entry(Instant.now(), true,
                "create: " + t.id + " orderNo=" + t.orderNo + " status=" + t.getStatus(),
                toJson(charge)));
        log.info("[tracker] registered {} (initial status={})", t.id, t.getStatus());
    }

    public Tracked get(String id) {
        return byId.get(id);
    }

    public Tracked findByOrderNo(String orderNo) {
        if (orderNo == null) return null;
        synchronized (byId) {
            for (Tracked t : byId.values()) {
                if (orderNo.equals(t.orderNo)) return t;
            }
        }
        return null;
    }

    /** Newest-first snapshot for rendering. */
    public List<Tracked> recent() {
        synchronized (byId) {
            List<Tracked> list = new ArrayList<>(byId.values());
            Collections.reverse(list);
            return list;
        }
    }

    /**
     * Apply a status update decoded from an inbound {@code charge.*} webhook.
     * {@code rawPayload} is the full verified webhook body, surfaced in the
     * events timeline so the reader can inspect the exact event envelope.
     */
    public void applyWebhook(String chargeId, String newStatus, String rawPayload) {
        update(chargeId, newStatus, "webhook", rawPayload);
    }

    /**
     * On-demand reconciliation: re-fetch the charge from the REST API.
     * Returns the updated record, or {@code null} if the ID is unknown locally.
     * The refreshed {@link ChargeDto} is recorded into the events timeline.
     */
    public Tracked refresh(String chargeId) throws ApiException {
        return refreshAs(chargeId, "refresh");
    }

    public Tracked refreshOnReturn(String chargeId) throws ApiException {
        return refreshAs(chargeId, "return");
    }

    private Tracked refreshAs(String chargeId, String source) throws ApiException {
        Tracked t = byId.get(chargeId);
        if (t == null) return null;
        ChargeDto fresh = chargeApi.retrieveCharge(chargeId);
        update(chargeId, fresh.getStatus(), source, toJson(fresh));
        return byId.get(chargeId);
    }

    private void update(String chargeId, String newStatus, String source, String body) {
        Tracked t = byId.get(chargeId);
        if (t == null) return;
        String oldStatus = t.status;
        t.lastUpdatedAt = Instant.now();
        t.lastUpdatedBy = source;
        t.status = newStatus;
        events.record(new EventStore.Entry(Instant.now(), true,
                source + ": " + chargeId + " " + nz(oldStatus) + " -> " + nz(newStatus),
                body == null ? "source=" + source : body));
        if (!Objects.equals(oldStatus, newStatus)) {
            log.info("[tracker] {} {} -> {} (via {})", chargeId, oldStatus, newStatus, source);
        } else {
            log.info("[tracker] {} unchanged status={} (via {})", chargeId, newStatus, source);
        }
    }

    private String toJson(ChargeDto c) {
        try {
            return mapper.writeValueAsString(c);
        } catch (JsonProcessingException e) {
            return "<failed to serialize ChargeDto: " + e.getMessage() + ">";
        }
    }

    private static String nz(String s) { return s == null ? "(null)" : s; }
}
