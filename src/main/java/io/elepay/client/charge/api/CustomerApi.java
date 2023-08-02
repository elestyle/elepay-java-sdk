package io.elepay.client.charge.api;

import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiResponse;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.Pair;

import javax.ws.rs.core.GenericType;

import io.elepay.client.charge.pojo.CustomerDto;
import io.elepay.client.charge.pojo.CustomerReq;
import io.elepay.client.charge.pojo.CustomerResponse;
import io.elepay.client.charge.pojo.PaymentMethodType;
import io.elepay.client.charge.pojo.SourceDto;
import io.elepay.client.charge.pojo.SourceReq;
import io.elepay.client.charge.pojo.SourceResponse;
import io.elepay.client.charge.pojo.SourceStatusDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CustomerApi {
  private ApiClient apiClient;

  public CustomerApi() {
    this(Configuration.getDefaultApiClient());
  }

  public CustomerApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Create customer
   * カスタマを作成します。
   * @param customerReq カスタマリクエスト (required)
   * @return CustomerDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
   */
  public CustomerDto createCustomer(CustomerReq customerReq) throws ApiException {
    return createCustomerWithHttpInfo(customerReq).getData();
      }

  /**
   * Create customer
   * カスタマを作成します。
   * @param customerReq カスタマリクエスト (required)
   * @return ApiResponse&lt;CustomerDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CustomerDto> createCustomerWithHttpInfo(CustomerReq customerReq) throws ApiException {
    Object localVarPostBody = customerReq;
    
    // verify the required parameter 'customerReq' is set
    if (customerReq == null) {
      throw new ApiException(400, "Missing the required parameter 'customerReq' when calling createCustomer");
    }
    
    // create path and map variables
    String localVarPath = "/customers";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=utf-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json;charset=utf-8"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    GenericType<CustomerDto> localVarReturnType = new GenericType<CustomerDto>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Create source
   * カスタマソースを作成します。
   * @param customerId Customer ID (required)
   * @param sourceReq カスタマソースリクエスト (required)
   * @return SourceDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public SourceDto createSource(String customerId, SourceReq sourceReq) throws ApiException {
    return createSourceWithHttpInfo(customerId, sourceReq).getData();
      }

  /**
   * Create source
   * カスタマソースを作成します。
   * @param customerId Customer ID (required)
   * @param sourceReq カスタマソースリクエスト (required)
   * @return ApiResponse&lt;SourceDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SourceDto> createSourceWithHttpInfo(String customerId, SourceReq sourceReq) throws ApiException {
    Object localVarPostBody = sourceReq;
    
    // verify the required parameter 'customerId' is set
    if (customerId == null) {
      throw new ApiException(400, "Missing the required parameter 'customerId' when calling createSource");
    }
    
    // verify the required parameter 'sourceReq' is set
    if (sourceReq == null) {
      throw new ApiException(400, "Missing the required parameter 'sourceReq' when calling createSource");
    }
    
    // create path and map variables
    String localVarPath = "/customers/{customerId}/sources"
      .replaceAll("\\{" + "customerId" + "\\}", apiClient.escapeString(customerId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=utf-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json;charset=utf-8"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    GenericType<SourceDto> localVarReturnType = new GenericType<SourceDto>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Delete customer
   * カスタマを削除します
   * @param customerId Customer ID (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Deleted </td><td>  -  </td></tr>
     </table>
   */
  public void deleteCustomer(String customerId) throws ApiException {

    deleteCustomerWithHttpInfo(customerId);
  }

  /**
   * Delete customer
   * カスタマを削除します
   * @param customerId Customer ID (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Deleted </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteCustomerWithHttpInfo(String customerId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'customerId' is set
    if (customerId == null) {
      throw new ApiException(400, "Missing the required parameter 'customerId' when calling deleteCustomer");
    }
    
    // create path and map variables
    String localVarPath = "/customers/{customerId}"
      .replaceAll("\\{" + "customerId" + "\\}", apiClient.escapeString(customerId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };


    return apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Delete source
   * カスタマソースを削除します。
   * @param customerId Customer ID (required)
   * @param sourceId Source ID (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Deleted </td><td>  -  </td></tr>
     </table>
   */
  public void deleteSource(String customerId, String sourceId) throws ApiException {

    deleteSourceWithHttpInfo(customerId, sourceId);
  }

  /**
   * Delete source
   * カスタマソースを削除します。
   * @param customerId Customer ID (required)
   * @param sourceId Source ID (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Deleted </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteSourceWithHttpInfo(String customerId, String sourceId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'customerId' is set
    if (customerId == null) {
      throw new ApiException(400, "Missing the required parameter 'customerId' when calling deleteSource");
    }
    
    // verify the required parameter 'sourceId' is set
    if (sourceId == null) {
      throw new ApiException(400, "Missing the required parameter 'sourceId' when calling deleteSource");
    }
    
    // create path and map variables
    String localVarPath = "/customers/{customerId}/sources/{sourceId}"
      .replaceAll("\\{" + "customerId" + "\\}", apiClient.escapeString(customerId.toString()))
      .replaceAll("\\{" + "sourceId" + "\\}", apiClient.escapeString(sourceId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };


    return apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * List customers
   * カスタマ情報を一覧で取得します。
   * @param keyword キーワード (optional)
   * @param limit 最大件数 (optional, default to 20)
   * @param offset 検索開始位置 (optional, default to 0)
   * @return CustomerResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public CustomerResponse listCustomers(String keyword, Integer limit, Integer offset) throws ApiException {
    return listCustomersWithHttpInfo(keyword, limit, offset).getData();
      }

  /**
   * List customers
   * カスタマ情報を一覧で取得します。
   * @param keyword キーワード (optional)
   * @param limit 最大件数 (optional, default to 20)
   * @param offset 検索開始位置 (optional, default to 0)
   * @return ApiResponse&lt;CustomerResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CustomerResponse> listCustomersWithHttpInfo(String keyword, Integer limit, Integer offset) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/customers";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "keyword", keyword));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));

    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=utf-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    GenericType<CustomerResponse> localVarReturnType = new GenericType<CustomerResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List sources by customer ID
   * カスタマソース情報を一覧で取得します。
   * @param customerId Customer ID (required)
   * @param paymentMethod 決済方法 (optional)
   * @return SourceResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public SourceResponse listSources(String customerId, PaymentMethodType paymentMethod) throws ApiException {
    return listSourcesWithHttpInfo(customerId, paymentMethod).getData();
      }

  /**
   * List sources by customer ID
   * カスタマソース情報を一覧で取得します。
   * @param customerId Customer ID (required)
   * @param paymentMethod 決済方法 (optional)
   * @return ApiResponse&lt;SourceResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SourceResponse> listSourcesWithHttpInfo(String customerId, PaymentMethodType paymentMethod) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'customerId' is set
    if (customerId == null) {
      throw new ApiException(400, "Missing the required parameter 'customerId' when calling listSources");
    }
    
    // create path and map variables
    String localVarPath = "/customers/{customerId}/sources"
      .replaceAll("\\{" + "customerId" + "\\}", apiClient.escapeString(customerId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "paymentMethod", paymentMethod));

    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=utf-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    GenericType<SourceResponse> localVarReturnType = new GenericType<SourceResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retrieve customer
   * カスタマ情報を取得します。
   * @param customerId Customer ID (required)
   * @return CustomerDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public CustomerDto retrieveCustomer(String customerId) throws ApiException {
    return retrieveCustomerWithHttpInfo(customerId).getData();
      }

  /**
   * Retrieve customer
   * カスタマ情報を取得します。
   * @param customerId Customer ID (required)
   * @return ApiResponse&lt;CustomerDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CustomerDto> retrieveCustomerWithHttpInfo(String customerId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'customerId' is set
    if (customerId == null) {
      throw new ApiException(400, "Missing the required parameter 'customerId' when calling retrieveCustomer");
    }
    
    // create path and map variables
    String localVarPath = "/customers/{customerId}"
      .replaceAll("\\{" + "customerId" + "\\}", apiClient.escapeString(customerId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=utf-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    GenericType<CustomerDto> localVarReturnType = new GenericType<CustomerDto>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retrieve source
   * カスタマ情報を取得します。
   * @param customerId Customer ID (required)
   * @param sourceId Source ID (required)
   * @return SourceDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public SourceDto retrieveSource(String customerId, String sourceId) throws ApiException {
    return retrieveSourceWithHttpInfo(customerId, sourceId).getData();
      }

  /**
   * Retrieve source
   * カスタマ情報を取得します。
   * @param customerId Customer ID (required)
   * @param sourceId Source ID (required)
   * @return ApiResponse&lt;SourceDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SourceDto> retrieveSourceWithHttpInfo(String customerId, String sourceId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'customerId' is set
    if (customerId == null) {
      throw new ApiException(400, "Missing the required parameter 'customerId' when calling retrieveSource");
    }
    
    // verify the required parameter 'sourceId' is set
    if (sourceId == null) {
      throw new ApiException(400, "Missing the required parameter 'sourceId' when calling retrieveSource");
    }
    
    // create path and map variables
    String localVarPath = "/customers/{customerId}/sources/{sourceId}"
      .replaceAll("\\{" + "customerId" + "\\}", apiClient.escapeString(customerId.toString()))
      .replaceAll("\\{" + "sourceId" + "\\}", apiClient.escapeString(sourceId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=utf-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    GenericType<SourceDto> localVarReturnType = new GenericType<SourceDto>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retrieve source&#39;s status
   * カスタマソースのステータスに関する詳細情報を取得します。
   * @param sourceId Source ID (required)
   * @return SourceStatusDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public SourceStatusDto retrieveSourceStatus(String sourceId) throws ApiException {
    return retrieveSourceStatusWithHttpInfo(sourceId).getData();
      }

  /**
   * Retrieve source&#39;s status
   * カスタマソースのステータスに関する詳細情報を取得します。
   * @param sourceId Source ID (required)
   * @return ApiResponse&lt;SourceStatusDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SourceStatusDto> retrieveSourceStatusWithHttpInfo(String sourceId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'sourceId' is set
    if (sourceId == null) {
      throw new ApiException(400, "Missing the required parameter 'sourceId' when calling retrieveSourceStatus");
    }
    
    // create path and map variables
    String localVarPath = "/sources/{sourceId}/status"
      .replaceAll("\\{" + "sourceId" + "\\}", apiClient.escapeString(sourceId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=utf-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    GenericType<SourceStatusDto> localVarReturnType = new GenericType<SourceStatusDto>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Update customer
   * カスタマを更新します。
   * @param customerId Customer ID (required)
   * @param customerReq カスタマリクエスト (required)
   * @return CustomerDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public CustomerDto updateCustomer(String customerId, CustomerReq customerReq) throws ApiException {
    return updateCustomerWithHttpInfo(customerId, customerReq).getData();
      }

  /**
   * Update customer
   * カスタマを更新します。
   * @param customerId Customer ID (required)
   * @param customerReq カスタマリクエスト (required)
   * @return ApiResponse&lt;CustomerDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CustomerDto> updateCustomerWithHttpInfo(String customerId, CustomerReq customerReq) throws ApiException {
    Object localVarPostBody = customerReq;
    
    // verify the required parameter 'customerId' is set
    if (customerId == null) {
      throw new ApiException(400, "Missing the required parameter 'customerId' when calling updateCustomer");
    }
    
    // verify the required parameter 'customerReq' is set
    if (customerReq == null) {
      throw new ApiException(400, "Missing the required parameter 'customerReq' when calling updateCustomer");
    }
    
    // create path and map variables
    String localVarPath = "/customers/{customerId}"
      .replaceAll("\\{" + "customerId" + "\\}", apiClient.escapeString(customerId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=utf-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json;charset=utf-8"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth", "bearerAuth" };

    GenericType<CustomerDto> localVarReturnType = new GenericType<CustomerDto>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
