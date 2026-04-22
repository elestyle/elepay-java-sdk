package io.elepay.client.charge.pojo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

/**
 * Regression guard for the v2.0 design decision: response DTO fields that used
 * to be typed as generated enums are now plain {@code String}. The server is
 * free to add new enum values (e.g. a new payment method, a new status) without
 * any coordination with SDK releases — old clients must keep deserializing
 * responses cleanly instead of throwing during Jackson parsing.
 */
public class UnknownEnumValueTolerationTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void chargeDto_acceptsUnknownStatusAndPaymentMethod() throws Exception {
        String json = "{"
                + "\"id\":\"ch_xxx\","
                + "\"status\":\"some_future_status\","
                + "\"paymentMethod\":\"future_new_wallet\","
                + "\"resource\":\"future_resource\""
                + "}";

        ChargeDto charge = mapper.readValue(json, ChargeDto.class);

        Assert.assertEquals("ch_xxx", charge.getId());
        Assert.assertEquals("some_future_status", charge.getStatus());
        Assert.assertEquals("future_new_wallet", charge.getPaymentMethod());
        Assert.assertEquals("future_resource", charge.getResource());
    }

    @Test
    public void enumFromValue_returnsNullForUnknownInsteadOfThrowing() {
        Assert.assertNull(ChargeStatusType.fromValue("some_future_status"));
        Assert.assertEquals(ChargeStatusType.CAPTURED, ChargeStatusType.fromValue("captured"));
    }
}
