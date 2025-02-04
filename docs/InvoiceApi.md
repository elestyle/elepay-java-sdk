# InvoiceApi

All URIs are relative to *https://api.elepay.io*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**cancelInvoice**](InvoiceApi.md#cancelInvoice) | **POST** /invoices/{invoiceId}/cancel | Cancel invoice |
| [**createInvoice**](InvoiceApi.md#createInvoice) | **POST** /invoices | Create invoice |
| [**listInvoices**](InvoiceApi.md#listInvoices) | **GET** /invoices | List invoices |
| [**retrieveInvoice**](InvoiceApi.md#retrieveInvoice) | **GET** /invoices/{invoiceId} | Retrieve invoice |
| [**sendInvoice**](InvoiceApi.md#sendInvoice) | **POST** /invoices/{invoiceId}/send | send invoice |
| [**submitInvoice**](InvoiceApi.md#submitInvoice) | **POST** /invoices/{invoiceId}/submit | Submit invoice |
| [**updateInvoice**](InvoiceApi.md#updateInvoice) | **POST** /invoices/{invoiceId} | Update invoice |



## cancelInvoice

> InvoiceDto cancelInvoice(invoiceId)

Cancel invoice

インボイスを中止します。

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.InvoiceApi;

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

        InvoiceApi apiInstance = new InvoiceApi(defaultClient);
        String invoiceId = "invoiceId_example"; // String | Invoice ID
        try {
            InvoiceDto result = apiInstance.cancelInvoice(invoiceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InvoiceApi#cancelInvoice");
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
| **invoiceId** | **String**| Invoice ID | |

### Return type

[**InvoiceDto**](InvoiceDto.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## createInvoice

> InvoiceDto createInvoice(invoiceReq)

Create invoice

インボイスを作成します。

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.InvoiceApi;

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

        InvoiceApi apiInstance = new InvoiceApi(defaultClient);
        InvoiceReq invoiceReq = new InvoiceReq(); // InvoiceReq | インボイスリクエスト
        try {
            InvoiceDto result = apiInstance.createInvoice(invoiceReq);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InvoiceApi#createInvoice");
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
| **invoiceReq** | [**InvoiceReq**](InvoiceReq.md)| インボイスリクエスト | |

### Return type

[**InvoiceDto**](InvoiceDto.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json;charset=utf-8
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |


## listInvoices

> InvoicesResponse listInvoices(keyword, from, to, status, limit, offset)

List invoices

インボイス情報を一覧で取得します。

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.InvoiceApi;

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

        InvoiceApi apiInstance = new InvoiceApi(defaultClient);
        String keyword = "keyword_example"; // String | キーワード
        Long from = 56L; // Long | dateRange from
        Long to = 56L; // Long | dateRange from
        List<InvoiceStatusType> status = Arrays.asList(); // List<InvoiceStatusType> | status
        Integer limit = 20; // Integer | 最大件数
        Integer offset = 0; // Integer | 検索開始位置
        try {
            InvoicesResponse result = apiInstance.listInvoices(keyword, from, to, status, limit, offset);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InvoiceApi#listInvoices");
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
| **keyword** | **String**| キーワード | [optional] |
| **from** | **Long**| dateRange from | [optional] |
| **to** | **Long**| dateRange from | [optional] |
| **status** | [**List&lt;InvoiceStatusType&gt;**](InvoiceStatusType.md)| status | [optional] |
| **limit** | **Integer**| 最大件数 | [optional] [default to 20] |
| **offset** | **Integer**| 検索開始位置 | [optional] [default to 0] |

### Return type

[**InvoicesResponse**](InvoicesResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## retrieveInvoice

> InvoiceDto retrieveInvoice(invoiceId)

Retrieve invoice

インボイス情報を取得します。

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.InvoiceApi;

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

        InvoiceApi apiInstance = new InvoiceApi(defaultClient);
        String invoiceId = "invoiceId_example"; // String | Invoice ID
        try {
            InvoiceDto result = apiInstance.retrieveInvoice(invoiceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InvoiceApi#retrieveInvoice");
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
| **invoiceId** | **String**| Invoice ID | |

### Return type

[**InvoiceDto**](InvoiceDto.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## sendInvoice

> InvoiceDto sendInvoice(invoiceId)

send invoice

インボイスを送信します。

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.InvoiceApi;

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

        InvoiceApi apiInstance = new InvoiceApi(defaultClient);
        String invoiceId = "invoiceId_example"; // String | invoice id
        try {
            InvoiceDto result = apiInstance.sendInvoice(invoiceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InvoiceApi#sendInvoice");
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
| **invoiceId** | **String**| invoice id | |

### Return type

[**InvoiceDto**](InvoiceDto.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Accept |  -  |


## submitInvoice

> InvoiceDto submitInvoice(invoiceId)

Submit invoice

インボイスを確定します。

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.InvoiceApi;

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

        InvoiceApi apiInstance = new InvoiceApi(defaultClient);
        String invoiceId = "invoiceId_example"; // String | Invoice ID
        try {
            InvoiceDto result = apiInstance.submitInvoice(invoiceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InvoiceApi#submitInvoice");
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
| **invoiceId** | **String**| Invoice ID | |

### Return type

[**InvoiceDto**](InvoiceDto.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## updateInvoice

> InvoiceDto updateInvoice(invoiceId, invoiceReq)

Update invoice

インボイス情報を更新します。

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.InvoiceApi;

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

        InvoiceApi apiInstance = new InvoiceApi(defaultClient);
        String invoiceId = "invoiceId_example"; // String | Invoice ID
        InvoiceReq invoiceReq = new InvoiceReq(); // InvoiceReq | インボイスリクエスト
        try {
            InvoiceDto result = apiInstance.updateInvoice(invoiceId, invoiceReq);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling InvoiceApi#updateInvoice");
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
| **invoiceId** | **String**| Invoice ID | |
| **invoiceReq** | [**InvoiceReq**](InvoiceReq.md)| インボイスリクエスト | |

### Return type

[**InvoiceDto**](InvoiceDto.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json;charset=utf-8
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

