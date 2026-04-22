package io.elepay.quickstart.config;

import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.api.ChargeApi;
import io.elepay.client.charge.api.CodeApi;
import io.elepay.client.charge.api.CodeSettingApi;
import io.elepay.client.charge.api.CustomerApi;
import io.elepay.client.charge.api.DisputeApi;
import io.elepay.client.charge.api.LocationApi;
import io.elepay.client.charge.api.PaymentMethodApi;
import io.elepay.client.charge.api.RefundApi;
import io.elepay.client.charge.api.SubscriptionApi;
import io.elepay.client.charge.api.TerminalApi;
import io.elepay.client.charge.auth.HttpBearerAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Publishes every {@code io.elepay.client.charge.api.*} class as a Spring bean
 * sharing a single {@link ApiClient} authenticated with
 * {@link ElepayProperties#getSecretKey()}.
 *
 * <p>Controllers inject only the APIs they need. In a real service trim this
 * file down to the beans you actually call — there is no coupling between the
 * individual {@code Api} classes, so declaring extras has zero runtime cost
 * but does add reflective class loading at startup.
 */
@Configuration(proxyBeanMethods = false)
public class ElepayClientConfig {

    /**
     * Single authenticated {@link ApiClient}. All the {@code @Bean} methods below
     * share it, so setting the bearer token once propagates everywhere.
     */
    @Bean
    public ApiClient elepayApiClient(ElepayProperties props) {
        ApiClient client = io.elepay.client.charge.Configuration.getDefaultApiClient();
        HttpBearerAuth bearer = (HttpBearerAuth) client.getAuthentication("bearerAuth");
        bearer.setBearerToken(props.getSecretKey());
        return client;
    }

    @Bean public ChargeApi chargeApi(ApiClient c)               { return new ChargeApi(c); }
    @Bean public RefundApi refundApi(ApiClient c)               { return new RefundApi(c); }
    @Bean public CustomerApi customerApi(ApiClient c)           { return new CustomerApi(c); }
    @Bean public CodeApi codeApi(ApiClient c)                   { return new CodeApi(c); }
    @Bean public CodeSettingApi codeSettingApi(ApiClient c)     { return new CodeSettingApi(c); }
    @Bean public SubscriptionApi subscriptionApi(ApiClient c)   { return new SubscriptionApi(c); }
    @Bean public LocationApi locationApi(ApiClient c)           { return new LocationApi(c); }
    @Bean public DisputeApi disputeApi(ApiClient c)             { return new DisputeApi(c); }
    @Bean public PaymentMethodApi paymentMethodApi(ApiClient c) { return new PaymentMethodApi(c); }
    @Bean public TerminalApi terminalApi(ApiClient c)           { return new TerminalApi(c); }
}
