package io.elepay.client.charge.webhook;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Verify signatures on webhooks sent by elepay.
 *
 * <p>elepay signs every outgoing webhook with an HMAC-SHA256 of
 * {@code <timestamp>.<raw-body>} using the webhook endpoint's signing secret,
 * and includes a header of the form:
 *
 * <pre>elepay-Signature: t=1713624000,sign=5257a8e9c4...</pre>
 *
 * <p>Typical usage in a servlet or Spring controller:
 *
 * <pre>{@code
 * String payload = new String(request.getInputStream().readAllBytes(), UTF_8);
 * String header  = request.getHeader(Webhook.HEADER_NAME);
 * try {
 *     Webhook.verifyHeader(payload, header, signingSecret);
 *     // The payload is authentic — parse and dispatch.
 * } catch (SignatureVerificationException e) {
 *     // Reject with HTTP 400.
 * }
 * }</pre>
 *
 * <p>Read the raw body <b>before</b> any JSON parsing — the signature is computed
 * over the exact bytes elepay sent, so any reformatting (whitespace, key order)
 * will invalidate the match.
 *
 * <p>This class is stateless and thread-safe.
 */
public final class Webhook {

    /** HTTP header used by elepay to carry the signature. */
    public static final String HEADER_NAME = "elepay-Signature";

    /** Default clock-drift tolerance applied to the {@code t=} timestamp, in seconds. */
    public static final long DEFAULT_TOLERANCE_SECONDS = 300L;

    private static final String HMAC_ALGORITHM = "HmacSHA256";
    private static final String TIMESTAMP_KEY = "t";
    private static final String SIGNATURE_KEY = "sign";

    private static final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();

    private Webhook() {}

    /**
     * Verify a webhook using the default {@value #DEFAULT_TOLERANCE_SECONDS}-second tolerance
     * and the system clock.
     *
     * @param payload   the exact raw request body as sent by elepay
     * @param sigHeader the value of the {@code elepay-Signature} header
     * @param secret    the signing secret configured on the webhook endpoint
     * @throws SignatureVerificationException if the header is malformed, the signature does not
     *                                        match, or the timestamp is outside the tolerance
     */
    public static void verifyHeader(String payload, String sigHeader, String secret)
            throws SignatureVerificationException {
        verifyHeader(payload, sigHeader, secret, DEFAULT_TOLERANCE_SECONDS, Clock.systemUTC());
    }

    /**
     * Verify a webhook with a custom tolerance. Pass {@code toleranceSeconds <= 0} to disable the
     * timestamp check entirely (replay-attack prevention becomes the caller's responsibility).
     */
    public static void verifyHeader(String payload, String sigHeader, String secret, long toleranceSeconds)
            throws SignatureVerificationException {
        verifyHeader(payload, sigHeader, secret, toleranceSeconds, Clock.systemUTC());
    }

    /**
     * Verify a webhook with a custom tolerance and an injected {@link Clock}. Intended for tests.
     */
    public static void verifyHeader(String payload, String sigHeader, String secret,
                                    long toleranceSeconds, Clock clock)
            throws SignatureVerificationException {
        if (payload == null) {
            throw new SignatureVerificationException("payload is null", sigHeader);
        }
        if (sigHeader == null || sigHeader.isEmpty()) {
            throw new SignatureVerificationException("elepay-Signature header is missing", sigHeader);
        }
        if (secret == null || secret.isEmpty()) {
            throw new SignatureVerificationException("signing secret is empty", sigHeader);
        }
        if (clock == null) {
            clock = Clock.systemUTC();
        }

        long timestamp = extractTimestamp(sigHeader);
        List<String> signatures = extractSignatures(sigHeader);
        if (signatures.isEmpty()) {
            throw new SignatureVerificationException(
                    "No \"sign\" value found in elepay-Signature header", sigHeader);
        }

        String expected = computeSignature(secret, timestamp, payload);
        byte[] expectedBytes = expected.getBytes(StandardCharsets.US_ASCII);

        boolean matched = false;
        for (String candidate : signatures) {
            byte[] candidateBytes = candidate.getBytes(StandardCharsets.US_ASCII);
            if (MessageDigest.isEqual(expectedBytes, candidateBytes)) {
                matched = true;
                break;
            }
        }
        if (!matched) {
            throw new SignatureVerificationException(
                    "No signatures found matching the expected signature for payload", sigHeader);
        }

        if (toleranceSeconds > 0) {
            long now = clock.instant().getEpochSecond();
            if (Math.abs(now - timestamp) > toleranceSeconds) {
                throw new SignatureVerificationException(
                        "Timestamp outside the tolerance zone (delta="
                                + (now - timestamp) + "s, tolerance=" + toleranceSeconds + "s)",
                        sigHeader);
            }
        }
    }

    /**
     * Compute the hex-encoded HMAC-SHA256 that elepay would produce for the given
     * {@code (secret, timestamp, payload)} tuple. Exposed so callers can build
     * test fixtures or reproduce elepay's algorithm for debugging.
     */
    public static String computeSignature(String secret, long timestamp, String payload) {
        String signedPayload = timestamp + "." + payload;
        try {
            Mac mac = Mac.getInstance(HMAC_ALGORITHM);
            mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), HMAC_ALGORITHM));
            byte[] digest = mac.doFinal(signedPayload.getBytes(StandardCharsets.UTF_8));
            return toHex(digest);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            // HmacSHA256 is part of every standard JVM. If this fails, the JVM is broken.
            throw new IllegalStateException("HmacSHA256 is unavailable on this JVM", e);
        }
    }

    private static long extractTimestamp(String header) throws SignatureVerificationException {
        for (String part : header.split(",")) {
            String[] kv = part.split("=", 2);
            if (kv.length == 2 && TIMESTAMP_KEY.equals(kv[0].trim())) {
                try {
                    return Long.parseLong(kv[1].trim());
                } catch (NumberFormatException e) {
                    throw new SignatureVerificationException(
                            "Unable to parse timestamp from elepay-Signature header", header, e);
                }
            }
        }
        throw new SignatureVerificationException(
                "No \"t\" value found in elepay-Signature header", header);
    }

    private static List<String> extractSignatures(String header) {
        List<String> result = new ArrayList<>();
        for (String part : header.split(",")) {
            String[] kv = part.split("=", 2);
            if (kv.length == 2 && SIGNATURE_KEY.equals(kv[0].trim())) {
                result.add(kv[1].trim());
            }
        }
        return result;
    }

    private static String toHex(byte[] bytes) {
        char[] out = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xff;
            out[i * 2] = HEX_DIGITS[v >>> 4];
            out[i * 2 + 1] = HEX_DIGITS[v & 0x0f];
        }
        return new String(out);
    }
}
