# DisputeApi

All URIs are relative to *https://api.elepay.io*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**listDisputes**](DisputeApi.md#listDisputes) | **GET** /disputes | List disputes |
| [**retrieveDispute**](DisputeApi.md#retrieveDispute) | **GET** /disputes/{id} | Retrieve dispute |



## listDisputes

> DisputesResponse listDisputes(chargeId, from, to, dateField, status, limit, offset, sort, order)

List disputes

不審請求情報を一覧で取得します

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.DisputeApi;

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

        DisputeApi apiInstance = new DisputeApi(defaultClient);
        String chargeId = "chargeId_example"; // String | Charge ID
        Long from = 56L; // Long | 開始時間（UTC）。指定した時間以降に作成されたデータを取得します。
        Long to = 56L; // Long | 終了時間（UTC）。指定した時間以前に作成されたデータを取得します
        DisputeDateTimeType dateField = DisputeDateTimeType.fromValue("resolved_time"); // DisputeDateTimeType | 開始時間と終了時間の項目を指定します。 - resolved_time 不審請求解決時間 - create_time 不審請求発生時間 
        DisputeStatusType status = DisputeStatusType.fromValue("new"); // DisputeStatusType | 不審請求ステータス
        Integer limit = 20; // Integer | 最大件数
        Integer offset = 0; // Integer | 検索開始位置
        DisputeDateTimeType sort = DisputeDateTimeType.fromValue("resolved_time"); // DisputeDateTimeType | ソート項目 - resolved_time 不審請求解決時間 - create_time 決済新規時間 
        SortOrderType order = SortOrderType.fromValue("desc"); // SortOrderType | ソート順 - desc 降順 - asc 昇順 
        try {
            DisputesResponse result = apiInstance.listDisputes(chargeId, from, to, dateField, status, limit, offset, sort, order);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DisputeApi#listDisputes");
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
| **chargeId** | **String**| Charge ID | [optional] |
| **from** | **Long**| 開始時間（UTC）。指定した時間以降に作成されたデータを取得します。 | [optional] |
| **to** | **Long**| 終了時間（UTC）。指定した時間以前に作成されたデータを取得します | [optional] |
| **dateField** | [**DisputeDateTimeType**](.md)| 開始時間と終了時間の項目を指定します。 - resolved_time 不審請求解決時間 - create_time 不審請求発生時間  | [optional] [default to create_time] [enum: resolved_time, create_time] |
| **status** | [**DisputeStatusType**](.md)| 不審請求ステータス | [optional] [enum: new, won, lost] |
| **limit** | **Integer**| 最大件数 | [optional] [default to 20] |
| **offset** | **Integer**| 検索開始位置 | [optional] [default to 0] |
| **sort** | [**DisputeDateTimeType**](.md)| ソート項目 - resolved_time 不審請求解決時間 - create_time 決済新規時間  | [optional] [default to create_time] [enum: resolved_time, create_time] |
| **order** | [**SortOrderType**](.md)| ソート順 - desc 降順 - asc 昇順  | [optional] [default to desc] [enum: desc, asc] |

### Return type

[**DisputesResponse**](DisputesResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## retrieveDispute

> DisputeDto retrieveDispute(id)

Retrieve dispute

不審請求に関する詳細情報を取得します。

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.DisputeApi;

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

        DisputeApi apiInstance = new DisputeApi(defaultClient);
        String id = "id_example"; // String | Dispute ID
        try {
            DisputeDto result = apiInstance.retrieveDispute(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DisputeApi#retrieveDispute");
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
| **id** | **String**| Dispute ID | |

### Return type

[**DisputeDto**](DisputeDto.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

