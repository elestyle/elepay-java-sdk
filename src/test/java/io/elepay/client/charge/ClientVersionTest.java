package io.elepay.client.charge;

import org.junit.Assert;
import org.junit.Test;

public class ClientVersionTest {

    @Test
    public void versionIsResolvedFromFilteredResource() {
        // When running under Maven surefire the resource is filtered; when running from a
        // raw target/classes via an IDE it may legitimately be "unknown". Accept either.
        String version = ClientVersion.VERSION;
        Assert.assertNotNull(version);
        Assert.assertFalse("version must not contain an unresolved Maven placeholder",
                version.contains("${"));
    }

    @Test
    public void userAgentHasExpectedShape() {
        String ua = ClientVersion.userAgent();
        Assert.assertTrue("UA should start with SDK identifier: " + ua,
                ua.startsWith("elepay-java/"));
        Assert.assertTrue("UA should include Java version: " + ua, ua.contains("Java/"));
        Assert.assertTrue("UA should include OS info in parentheses: " + ua,
                ua.contains("(") && ua.endsWith(")"));
    }

    @Test
    public void userAgentContainsNoControlCharacters() {
        String ua = ClientVersion.userAgent();
        for (char c : ua.toCharArray()) {
            Assert.assertFalse("UA must not contain CR/LF: " + ua, c == '\r' || c == '\n');
        }
    }
}
