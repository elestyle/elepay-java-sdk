package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "elepay")
public class ElepayProperties {

    /** Test mode secret key, starts with {@code sk_test_}. */
    private String secretKey = "";

    /** Signing secret of the webhook endpoint registered in the elepay dashboard. */
    private String webhookSigningSecret = "";

    public String getSecretKey() { return secretKey; }
    public void setSecretKey(String v) { this.secretKey = v; }

    public String getWebhookSigningSecret() { return webhookSigningSecret; }
    public void setWebhookSigningSecret(String v) { this.webhookSigningSecret = v; }
}
