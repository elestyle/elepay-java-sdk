package io.elepay.client.charge.webhook;

/**
 * Thrown when an {@code elepay-Signature} header fails verification.
 *
 * <p>The offending header is preserved on the exception so callers can log
 * it for forensic analysis without having to re-parse the request.
 */
public class SignatureVerificationException extends Exception {

    private static final long serialVersionUID = 1L;

    private final String sigHeader;

    public SignatureVerificationException(String message, String sigHeader) {
        super(message);
        this.sigHeader = sigHeader;
    }

    public SignatureVerificationException(String message, String sigHeader, Throwable cause) {
        super(message, cause);
        this.sigHeader = sigHeader;
    }

    /** @return the raw {@code elepay-Signature} header value, or {@code null} if absent. */
    public String getSigHeader() {
        return sigHeader;
    }
}
