package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "elepay")
public class ElepayProperties {

    /** Test mode secret key, starts with {@code sk_test_}. Used by the server-side SDK. */
    private String secretKey = "";

    /**
     * Test mode publishable key, starts with {@code pk_test_}. Sent to the browser and
     * passed to {@code new Elepay(...)} in the JS SDK.
     */
    private String publishableKey = "";

    /** Signing secret of the webhook endpoint registered in the elepay dashboard. */
    private String webhookSigningSecret = "";

    public String getSecretKey() { return secretKey; }
    public void setSecretKey(String v) { this.secretKey = v; }

    public String getPublishableKey() { return publishableKey; }
    public void setPublishableKey(String v) { this.publishableKey = v; }

    public String getWebhookSigningSecret() { return webhookSigningSecret; }
    public void setWebhookSigningSecret(String v) { this.webhookSigningSecret = v; }
}
