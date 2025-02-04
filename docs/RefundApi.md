# RefundApi

All URIs are relative to *https://api.elepay.io*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createRefund**](RefundApi.md#createRefund) | **POST** /charges/{id}/refunds | Create refund |
| [**listChargesRefunds**](RefundApi.md#listChargesRefunds) | **GET** /charges/{id}/refunds | List refunds |
| [**retrieveChargeRefund**](RefundApi.md#retrieveChargeRefund) | **GET** /charges/{id}/refunds/{refundId} | Retrieve refund |



## createRefund

> RefundDto createRefund(id, refundReq)

Create refund

決済の全額あるいは一部の返金処理を行います。

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.RefundApi;

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

        RefundApi apiInstance = new RefundApi(defaultClient);
        String id = "id_example"; // String | Charge ID
        RefundReq refundReq = new RefundReq(); // RefundReq | 返金の詳細情報
        try {
            RefundDto result = apiInstance.createRefund(id, refundReq);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling RefundApi#createRefund");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| Charge ID | |
| **refundReq** | [**RefundReq**](RefundReq.md)| 返金の詳細情報 | |

### Return type

[**RefundDto**](RefundDto.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json;charset=utf-8
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |


## listChargesRefunds

> RefundsResponse listChargesRefunds(id)

List refunds

返金に関する情報を一覧で取得します。

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.RefundApi;

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

        RefundApi apiInstance = new RefundApi(defaultClient);
        String id = "id_example"; // String | Charge ID
        try {
            RefundsResponse result = apiInstance.listChargesRefunds(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling RefundApi#listChargesRefunds");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| Charge ID | |

### Return type

[**RefundsResponse**](RefundsResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## retrieveChargeRefund

> RefundDto retrieveChargeRefund(id, refundId)

Retrieve refund

返金に関する詳細情報を取得します。

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.RefundApi;

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

        RefundApi apiInstance = new RefundApi(defaultClient);
        String id = "id_example"; // String | Charge ID
        String refundId = "refundId_example"; // String | Refund ID
        try {
            RefundDto result = apiInstance.retrieveChargeRefund(id, refundId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling RefundApi#retrieveChargeRefund");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| Charge ID | |
| **refundId** | **String**| Refund ID | |

### Return type

[**RefundDto**](RefundDto.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

