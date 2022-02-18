package io.elepay.client.charge.api;

import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiResponse;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.Pair;

import javax.ws.rs.core.GenericType;

import io.elepay.client.charge.pojo.PlanDto;
import io.elepay.client.charge.pojo.PlanReq;
import io.elepay.client.charge.pojo.PlanUpdateReq;
import io.elepay.client.charge.pojo.PlansResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PlanApi {
  private ApiClient apiClient;

  public PlanApi() {
    this(Configuration.getDefaultApiClient());
  }

  public PlanApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Create plan
   * 定期課金プランを作成します。
   * @param planReq  (required)
   * @return PlanDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public PlanDto createPlan(PlanReq planReq) throws ApiException {
    return createPlanWithHttpInfo(planReq).getData();
      }

  /**
   * Create plan
   * 定期課金プランを作成します。
   * @param planReq  (required)
   * @return ApiResponse&lt;PlanDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<PlanDto> createPlanWithHttpInfo(PlanReq planReq) throws ApiException {
    Object localVarPostBody = planReq;
    
    // verify the required parameter 'planReq' is set
    if (planReq == null) {
      throw new ApiException(400, "Missing the required parameter 'planReq' when calling createPlan");
    }
    
    // create path and map variables
    String localVarPath = "/plans";

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

    GenericType<PlanDto> localVarReturnType = new GenericType<PlanDto>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List plans
   * 定期課金プラン情報を一覧で取得します。
   * @param keyword キーワード (optional)
   * @param limit 最大件数 (optional, default to 20)
   * @param offset 検索開始位置 (optional, default to 0)
   * @return PlansResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public PlansResponse listPlans(String keyword, Integer limit, Integer offset) throws ApiException {
    return listPlansWithHttpInfo(keyword, limit, offset).getData();
      }

  /**
   * List plans
   * 定期課金プラン情報を一覧で取得します。
   * @param keyword キーワード (optional)
   * @param limit 最大件数 (optional, default to 20)
   * @param offset 検索開始位置 (optional, default to 0)
   * @return ApiResponse&lt;PlansResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<PlansResponse> listPlansWithHttpInfo(String keyword, Integer limit, Integer offset) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/plans";

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

    String[] localVarAuthNames = new String[] { "basicAuth" };

    GenericType<PlansResponse> localVarReturnType = new GenericType<PlansResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retrieve plan
   * 定期課金プラン情報を取得します。
   * @param planId Plan ID (required)
   * @return PlanDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public PlanDto retrievePlan(String planId) throws ApiException {
    return retrievePlanWithHttpInfo(planId).getData();
      }

  /**
   * Retrieve plan
   * 定期課金プラン情報を取得します。
   * @param planId Plan ID (required)
   * @return ApiResponse&lt;PlanDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<PlanDto> retrievePlanWithHttpInfo(String planId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'planId' is set
    if (planId == null) {
      throw new ApiException(400, "Missing the required parameter 'planId' when calling retrievePlan");
    }
    
    // create path and map variables
    String localVarPath = "/plans/{planId}"
      .replaceAll("\\{" + "planId" + "\\}", apiClient.escapeString(planId.toString()));

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

    GenericType<PlanDto> localVarReturnType = new GenericType<PlanDto>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Update plan
   * 定期課金プランを更新します。
   * @param planId Plan ID (required)
   * @param planUpdateReq  (required)
   * @return PlanDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public PlanDto updatePlan(String planId, PlanUpdateReq planUpdateReq) throws ApiException {
    return updatePlanWithHttpInfo(planId, planUpdateReq).getData();
      }

  /**
   * Update plan
   * 定期課金プランを更新します。
   * @param planId Plan ID (required)
   * @param planUpdateReq  (required)
   * @return ApiResponse&lt;PlanDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<PlanDto> updatePlanWithHttpInfo(String planId, PlanUpdateReq planUpdateReq) throws ApiException {
    Object localVarPostBody = planUpdateReq;
    
    // verify the required parameter 'planId' is set
    if (planId == null) {
      throw new ApiException(400, "Missing the required parameter 'planId' when calling updatePlan");
    }
    
    // verify the required parameter 'planUpdateReq' is set
    if (planUpdateReq == null) {
      throw new ApiException(400, "Missing the required parameter 'planUpdateReq' when calling updatePlan");
    }
    
    // create path and map variables
    String localVarPath = "/plans/{planId}"
      .replaceAll("\\{" + "planId" + "\\}", apiClient.escapeString(planId.toString()));

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

    GenericType<PlanDto> localVarReturnType = new GenericType<PlanDto>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
