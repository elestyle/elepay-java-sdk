package io.elepay.quickstart.web;

import java.nio.charset.StandardCharsets;

import io.elepay.quickstart.config.ElepayProperties;
import io.elepay.quickstart.domain.Order;
import io.elepay.quickstart.repository.EventLog;
import io.elepay.quickstart.repository.OrderRepository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.elepay.client.charge.webhook.SignatureVerificationException;
import io.elepay.client.charge.webhook.Webhook;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Receives and verifies inbound elepay webhooks, then routes each event to
 * the matching merchant {@link Order} in {@link OrderRepository}. Unknown
 * event types are still ACKed — they are recorded in the events timeline
 * tagged {@code <family>.unknown} so the reader can see exactly what the
 * API sent without getting into a retry loop.
 *
 * <p>Per elepay docs, event types are dot-qualified
 * ({@code charge.succeeded}, {@code source.chargeable},
 * {@code refund.refunded}, {@code code.paid}, {@code subscription.active},
 * {@code invoice.paid}, {@code dispute.new}, …). The prefix before the
 * first dot identifies the resource family; the suffix is the lifecycle
 * verb. The SDK does not ship an enum — treat the type as an opaque string
 * and route on the resource id.
 */
@Controller
public class WebhookController {

    private static final Logger log = LoggerFactory.getLogger(WebhookController.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final ObjectMapper PRETTY = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    private final EventLog events;
    private final ElepayProperties props;
    private final OrderRepository orders;

    public WebhookController(EventLog events, ElepayProperties props, OrderRepository orders) {
        this.events = events;
        this.props  = props;
        this.orders = orders;
    }

    @PostMapping("/webhook")
    @ResponseBody
    public ResponseEntity<String> receive(
            @RequestBody byte[] rawBody,
            @RequestHeader(value = Webhook.HEADER_NAME, required = false) String sigHeader,
            HttpServletRequest request) {

        String payload = new String(rawBody, StandardCharsets.UTF_8);
        String secret  = props.getWebhookSigningSecret();
        boolean verified = false;
        String reason = null;
        try {
            if (secret == null || secret.isEmpty()) {
                reason = "elepay.webhook-signing-secret not configured";
            } else {
                // --- elepay SDK ---
                Webhook.verifyHeader(payload, sigHeader, secret);
                verified = true;
            }
        } catch (SignatureVerificationException e) {
            reason = e.getMessage();
        }

        String eventType = extractType(payload);
        String pretty    = prettify(payload);

        if (!verified) {
            events.record(EventLog.Entry.reject(
                    "rejected", "type=" + eventType + " — REJECTED: " + reason, pretty));
            log.warn("[webhook] from {} rejected: {}", request.getRemoteAddr(), reason);
            return ResponseEntity.status(400).body("signature verification failed: " + reason);
        }

        String family     = eventType.contains(".") ? eventType.substring(0, eventType.indexOf('.')) : eventType;
        String resourceId = extractResourceId(payload);
        String status     = extractStatus(payload);
        Order  routed     = resourceId == null ? null : orders.getByResourceId(resourceId);

        if (routed != null) {
            orders.applyWebhook(resourceId, status, pretty);
        } else {
            events.record(EventLog.Entry.webhook(
                    family + ".unknown",
                    eventType + " (no local order for resource=" + resourceId + ")",
                    pretty));
        }
        log.info("[webhook] verified type={} resource={} routed={}", eventType, resourceId, routed != null);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/events")
    public String list(Model model) {
        model.addAttribute("events",   events.snapshot());
        model.addAttribute("capacity", EventLog.CAPACITY);
        return "events";
    }

    private static String extractType(String payload) {
        try {
            return MAPPER.readTree(payload).path("type").asText("");
        } catch (Exception e) { return ""; }
    }

    private static String extractResourceId(String payload) {
        try {
            JsonNode root = MAPPER.readTree(payload);
            JsonNode obj  = firstWithField(
                    root.path("data").path("object"),
                    root.path("data"),
                    root,
                    "id");
            String id = obj.path("id").asText(null);
            return id == null || id.isEmpty() ? null : id;
        } catch (Exception e) { return null; }
    }

    private static String extractStatus(String payload) {
        try {
            JsonNode root = MAPPER.readTree(payload);
            JsonNode obj  = firstWithField(
                    root.path("data").path("object"),
                    root.path("data"),
                    root,
                    "status");
            String s = obj.path("status").asText(null);
            return s == null || s.isEmpty() ? null : s;
        } catch (Exception e) { return null; }
    }

    private static JsonNode firstWithField(JsonNode a, JsonNode b, JsonNode c, String field) {
        if (a != null && !a.isMissingNode() && a.has(field)) return a;
        if (b != null && !b.isMissingNode() && b.has(field)) return b;
        return c;
    }

    private static String prettify(String json) {
        if (json == null || json.isEmpty()) return "";
        try { return PRETTY.writeValueAsString(MAPPER.readTree(json)); }
        catch (Exception e) { return json; }
    }
}
