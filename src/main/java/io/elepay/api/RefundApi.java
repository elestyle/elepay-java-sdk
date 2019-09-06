package io.elepay.api;

import io.elepay.ApiException;
import io.elepay.ApiClient;
import io.elepay.ApiResponse;
import io.elepay.Configuration;
import io.elepay.Pair;

import javax.ws.rs.core.GenericType;

import io.elepay.pojo.ElepayRestError;
import io.elepay.pojo.RefundDto;
import io.elepay.pojo.RefundReq;
import io.elepay.pojo.RefundsResponse;

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
   * @param refund 返金の詳細情報 (required)
   * @return RefundDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
   */
  public RefundDto createRefund(String id, RefundReq refund) throws ApiException {
    return createRefundWithHttpInfo(id, refund).getData();
      }

  /**
   * Create refund
   * 決済の全額あるいは一部の返金処理を行います。
   * @param id Charge ID (required)
   * @param refund 返金の詳細情報 (required)
   * @return ApiResponse&lt;RefundDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<RefundDto> createRefundWithHttpInfo(String id, RefundReq refund) throws ApiException {
    Object localVarPostBody = refund;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling createRefund");
    }
    
    // verify the required parameter 'refund' is set
    if (refund == null) {
      throw new ApiException(400, "Missing the required parameter 'refund' when calling createRefund");
    }
    
    // create path and map variables
    String localVarPath = "/charges/{id}/refunds"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json;charset=utf-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json;charset=utf-8"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<RefundDto> localVarReturnType = new GenericType<RefundDto>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
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
        <tr><td> 200 </td><td> OK  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
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
        <tr><td> 200 </td><td> OK  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
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
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json;charset=utf-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<RefundsResponse> localVarReturnType = new GenericType<RefundsResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List refunds
   * 返金に関する情報を一覧で取得します。
   * @param chargeId Charge ID (required)
   * @return RefundsResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
   */
  public RefundsResponse listRefunds(String chargeId) throws ApiException {
    return listRefundsWithHttpInfo(chargeId).getData();
      }

  /**
   * List refunds
   * 返金に関する情報を一覧で取得します。
   * @param chargeId Charge ID (required)
   * @return ApiResponse&lt;RefundsResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<RefundsResponse> listRefundsWithHttpInfo(String chargeId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'chargeId' is set
    if (chargeId == null) {
      throw new ApiException(400, "Missing the required parameter 'chargeId' when calling listRefunds");
    }
    
    // create path and map variables
    String localVarPath = "/refunds";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "chargeId", chargeId));

    
    
    final String[] localVarAccepts = {
      "application/json;charset=utf-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<RefundsResponse> localVarReturnType = new GenericType<RefundsResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
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
        <tr><td> 200 </td><td> OK  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
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
        <tr><td> 200 </td><td> OK  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
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
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json;charset=utf-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<RefundDto> localVarReturnType = new GenericType<RefundDto>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retrieve refund
   * 返金に関する詳細情報を取得します。
   * @param refundId Refund ID (required)
   * @return RefundDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
   */
  public RefundDto retrieveRefund(String refundId) throws ApiException {
    return retrieveRefundWithHttpInfo(refundId).getData();
      }

  /**
   * Retrieve refund
   * 返金に関する詳細情報を取得します。
   * @param refundId Refund ID (required)
   * @return ApiResponse&lt;RefundDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad request </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<RefundDto> retrieveRefundWithHttpInfo(String refundId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'refundId' is set
    if (refundId == null) {
      throw new ApiException(400, "Missing the required parameter 'refundId' when calling retrieveRefund");
    }
    
    // create path and map variables
    String localVarPath = "/refunds/{refundId}"
      .replaceAll("\\{" + "refundId" + "\\}", apiClient.escapeString(refundId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json;charset=utf-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<RefundDto> localVarReturnType = new GenericType<RefundDto>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
