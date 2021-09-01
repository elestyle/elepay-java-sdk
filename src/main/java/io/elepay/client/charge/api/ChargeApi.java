package io.elepay.client.charge.api;

import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiResponse;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.Pair;

import javax.ws.rs.core.GenericType;

import io.elepay.client.charge.pojo.ChargeCaptureReq;
import io.elepay.client.charge.pojo.ChargeDateTimeType;
import io.elepay.client.charge.pojo.ChargeDto;
import io.elepay.client.charge.pojo.ChargeReq;
import io.elepay.client.charge.pojo.ChargeStatusDto;
import io.elepay.client.charge.pojo.ChargeStatusType;
import io.elepay.client.charge.pojo.ChargesResponse;
import io.elepay.client.charge.pojo.PaymentMethodType;
import io.elepay.client.charge.pojo.SortOrderType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ChargeApi {
  private ApiClient apiClient;

  public ChargeApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ChargeApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Capture charge
   * 決済を確定します。
   * @param id Charge ID (required)
   * @param chargeCaptureReq  (optional)
   * @return ChargeDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ChargeDto captureCharge(String id, ChargeCaptureReq chargeCaptureReq) throws ApiException {
    return captureChargeWithHttpInfo(id, chargeCaptureReq).getData();
      }

  /**
   * Capture charge
   * 決済を確定します。
   * @param id Charge ID (required)
   * @param chargeCaptureReq  (optional)
   * @return ApiResponse&lt;ChargeDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ChargeDto> captureChargeWithHttpInfo(String id, ChargeCaptureReq chargeCaptureReq) throws ApiException {
    Object localVarPostBody = chargeCaptureReq;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling captureCharge");
    }
    
    // create path and map variables
    String localVarPath = "/charges/{id}/capture"
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

    String[] localVarAuthNames = new String[] { "basicAuth" };

    GenericType<ChargeDto> localVarReturnType = new GenericType<ChargeDto>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Create charge
   * 決済処理を行います。
   * @param chargeReq 支払リクエスト (required)
   * @return ChargeDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
   */
  public ChargeDto createCharge(ChargeReq chargeReq) throws ApiException {
    return createChargeWithHttpInfo(chargeReq).getData();
      }

  /**
   * Create charge
   * 決済処理を行います。
   * @param chargeReq 支払リクエスト (required)
   * @return ApiResponse&lt;ChargeDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ChargeDto> createChargeWithHttpInfo(ChargeReq chargeReq) throws ApiException {
    Object localVarPostBody = chargeReq;
    
    // verify the required parameter 'chargeReq' is set
    if (chargeReq == null) {
      throw new ApiException(400, "Missing the required parameter 'chargeReq' when calling createCharge");
    }
    
    // create path and map variables
    String localVarPath = "/charges";

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

    GenericType<ChargeDto> localVarReturnType = new GenericType<ChargeDto>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List charges
   * 決済に関する情報を一覧で取得します。
   * @param paymentMethod 決済方法(複数の指定が可能です) (optional, default to new ArrayList&lt;&gt;())
   * @param from 開始時間（UTC）。指定した時間以降に作成されたデータを取得します。 (optional)
   * @param to 終了時間（UTC）。指定した時間以前に作成されたデータを取得します (optional)
   * @param dateField 開始時間と終了時間の項目を指定します。 - paid_time 払う時間 - create_time 決済新規時間  (optional, default to create_time)
   * @param status 支払状況 (optional)
   * @param limit 最大件数 (optional, default to 20)
   * @param offset 検索開始位置 (optional, default to 0)
   * @param sort ソート項目 - paid_time 払う時間 - create_time 決済新規時間  (optional, default to create_time)
   * @param order ソート順 - desc 降順 - asc 昇順  (optional, default to desc)
   * @return ChargesResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ChargesResponse listCharges(List<PaymentMethodType> paymentMethod, Long from, Long to, ChargeDateTimeType dateField, ChargeStatusType status, Integer limit, Integer offset, ChargeDateTimeType sort, SortOrderType order) throws ApiException {
    return listChargesWithHttpInfo(paymentMethod, from, to, dateField, status, limit, offset, sort, order).getData();
      }

  /**
   * List charges
   * 決済に関する情報を一覧で取得します。
   * @param paymentMethod 決済方法(複数の指定が可能です) (optional, default to new ArrayList&lt;&gt;())
   * @param from 開始時間（UTC）。指定した時間以降に作成されたデータを取得します。 (optional)
   * @param to 終了時間（UTC）。指定した時間以前に作成されたデータを取得します (optional)
   * @param dateField 開始時間と終了時間の項目を指定します。 - paid_time 払う時間 - create_time 決済新規時間  (optional, default to create_time)
   * @param status 支払状況 (optional)
   * @param limit 最大件数 (optional, default to 20)
   * @param offset 検索開始位置 (optional, default to 0)
   * @param sort ソート項目 - paid_time 払う時間 - create_time 決済新規時間  (optional, default to create_time)
   * @param order ソート順 - desc 降順 - asc 昇順  (optional, default to desc)
   * @return ApiResponse&lt;ChargesResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ChargesResponse> listChargesWithHttpInfo(List<PaymentMethodType> paymentMethod, Long from, Long to, ChargeDateTimeType dateField, ChargeStatusType status, Integer limit, Integer offset, ChargeDateTimeType sort, SortOrderType order) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/charges";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "paymentMethod", paymentMethod));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "from", from));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "to", to));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dateField", dateField));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "status", status));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "order", order));

    
    
    
    final String[] localVarAccepts = {
      "application/json;charset=utf-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "basicAuth" };

    GenericType<ChargesResponse> localVarReturnType = new GenericType<ChargesResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retrieve charge
   * 決済に関する詳細情報を取得します。
   * @param id Charge ID (required)
   * @return ChargeDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ChargeDto retrieveCharge(String id) throws ApiException {
    return retrieveChargeWithHttpInfo(id).getData();
      }

  /**
   * Retrieve charge
   * 決済に関する詳細情報を取得します。
   * @param id Charge ID (required)
   * @return ApiResponse&lt;ChargeDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ChargeDto> retrieveChargeWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling retrieveCharge");
    }
    
    // create path and map variables
    String localVarPath = "/charges/{id}"
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

    String[] localVarAuthNames = new String[] { "basicAuth" };

    GenericType<ChargeDto> localVarReturnType = new GenericType<ChargeDto>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retrieve charge&#39;s status
   * 決済のステータスに関する詳細情報を取得します。
   * @param id Charge ID (required)
   * @return ChargeStatusDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ChargeStatusDto retrieveChargeStatus(String id) throws ApiException {
    return retrieveChargeStatusWithHttpInfo(id).getData();
      }

  /**
   * Retrieve charge&#39;s status
   * 決済のステータスに関する詳細情報を取得します。
   * @param id Charge ID (required)
   * @return ApiResponse&lt;ChargeStatusDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ChargeStatusDto> retrieveChargeStatusWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling retrieveChargeStatus");
    }
    
    // create path and map variables
    String localVarPath = "/charges/{id}/status"
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

    String[] localVarAuthNames = new String[] { "basicAuth" };

    GenericType<ChargeStatusDto> localVarReturnType = new GenericType<ChargeStatusDto>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Revoke charge
   * 決済を取消します。
   * @param id Charge ID (required)
   * @return ChargeDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ChargeDto revokeCharge(String id) throws ApiException {
    return revokeChargeWithHttpInfo(id).getData();
      }

  /**
   * Revoke charge
   * 決済を取消します。
   * @param id Charge ID (required)
   * @return ApiResponse&lt;ChargeDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ChargeDto> revokeChargeWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling revokeCharge");
    }
    
    // create path and map variables
    String localVarPath = "/charges/{id}/revoke"
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

    String[] localVarAuthNames = new String[] { "basicAuth" };

    GenericType<ChargeDto> localVarReturnType = new GenericType<ChargeDto>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
