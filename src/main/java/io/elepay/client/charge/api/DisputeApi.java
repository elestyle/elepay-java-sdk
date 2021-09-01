package io.elepay.client.charge.api;

import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiResponse;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.Pair;

import javax.ws.rs.core.GenericType;

import io.elepay.client.charge.pojo.DisputeDateTimeType;
import io.elepay.client.charge.pojo.DisputeDto;
import io.elepay.client.charge.pojo.DisputeStatusType;
import io.elepay.client.charge.pojo.DisputesResponse;
import io.elepay.client.charge.pojo.SortOrderType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DisputeApi {
  private ApiClient apiClient;

  public DisputeApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DisputeApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * List disputes
   * TODO
   * @param chargeId Charge ID (optional)
   * @param from 開始時間（UTC）。指定した時間以降に作成されたデータを取得します。 (optional)
   * @param to 終了時間（UTC）。指定した時間以前に作成されたデータを取得します (optional)
   * @param dateField 開始時間と終了時間の項目を指定します。 - resolved_time TODO - create_time 決済新規時間  (optional, default to create_time)
   * @param status TODO (optional)
   * @param limit 最大件数 (optional, default to 20)
   * @param offset 検索開始位置 (optional, default to 0)
   * @param sort ソート項目 - resolved_time TODO - create_time 決済新規時間  (optional, default to create_time)
   * @param order ソート順 - desc 降順 - asc 昇順  (optional, default to desc)
   * @return DisputesResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public DisputesResponse listDisputes(String chargeId, Long from, Long to, DisputeDateTimeType dateField, DisputeStatusType status, Integer limit, Integer offset, DisputeDateTimeType sort, SortOrderType order) throws ApiException {
    return listDisputesWithHttpInfo(chargeId, from, to, dateField, status, limit, offset, sort, order).getData();
      }

  /**
   * List disputes
   * TODO
   * @param chargeId Charge ID (optional)
   * @param from 開始時間（UTC）。指定した時間以降に作成されたデータを取得します。 (optional)
   * @param to 終了時間（UTC）。指定した時間以前に作成されたデータを取得します (optional)
   * @param dateField 開始時間と終了時間の項目を指定します。 - resolved_time TODO - create_time 決済新規時間  (optional, default to create_time)
   * @param status TODO (optional)
   * @param limit 最大件数 (optional, default to 20)
   * @param offset 検索開始位置 (optional, default to 0)
   * @param sort ソート項目 - resolved_time TODO - create_time 決済新規時間  (optional, default to create_time)
   * @param order ソート順 - desc 降順 - asc 昇順  (optional, default to desc)
   * @return ApiResponse&lt;DisputesResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<DisputesResponse> listDisputesWithHttpInfo(String chargeId, Long from, Long to, DisputeDateTimeType dateField, DisputeStatusType status, Integer limit, Integer offset, DisputeDateTimeType sort, SortOrderType order) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/disputes";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "chargeId", chargeId));
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

    GenericType<DisputesResponse> localVarReturnType = new GenericType<DisputesResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retrieve dispute
   * TODO
   * @param id Dispute ID (required)
   * @return DisputeDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public DisputeDto retrieveDispute(String id) throws ApiException {
    return retrieveDisputeWithHttpInfo(id).getData();
      }

  /**
   * Retrieve dispute
   * TODO
   * @param id Dispute ID (required)
   * @return ApiResponse&lt;DisputeDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<DisputeDto> retrieveDisputeWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling retrieveDispute");
    }
    
    // create path and map variables
    String localVarPath = "/disputes/{id}"
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

    GenericType<DisputeDto> localVarReturnType = new GenericType<DisputeDto>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
