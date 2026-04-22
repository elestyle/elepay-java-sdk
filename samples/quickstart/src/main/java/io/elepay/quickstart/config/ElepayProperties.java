package io.elepay.quickstart.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Typed binding for the {@code elepay.*} keys in {@code application.yaml}.
 *
 * <p>All three values are required for full functionality:
 * <ul>
 *   <li>{@code secretKey} ({@code sk_test_…}) — server-side bearer token used by the SDK.</li>
 *   <li>{@code publishableKey} ({@code pk_test_…}) — sent to the browser so
 *       {@code elepay.js} can call {@code handleCharge / handleSource / checkout}.</li>
 *   <li>{@code webhookSigningSecret} — used by
 *       {@link io.elepay.client.charge.webhook.Webhook#verifyHeader} to authenticate
 *       inbound events.</li>
 * </ul>
 */
@ConfigurationProperties(prefix = "elepay")
public class ElepayProperties {

    private String secretKey = "";
    private String publishableKey = "";
    private String webhookSigningSecret = "";

    public String getSecretKey() { return secretKey; }
    public void setSecretKey(String v) { this.secretKey = v; }

    public String getPublishableKey() { return publishableKey; }
    public void setPublishableKey(String v) { this.publishableKey = v; }

    public String getWebhookSigningSecret() { return webhookSigningSecret; }
    public void setWebhookSigningSecret(String v) { this.webhookSigningSecret = v; }
}
