package io.elepay.client.charge.api;

import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiResponse;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.Pair;

import javax.ws.rs.core.GenericType;

import io.elepay.client.charge.pojo.InvoiceDto;
import io.elepay.client.charge.pojo.InvoiceReq;
import io.elepay.client.charge.pojo.InvoiceStatusType;
import io.elepay.client.charge.pojo.InvoicesResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InvoiceApi {
  private ApiClient apiClient;

  public InvoiceApi() {
    this(Configuration.getDefaultApiClient());
  }

  public InvoiceApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * cancel invoice
   * インボイスを中止します。
   * @param invoiceId Invoice ID (required)
   * @return InvoiceDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public InvoiceDto cancelInvoice(String invoiceId) throws ApiException {
    return cancelInvoiceWithHttpInfo(invoiceId).getData();
      }

  /**
   * cancel invoice
   * インボイスを中止します。
   * @param invoiceId Invoice ID (required)
   * @return ApiResponse&lt;InvoiceDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InvoiceDto> cancelInvoiceWithHttpInfo(String invoiceId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'invoiceId' is set
    if (invoiceId == null) {
      throw new ApiException(400, "Missing the required parameter 'invoiceId' when calling cancelInvoice");
    }
    
    // create path and map variables
    String localVarPath = "/invoices/{invoiceId}/cancel"
      .replaceAll("\\{" + "invoiceId" + "\\}", apiClient.escapeString(invoiceId.toString()));

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

    String[] localVarAuthNames = new String[] { "basicAuth" };

    GenericType<InvoiceDto> localVarReturnType = new GenericType<InvoiceDto>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Create invoice
   * インボイスを作成します。
   * @param invoiceReq インボイスリクエスト (required)
   * @return InvoiceDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
   */
  public InvoiceDto createInvoice(InvoiceReq invoiceReq) throws ApiException {
    return createInvoiceWithHttpInfo(invoiceReq).getData();
      }

  /**
   * Create invoice
   * インボイスを作成します。
   * @param invoiceReq インボイスリクエスト (required)
   * @return ApiResponse&lt;InvoiceDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InvoiceDto> createInvoiceWithHttpInfo(InvoiceReq invoiceReq) throws ApiException {
    Object localVarPostBody = invoiceReq;
    
    // verify the required parameter 'invoiceReq' is set
    if (invoiceReq == null) {
      throw new ApiException(400, "Missing the required parameter 'invoiceReq' when calling createInvoice");
    }
    
    // create path and map variables
    String localVarPath = "/invoices";

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

    String[] localVarAuthNames = new String[] { "basicAuth" };

    GenericType<InvoiceDto> localVarReturnType = new GenericType<InvoiceDto>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Delete invoice
   * インボイスを削除します
   * @param invoiceId Invoice ID (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Deleted </td><td>  -  </td></tr>
     </table>
   */
  public void deleteInvoice(String invoiceId) throws ApiException {

    deleteInvoiceWithHttpInfo(invoiceId);
  }

  /**
   * Delete invoice
   * インボイスを削除します
   * @param invoiceId Invoice ID (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Deleted </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteInvoiceWithHttpInfo(String invoiceId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'invoiceId' is set
    if (invoiceId == null) {
      throw new ApiException(400, "Missing the required parameter 'invoiceId' when calling deleteInvoice");
    }
    
    // create path and map variables
    String localVarPath = "/invoices/{invoiceId}"
      .replaceAll("\\{" + "invoiceId" + "\\}", apiClient.escapeString(invoiceId.toString()));

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

    String[] localVarAuthNames = new String[] { "basicAuth" };


    return apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * List invoices
   * インボイス情報を一覧で取得します。
   * @param keyword keyword (optional)
   * @param from dateRange from (optional)
   * @param to dateRange from (optional)
   * @param status status (optional, default to new ArrayList&lt;&gt;())
   * @param limit 最大件数 (optional, default to 20)
   * @param offset 検索開始位置 (optional, default to 0)
   * @return InvoicesResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public InvoicesResponse listInvoices(String keyword, Long from, Long to, List<InvoiceStatusType> status, Integer limit, Integer offset) throws ApiException {
    return listInvoicesWithHttpInfo(keyword, from, to, status, limit, offset).getData();
      }

  /**
   * List invoices
   * インボイス情報を一覧で取得します。
   * @param keyword keyword (optional)
   * @param from dateRange from (optional)
   * @param to dateRange from (optional)
   * @param status status (optional, default to new ArrayList&lt;&gt;())
   * @param limit 最大件数 (optional, default to 20)
   * @param offset 検索開始位置 (optional, default to 0)
   * @return ApiResponse&lt;InvoicesResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InvoicesResponse> listInvoicesWithHttpInfo(String keyword, Long from, Long to, List<InvoiceStatusType> status, Integer limit, Integer offset) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/invoices";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "keyword", keyword));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "from", from));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "to", to));
    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "status", status));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));

    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=utf-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth" };

    GenericType<InvoicesResponse> localVarReturnType = new GenericType<InvoicesResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retrieve invoice
   * インボイス情報を取得します。
   * @param invoiceId Invoice ID (required)
   * @return InvoiceDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public InvoiceDto retrieveInvoice(String invoiceId) throws ApiException {
    return retrieveInvoiceWithHttpInfo(invoiceId).getData();
      }

  /**
   * Retrieve invoice
   * インボイス情報を取得します。
   * @param invoiceId Invoice ID (required)
   * @return ApiResponse&lt;InvoiceDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InvoiceDto> retrieveInvoiceWithHttpInfo(String invoiceId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'invoiceId' is set
    if (invoiceId == null) {
      throw new ApiException(400, "Missing the required parameter 'invoiceId' when calling retrieveInvoice");
    }
    
    // create path and map variables
    String localVarPath = "/invoices/{invoiceId}"
      .replaceAll("\\{" + "invoiceId" + "\\}", apiClient.escapeString(invoiceId.toString()));

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

    String[] localVarAuthNames = new String[] { "basicAuth" };

    GenericType<InvoiceDto> localVarReturnType = new GenericType<InvoiceDto>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * send invoice
   * send invoice
   * @param invoiceId invoice id (required)
   * @return InvoiceDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> Accept </td><td>  -  </td></tr>
     </table>
   */
  public InvoiceDto sendInvoice(String invoiceId) throws ApiException {
    return sendInvoiceWithHttpInfo(invoiceId).getData();
      }

  /**
   * send invoice
   * send invoice
   * @param invoiceId invoice id (required)
   * @return ApiResponse&lt;InvoiceDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 202 </td><td> Accept </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InvoiceDto> sendInvoiceWithHttpInfo(String invoiceId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'invoiceId' is set
    if (invoiceId == null) {
      throw new ApiException(400, "Missing the required parameter 'invoiceId' when calling sendInvoice");
    }
    
    // create path and map variables
    String localVarPath = "/invoices/{invoiceId}/send"
      .replaceAll("\\{" + "invoiceId" + "\\}", apiClient.escapeString(invoiceId.toString()));

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

    String[] localVarAuthNames = new String[] { "basicAuth" };

    GenericType<InvoiceDto> localVarReturnType = new GenericType<InvoiceDto>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Update invoice
   * インボイス情報を更新します。
   * @param invoiceId Invoice ID (required)
   * @param invoiceReq インボイスリクエスト (required)
   * @return InvoiceDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public InvoiceDto updateInvoice(String invoiceId, InvoiceReq invoiceReq) throws ApiException {
    return updateInvoiceWithHttpInfo(invoiceId, invoiceReq).getData();
      }

  /**
   * Update invoice
   * インボイス情報を更新します。
   * @param invoiceId Invoice ID (required)
   * @param invoiceReq インボイスリクエスト (required)
   * @return ApiResponse&lt;InvoiceDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<InvoiceDto> updateInvoiceWithHttpInfo(String invoiceId, InvoiceReq invoiceReq) throws ApiException {
    Object localVarPostBody = invoiceReq;
    
    // verify the required parameter 'invoiceId' is set
    if (invoiceId == null) {
      throw new ApiException(400, "Missing the required parameter 'invoiceId' when calling updateInvoice");
    }
    
    // verify the required parameter 'invoiceReq' is set
    if (invoiceReq == null) {
      throw new ApiException(400, "Missing the required parameter 'invoiceReq' when calling updateInvoice");
    }
    
    // create path and map variables
    String localVarPath = "/invoices/{invoiceId}"
      .replaceAll("\\{" + "invoiceId" + "\\}", apiClient.escapeString(invoiceId.toString()));

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

    String[] localVarAuthNames = new String[] { "basicAuth" };

    GenericType<InvoiceDto> localVarReturnType = new GenericType<InvoiceDto>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
