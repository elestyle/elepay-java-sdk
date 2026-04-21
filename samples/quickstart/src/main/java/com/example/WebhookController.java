package com.example;

import java.nio.charset.StandardCharsets;
import java.time.Instant;

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

@Controller
public class WebhookController {

    private static final Logger log = LoggerFactory.getLogger(WebhookController.class);

    private final EventStore events;
    private final ElepayProperties props;

    public WebhookController(EventStore events, ElepayProperties props) {
        this.events = events;
        this.props = props;
    }

    /**
     * Receives raw webhook bodies from elepay. Note {@code @RequestBody byte[]} —
     * we must hand the exact bytes to {@link Webhook#verifyHeader(String, String, String)}
     * so signature comparison works. Re-reading as {@code String} after Spring MVC
     * has parsed JSON would re-encode and break the hash.
     */
    @PostMapping("/webhook")
    @ResponseBody
    public ResponseEntity<String> receive(
            @RequestBody byte[] rawBody,
            @RequestHeader(value = Webhook.HEADER_NAME, required = false) String sigHeader,
            HttpServletRequest request) {

        String payload = new String(rawBody, StandardCharsets.UTF_8);
        String secret = props.getWebhookSigningSecret();

        String summary = shortSummary(payload);
        boolean verified = false;
        String reason = null;
        try {
            if (secret == null || secret.isEmpty()) {
                reason = "elepay.webhook-signing-secret not configured";
            } else {
                Webhook.verifyHeader(payload, sigHeader, secret);
                verified = true;
            }
        } catch (SignatureVerificationException e) {
            reason = e.getMessage();
        }

        events.record(new EventStore.Entry(Instant.now(), verified,
                summary + (verified ? "" : " — REJECTED: " + reason),
                payload));
        log.info("[webhook] from {} verified={} summary={}", request.getRemoteAddr(), verified, summary);

        if (verified) return ResponseEntity.ok("ok");
        return ResponseEntity.status(400).body("signature verification failed: " + reason);
    }

    @GetMapping("/events")
    public String list(Model model) {
        model.addAttribute("events", events.snapshot());
        model.addAttribute("capacity", EventStore.CAPACITY);
        return "events";
    }

    private static String shortSummary(String payload) {
        if (payload == null || payload.isEmpty()) return "(empty body)";
        int typeIdx = payload.indexOf("\"type\"");
        if (typeIdx < 0) return payload.length() > 80 ? payload.substring(0, 80) + "…" : payload;
        int colon = payload.indexOf(':', typeIdx);
        int q1 = payload.indexOf('"', colon + 1);
        int q2 = payload.indexOf('"', q1 + 1);
        if (q1 < 0 || q2 < 0) return payload.substring(0, Math.min(80, payload.length()));
        return "type=" + payload.substring(q1 + 1, q2);
    }
}
