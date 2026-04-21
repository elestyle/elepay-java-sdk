package com.example;

import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.api.ChargeApi;
import io.elepay.client.charge.auth.HttpBearerAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** Wire the SDK clients as Spring beans so controllers can inject them. */
@Configuration(proxyBeanMethods = false)
public class ElepayClientConfig {

    @Bean
    public ApiClient elepayApiClient(ElepayProperties props) {
        ApiClient client = io.elepay.client.charge.Configuration.getDefaultApiClient();
        HttpBearerAuth bearer = (HttpBearerAuth) client.getAuthentication("bearerAuth");
        bearer.setBearerToken(props.getSecretKey());
        return client;
    }

    @Bean
    public ChargeApi chargeApi(ApiClient client) {
        return new ChargeApi(client);
    }
}
