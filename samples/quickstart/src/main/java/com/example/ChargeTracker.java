package com.example;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.api.ChargeApi;
import io.elepay.client.charge.pojo.ChargeDto;
import io.elepay.client.charge.pojo.ChargeStatusType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Periodically calls {@code retrieveCharge} on every charge created through this
 * demo, records any status transition to the {@link EventStore}, and stops
 * polling once the charge reaches a terminal state.
 *
 * <p>Meant as the "no webhook required" alternative so the sample app can be
 * driven end-to-end without punching a public URL through to {@code /webhook}.
 */
@Component
public class ChargeTracker {

    private static final Logger log = LoggerFactory.getLogger(ChargeTracker.class);

    /** Stop polling once we observe one of these. */
    private static final Set<ChargeStatusType> TERMINAL = EnumSet.of(
            ChargeStatusType.CAPTURED,
            ChargeStatusType.REFUNDED,
            ChargeStatusType.REVOKED,
            ChargeStatusType.FAILED);

    /** Give up on a charge we never see resolve. */
    private static final Duration MAX_LIFETIME = Duration.ofMinutes(15);

    public static class Tracked {
        public final String id;
        public final Instant createdAt;
        public final String amountCurrency;
        public final String paymentMethod;
        public volatile ChargeStatusType status;
        public volatile Instant lastPolledAt;
        public volatile boolean done;

        Tracked(ChargeDto charge) {
            this.id = charge.getId();
            this.createdAt = Instant.now();
            this.amountCurrency = charge.getAmount() + " " + charge.getCurrency();
            this.paymentMethod = String.valueOf(charge.getPaymentMethod());
            this.status = charge.getStatus();
        }

        // Thymeleaf accessors
        public String getId() { return id; }
        public String getCreatedAt() { return createdAt.toString(); }
        public String getAmountCurrency() { return amountCurrency; }
        public String getPaymentMethod() { return paymentMethod; }
        public String getStatus() { return status == null ? "" : status.getValue(); }
        public String getLastPolledAt() { return lastPolledAt == null ? "never" : lastPolledAt.toString(); }
        public boolean isDone() { return done; }
    }

    private final ChargeApi chargeApi;
    private final EventStore events;
    private final Map<String, Tracked> byId = Collections.synchronizedMap(new LinkedHashMap<>());

    public ChargeTracker(ChargeApi chargeApi, EventStore events) {
        this.chargeApi = chargeApi;
        this.events = events;
    }

    public void track(ChargeDto charge) {
        Tracked t = new Tracked(charge);
        byId.put(t.id, t);
        log.info("[tracker] now tracking {} (initial status={})", t.id, t.getStatus());
    }

    /** Newest-first snapshot for rendering. */
    public List<Tracked> recent() {
        synchronized (byId) {
            List<Tracked> list = new ArrayList<>(byId.values());
            Collections.reverse(list);
            return list;
        }
    }

    @Scheduled(fixedDelayString = "${tracker.poll-interval-ms:5000}",
               initialDelayString = "${tracker.poll-interval-ms:5000}")
    public void poll() {
        Collection<Tracked> snapshot;
        synchronized (byId) {
            snapshot = new ArrayList<>(byId.values());
        }
        int active = 0;
        for (Tracked t : snapshot) if (!t.done) active++;
        if (active == 0) return;
        log.info("[tracker] polling {} charge(s)", active);
        for (Tracked t : snapshot) {
            if (t.done) continue;

            if (Duration.between(t.createdAt, Instant.now()).compareTo(MAX_LIFETIME) > 0) {
                t.done = true;
                events.record(new EventStore.Entry(Instant.now(), true,
                        "polling gave up on " + t.id + " after " + MAX_LIFETIME,
                        "status=" + t.getStatus()));
                continue;
            }

            try {
                ChargeDto fresh = chargeApi.retrieveCharge(t.id);
                t.lastPolledAt = Instant.now();
                if (fresh.getStatus() != t.status) {
                    ChargeStatusType oldStatus = t.status;
                    t.status = fresh.getStatus();
                    events.record(new EventStore.Entry(Instant.now(), true,
                            "poll: " + t.id + " " + statusName(oldStatus) + " -> " + statusName(t.status),
                            toJsonish(fresh)));
                    log.info("[tracker] {} status {} -> {}", t.id, oldStatus, t.status);
                }
                if (TERMINAL.contains(t.status)) {
                    t.done = true;
                    log.info("[tracker] {} reached terminal status {}", t.id, t.status);
                }
            } catch (ApiException e) {
                log.warn("[tracker] retrieveCharge({}) failed: HTTP {} {}", t.id, e.getCode(), e.getMessage());
            } catch (Exception e) {
                log.warn("[tracker] retrieveCharge({}) failed: {}", t.id, e.toString());
            }
        }

        // Bound memory: keep the most recent 50.
        synchronized (byId) {
            while (byId.size() > 50) {
                Iterator<String> it = byId.keySet().iterator();
                if (!it.hasNext()) break;
                it.next();
                it.remove();
            }
        }
    }

    private static String statusName(ChargeStatusType s) {
        return s == null ? "(null)" : s.getValue();
    }

    private static String toJsonish(ChargeDto c) {
        return "{id=" + c.getId()
                + ", status=" + c.getStatus()
                + ", amount=" + c.getAmount() + " " + c.getCurrency()
                + ", paymentMethod=" + c.getPaymentMethod()
                + "}";
    }
}
