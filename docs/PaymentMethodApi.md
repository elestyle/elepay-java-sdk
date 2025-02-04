# PaymentMethodApi

All URIs are relative to *https://api.elepay.io*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**listPaymentMethods**](PaymentMethodApi.md#listPaymentMethods) | **GET** /payment-methods | List supported payment methods |



## listPaymentMethods

> PaymentMethodResponse listPaymentMethods()

List supported payment methods

利用できる決済方法を取得します。

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.PaymentMethodApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.elepay.io");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PaymentMethodApi apiInstance = new PaymentMethodApi(defaultClient);
        try {
            PaymentMethodResponse result = apiInstance.listPaymentMethods();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PaymentMethodApi#listPaymentMethods");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**PaymentMethodResponse**](PaymentMethodResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

