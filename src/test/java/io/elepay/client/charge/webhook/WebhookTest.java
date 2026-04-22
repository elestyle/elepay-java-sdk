package io.elepay.client.charge.webhook;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

import org.junit.Assert;
import org.junit.Test;

public class WebhookTest {

    private static final String SECRET = "whsec_test_0123456789abcdef";
    private static final String PAYLOAD = "{\"id\":\"evt_1\",\"type\":\"charge.succeeded\"}";

    @Test
    public void computeSignatureIsDeterministic() {
        long t = 1_700_000_000L;
        String a = Webhook.computeSignature(SECRET, t, PAYLOAD);
        String b = Webhook.computeSignature(SECRET, t, PAYLOAD);
        Assert.assertEquals(a, b);
        Assert.assertEquals("signature should be 64 hex chars", 64, a.length());
        Assert.assertTrue("signature should be lowercase hex", a.matches("[0-9a-f]{64}"));
    }

    @Test
    public void verifyHeaderAcceptsValidSignature() throws SignatureVerificationException {
        long t = 1_700_000_000L;
        String header = buildHeader(t, Webhook.computeSignature(SECRET, t, PAYLOAD));
        Webhook.verifyHeader(PAYLOAD, header, SECRET, 300L, fixedClock(t + 30));
    }

    @Test
    public void verifyHeaderAcceptsOneOfMultipleSignatures() throws SignatureVerificationException {
        long t = 1_700_000_000L;
        String good = Webhook.computeSignature(SECRET, t, PAYLOAD);
        String header = "t=" + t + ",sign=deadbeef,sign=" + good;
        Webhook.verifyHeader(PAYLOAD, header, SECRET, 300L, fixedClock(t));
    }

    @Test
    public void verifyHeaderRejectsTamperedPayload() {
        long t = 1_700_000_000L;
        String header = buildHeader(t, Webhook.computeSignature(SECRET, t, PAYLOAD));
        SignatureVerificationException e = assertThrows(() ->
                Webhook.verifyHeader(PAYLOAD + "tampered", header, SECRET, 300L, fixedClock(t)));
        Assert.assertTrue(e.getMessage().contains("No signatures"));
        Assert.assertEquals(header, e.getSigHeader());
    }

    @Test
    public void verifyHeaderRejectsWrongSecret() {
        long t = 1_700_000_000L;
        String header = buildHeader(t, Webhook.computeSignature(SECRET, t, PAYLOAD));
        assertThrows(() -> Webhook.verifyHeader(PAYLOAD, header, "wrong_secret", 300L, fixedClock(t)));
    }

    @Test
    public void verifyHeaderRejectsStaleTimestamp() {
        long t = 1_700_000_000L;
        String header = buildHeader(t, Webhook.computeSignature(SECRET, t, PAYLOAD));
        SignatureVerificationException e = assertThrows(() ->
                Webhook.verifyHeader(PAYLOAD, header, SECRET, 300L, fixedClock(t + 3600)));
        Assert.assertTrue(e.getMessage().contains("tolerance"));
    }

    @Test
    public void verifyHeaderRejectsFutureTimestamp() {
        long t = 1_700_000_000L;
        String header = buildHeader(t, Webhook.computeSignature(SECRET, t, PAYLOAD));
        assertThrows(() -> Webhook.verifyHeader(PAYLOAD, header, SECRET, 300L, fixedClock(t - 3600)));
    }

    @Test
    public void verifyHeaderAllowsDisablingTolerance() throws SignatureVerificationException {
        long t = 1_700_000_000L;
        String header = buildHeader(t, Webhook.computeSignature(SECRET, t, PAYLOAD));
        // Even a year later passes when tolerance is off.
        Webhook.verifyHeader(PAYLOAD, header, SECRET, 0L, fixedClock(t + 365L * 86400));
    }

    @Test
    public void verifyHeaderRejectsMalformedHeaderMissingTimestamp() {
        String header = "sign=" + Webhook.computeSignature(SECRET, 1_700_000_000L, PAYLOAD);
        SignatureVerificationException e = assertThrows(() ->
                Webhook.verifyHeader(PAYLOAD, header, SECRET));
        Assert.assertTrue(e.getMessage().contains("\"t\""));
    }

    @Test
    public void verifyHeaderRejectsMalformedHeaderMissingSignature() {
        String header = "t=1700000000";
        assertThrows(() -> Webhook.verifyHeader(PAYLOAD, header, SECRET));
    }

    @Test
    public void verifyHeaderRejectsUnparseableTimestamp() {
        String header = "t=not-a-number,sign=abc";
        assertThrows(() -> Webhook.verifyHeader(PAYLOAD, header, SECRET));
    }

    @Test
    public void verifyHeaderRejectsMissingHeader() {
        assertThrows(() -> Webhook.verifyHeader(PAYLOAD, null, SECRET));
        assertThrows(() -> Webhook.verifyHeader(PAYLOAD, "", SECRET));
    }

    @Test
    public void verifyHeaderRejectsEmptySecret() {
        String header = buildHeader(1_700_000_000L, "abc");
        assertThrows(() -> Webhook.verifyHeader(PAYLOAD, header, null));
        assertThrows(() -> Webhook.verifyHeader(PAYLOAD, header, ""));
    }

    @Test
    public void verifyHeaderToleratesWhitespaceAroundPairs() throws SignatureVerificationException {
        long t = 1_700_000_000L;
        String sig = Webhook.computeSignature(SECRET, t, PAYLOAD);
        String header = " t = " + t + " , sign = " + sig + " ";
        Webhook.verifyHeader(PAYLOAD, header, SECRET, 300L, fixedClock(t));
    }

    // ------------------------------------------------------------------

    private static String buildHeader(long timestamp, String signature) {
        return "t=" + timestamp + ",sign=" + signature;
    }

    private static Clock fixedClock(long epochSecond) {
        return Clock.fixed(Instant.ofEpochSecond(epochSecond), ZoneOffset.UTC);
    }

    @FunctionalInterface
    private interface ThrowingRunnable {
        void run() throws Exception;
    }

    private static SignatureVerificationException assertThrows(ThrowingRunnable body) {
        try {
            body.run();
        } catch (SignatureVerificationException e) {
            return e;
        } catch (Exception e) {
            Assert.fail("expected SignatureVerificationException, got " + e.getClass().getName()
                    + ": " + e.getMessage());
        }
        Assert.fail("expected SignatureVerificationException but none was thrown");
        return null;
    }
}
