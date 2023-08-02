package io.elepay.client.charge.api;

import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiResponse;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.Pair;

import javax.ws.rs.core.GenericType;

import io.elepay.client.charge.pojo.RefundDto;
import io.elepay.client.charge.pojo.RefundReq;
import io.elepay.client.charge.pojo.RefundsResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RefundApi {
  private ApiClient apiClient;

  public RefundApi() {
    this(Configuration.getDefaultApiClient());
  }

  public RefundApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Create refund
   * 決済の全額あるいは一部の返金処理を行います。
   * @param id Charge ID (required)
   * @param refundReq 返金の詳細情報 (required)
   * @return RefundDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
   */
  public RefundDto createRefund(String id, RefundReq refundReq) throws ApiException {
    return createRefundWithHttpInfo(id, refundReq).getData();
      }

  /**
   * Create refund
   * 決済の全額あるいは一部の返金処理を行います。
   * @param id Charge ID (required)
   * @param refundReq 返金の詳細情報 (required)
   * @return ApiResponse&lt;RefundDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<RefundDto> createRefundWithHttpInfo(String id, RefundReq refundReq) throws ApiException {
    Object localVarPostBody = refundReq;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling createRefund");
    }
    
    // verify the required parameter 'refundReq' is set
    if (refundReq == null) {
      throw new ApiException(400, "Missing the required parameter 'refundReq' when calling createRefund");
    }
    
    // create path and map variables
    String localVarPath = "/charges/{id}/refunds"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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

    GenericType<RefundDto> localVarReturnType = new GenericType<RefundDto>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List refunds
   * 返金に関する情報を一覧で取得します。
   * @param id Charge ID (required)
   * @return RefundsResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public RefundsResponse listChargesRefunds(String id) throws ApiException {
    return listChargesRefundsWithHttpInfo(id).getData();
      }

  /**
   * List refunds
   * 返金に関する情報を一覧で取得します。
   * @param id Charge ID (required)
   * @return ApiResponse&lt;RefundsResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<RefundsResponse> listChargesRefundsWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling listChargesRefunds");
    }
    
    // create path and map variables
    String localVarPath = "/charges/{id}/refunds"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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

    GenericType<RefundsResponse> localVarReturnType = new GenericType<RefundsResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retrieve refund
   * 返金に関する詳細情報を取得します。
   * @param id Charge ID (required)
   * @param refundId Refund ID (required)
   * @return RefundDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public RefundDto retrieveChargeRefund(String id, String refundId) throws ApiException {
    return retrieveChargeRefundWithHttpInfo(id, refundId).getData();
      }

  /**
   * Retrieve refund
   * 返金に関する詳細情報を取得します。
   * @param id Charge ID (required)
   * @param refundId Refund ID (required)
   * @return ApiResponse&lt;RefundDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<RefundDto> retrieveChargeRefundWithHttpInfo(String id, String refundId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling retrieveChargeRefund");
    }
    
    // verify the required parameter 'refundId' is set
    if (refundId == null) {
      throw new ApiException(400, "Missing the required parameter 'refundId' when calling retrieveChargeRefund");
    }
    
    // create path and map variables
    String localVarPath = "/charges/{id}/refunds/{refundId}"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()))
      .replaceAll("\\{" + "refundId" + "\\}", apiClient.escapeString(refundId.toString()));

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

    GenericType<RefundDto> localVarReturnType = new GenericType<RefundDto>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
