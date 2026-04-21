package io.elepay.client.charge;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Exposes the SDK version and builds the {@code User-Agent} string sent on every request.
 *
 * <p>The version is read once, at class initialization, from
 * {@code /elepay-java-sdk.properties} on the classpath. That file is filtered by Maven
 * so {@code ${project.version}} is substituted at build time. When the SDK is executed
 * from a non-packaged classpath (an IDE, raw {@code target/classes}), the version
 * resolves to {@code "unknown"}.
 */
public final class ClientVersion {

    private static final String UNKNOWN = "unknown";

    /** Semantic version of the SDK, e.g. {@code "1.3.0"}, or {@code "unknown"} when unresolvable. */
    public static final String VERSION = readVersion();

    private ClientVersion() {}

    /**
     * Build the default {@code User-Agent} header value:
     *
     * <pre>elepay-java/1.3.0 (Java/17.0.2; Mac OS X)</pre>
     */
    public static String userAgent() {
        return "elepay-java/" + VERSION
                + " (Java/" + sanitize(System.getProperty("java.version", UNKNOWN))
                + "; " + sanitize(System.getProperty("os.name", UNKNOWN)) + ")";
    }

    private static String readVersion() {
        try (InputStream in = ClientVersion.class.getResourceAsStream("/elepay-java-sdk.properties")) {
            if (in == null) {
                return fallbackFromPackage();
            }
            Properties props = new Properties();
            props.load(in);
            String value = props.getProperty("version");
            if (value == null || value.isEmpty() || value.contains("${")) {
                // Filtering didn't run — fall back.
                return fallbackFromPackage();
            }
            return value;
        } catch (IOException e) {
            return fallbackFromPackage();
        }
    }

    private static String fallbackFromPackage() {
        Package pkg = ClientVersion.class.getPackage();
        if (pkg != null) {
            String implVersion = pkg.getImplementationVersion();
            if (implVersion != null && !implVersion.isEmpty()) {
                return implVersion;
            }
        }
        return UNKNOWN;
    }

    /** Strip characters that would produce a malformed header value. */
    private static String sanitize(String value) {
        return value.replaceAll("[\\r\\n();]", "").trim();
    }
}
