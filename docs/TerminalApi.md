# TerminalApi

All URIs are relative to *https://api.elepay.io*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createReader**](TerminalApi.md#createReader) | **POST** /terminal/readers | create terminal reader |
| [**deleteReader**](TerminalApi.md#deleteReader) | **DELETE** /terminal/readers/{readerId} | delete reader |
| [**getReader**](TerminalApi.md#getReader) | **GET** /terminal/readers/{readerId} | get reader |
| [**listLocations**](TerminalApi.md#listLocations) | **GET** /terminal/locations | list locations |
| [**listReaders**](TerminalApi.md#listReaders) | **GET** /terminal/readers | list readers |



## createReader

> TerminalReaderDto createReader(terminalReaderReq)

create terminal reader

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.TerminalApi;

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

        TerminalApi apiInstance = new TerminalApi(defaultClient);
        TerminalReaderReq terminalReaderReq = new TerminalReaderReq(); // TerminalReaderReq | 
        try {
            TerminalReaderDto result = apiInstance.createReader(terminalReaderReq);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminalApi#createReader");
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
| **terminalReaderReq** | [**TerminalReaderReq**](TerminalReaderReq.md)|  | |

### Return type

[**TerminalReaderDto**](TerminalReaderDto.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json;charset=utf-8
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | OK |  -  |


## deleteReader

> deleteReader(readerId)

delete reader

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.TerminalApi;

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

        TerminalApi apiInstance = new TerminalApi(defaultClient);
        String readerId = "readerId_example"; // String | reader Id
        try {
            apiInstance.deleteReader(readerId);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminalApi#deleteReader");
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
| **readerId** | **String**| reader Id | |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Deleted |  -  |


## getReader

> TerminalReaderDto getReader(readerId)

get reader

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.TerminalApi;

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

        TerminalApi apiInstance = new TerminalApi(defaultClient);
        String readerId = "readerId_example"; // String | reader Id
        try {
            TerminalReaderDto result = apiInstance.getReader(readerId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminalApi#getReader");
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
| **readerId** | **String**| reader Id | |

### Return type

[**TerminalReaderDto**](TerminalReaderDto.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## listLocations

> LocationsResponse listLocations()

list locations

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.TerminalApi;

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

        TerminalApi apiInstance = new TerminalApi(defaultClient);
        try {
            LocationsResponse result = apiInstance.listLocations();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminalApi#listLocations");
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

[**LocationsResponse**](LocationsResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## listReaders

> TerminalReadersResponse listReaders(limit, offset)

list readers

### Example

```java
// Import classes:
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.models.*;
import io.elepay.client.charge.api.TerminalApi;

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

        TerminalApi apiInstance = new TerminalApi(defaultClient);
        Integer limit = 20; // Integer | 最大件数
        Integer offset = 0; // Integer | 検索開始位置
        try {
            TerminalReadersResponse result = apiInstance.listReaders(limit, offset);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TerminalApi#listReaders");
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
| **limit** | **Integer**| 最大件数 | [optional] [default to 20] |
| **offset** | **Integer**| 検索開始位置 | [optional] [default to 0] |

### Return type

[**TerminalReadersResponse**](TerminalReadersResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=utf-8


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

