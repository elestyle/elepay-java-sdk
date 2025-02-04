# ChargeApi

All URIs are relative to *https://api.elepay.io*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**captureCharge**](ChargeApi.md#captureCharge) | **POST** /charges/{id}/capture | Capture charge |
| [**createCharge**](ChargeApi.md#createCharge) | **POST** /charges | Create charge |
| [**listCharges**](ChargeApi.md#listCharges) | **GET** /charges | List charges |
| [**retrieveCharge**](ChargeApi.md#retrieveCharge) | **GET** /charges/{id} | Retrieve charge |
| [**retrieveChargeStatus**](ChargeApi.md#retrieveChargeStatus) | **GET** /charges/{id}/status | Retrieve charge&#39;s status |
| [**revokeCharge**](ChargeApi.md#revokeCharge) | **POST** /charges/{id}/revoke | Revoke charge |



## captureCharge

> ChargeDto captureCharge(id, chargeCaptureReq)

Capture charge

決済を確定します。

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.ChargeApi;

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

        ChargeApi apiInstance = new ChargeApi(defaultClient);
        String id = "id_example"; // String | Charge ID
        ChargeCaptureReq chargeCaptureReq = new ChargeCaptureReq(); // ChargeCaptureReq | 
        try {
            ChargeDto result = apiInstance.captureCharge(id, chargeCaptureReq);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChargeApi#captureCharge");
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
| **chargeCaptureReq** | [**ChargeCaptureReq**](ChargeCaptureReq.md)|  | [optional] |

### Return type

[**ChargeDto**](ChargeDto.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json;charset=utf-8
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## createCharge

> ChargeDto createCharge(chargeReq)

Create charge

決済処理を行います。

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.ChargeApi;

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

        ChargeApi apiInstance = new ChargeApi(defaultClient);
        ChargeReq chargeReq = new ChargeReq(); // ChargeReq | 支払リクエスト
        try {
            ChargeDto result = apiInstance.createCharge(chargeReq);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChargeApi#createCharge");
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
| **chargeReq** | [**ChargeReq**](ChargeReq.md)| 支払リクエスト | |

### Return type

[**ChargeDto**](ChargeDto.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json;charset=utf-8
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |


## listCharges

> ChargesResponse listCharges(paymentMethod, from, to, dateField, status, limit, offset, sort, order)

List charges

決済に関する情報を一覧で取得します。

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.ChargeApi;

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

        ChargeApi apiInstance = new ChargeApi(defaultClient);
        List<PaymentMethodType> paymentMethod = Arrays.asList(); // List<PaymentMethodType> | 決済方法(複数の指定が可能です)
        Long from = 56L; // Long | 開始時間（UTC）。指定した時間以降に作成されたデータを取得します。
        Long to = 56L; // Long | 終了時間（UTC）。指定した時間以前に作成されたデータを取得します
        ChargeDateTimeType dateField = ChargeDateTimeType.fromValue("paid_time"); // ChargeDateTimeType | 開始時間と終了時間の項目を指定します。 - paid_time 払う時間 - create_time 決済新規時間 
        ChargeStatusType status = ChargeStatusType.fromValue("pending"); // ChargeStatusType | 支払状況
        Integer limit = 20; // Integer | 最大件数
        Integer offset = 0; // Integer | 検索開始位置
        ChargeDateTimeType sort = ChargeDateTimeType.fromValue("paid_time"); // ChargeDateTimeType | ソート項目 - paid_time 払う時間 - create_time 決済新規時間 
        SortOrderType order = SortOrderType.fromValue("desc"); // SortOrderType | ソート順 - desc 降順 - asc 昇順 
        try {
            ChargesResponse result = apiInstance.listCharges(paymentMethod, from, to, dateField, status, limit, offset, sort, order);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChargeApi#listCharges");
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
| **paymentMethod** | [**List&lt;PaymentMethodType&gt;**](PaymentMethodType.md)| 決済方法(複数の指定が可能です) | [optional] |
| **from** | **Long**| 開始時間（UTC）。指定した時間以降に作成されたデータを取得します。 | [optional] |
| **to** | **Long**| 終了時間（UTC）。指定した時間以前に作成されたデータを取得します | [optional] |
| **dateField** | [**ChargeDateTimeType**](.md)| 開始時間と終了時間の項目を指定します。 - paid_time 払う時間 - create_time 決済新規時間  | [optional] [default to create_time] [enum: paid_time, create_time] |
| **status** | [**ChargeStatusType**](.md)| 支払状況 | [optional] [enum: pending, uncaptured, captured, partially_refunded, refunded, revoked] |
| **limit** | **Integer**| 最大件数 | [optional] [default to 20] |
| **offset** | **Integer**| 検索開始位置 | [optional] [default to 0] |
| **sort** | [**ChargeDateTimeType**](.md)| ソート項目 - paid_time 払う時間 - create_time 決済新規時間  | [optional] [default to create_time] [enum: paid_time, create_time] |
| **order** | [**SortOrderType**](.md)| ソート順 - desc 降順 - asc 昇順  | [optional] [default to desc] [enum: desc, asc] |

### Return type

[**ChargesResponse**](ChargesResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## retrieveCharge

> ChargeDto retrieveCharge(id)

Retrieve charge

決済に関する詳細情報を取得します。

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.ChargeApi;

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

        ChargeApi apiInstance = new ChargeApi(defaultClient);
        String id = "id_example"; // String | Charge ID
        try {
            ChargeDto result = apiInstance.retrieveCharge(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChargeApi#retrieveCharge");
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

[**ChargeDto**](ChargeDto.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## retrieveChargeStatus

> ChargeStatusDto retrieveChargeStatus(id)

Retrieve charge&#39;s status

決済のステータスに関する詳細情報を取得します。

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.ChargeApi;

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

        ChargeApi apiInstance = new ChargeApi(defaultClient);
        String id = "id_example"; // String | Charge ID
        try {
            ChargeStatusDto result = apiInstance.retrieveChargeStatus(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChargeApi#retrieveChargeStatus");
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

[**ChargeStatusDto**](ChargeStatusDto.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## revokeCharge

> ChargeDto revokeCharge(id)

Revoke charge

決済を取消します。

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.ChargeApi;

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

        ChargeApi apiInstance = new ChargeApi(defaultClient);
        String id = "id_example"; // String | Charge ID
        try {
            ChargeDto result = apiInstance.revokeCharge(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChargeApi#revokeCharge");
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

[**ChargeDto**](ChargeDto.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

