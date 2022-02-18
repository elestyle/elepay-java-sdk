package io.elepay.client.charge.api;

import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiResponse;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.Pair;

import javax.ws.rs.core.GenericType;

import io.elepay.client.charge.pojo.SubscriptionDto;
import io.elepay.client.charge.pojo.SubscriptionReq;
import io.elepay.client.charge.pojo.SubscriptionScheduleChargesResponse;
import io.elepay.client.charge.pojo.SubscriptionSchedulesResponse;
import io.elepay.client.charge.pojo.SubscriptionStatusType;
import io.elepay.client.charge.pojo.SubscriptionUpdateReq;
import io.elepay.client.charge.pojo.SubscriptionsResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SubscriptionApi {
  private ApiClient apiClient;

  public SubscriptionApi() {
    this(Configuration.getDefaultApiClient());
  }

  public SubscriptionApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Cancel subscription
   * 定期課金をキャンセルし、現在の周期の終了日をもって定期課金を終了させます。 終了日以前であれば、定期課金の再開リクエスト(/resume)を行うことで、キャンセルを取り消すことができます。 終了日をむかえた定期課金は自動的に削除されますのでご注意ください。 
   * @param subscriptionId Subscription ID (required)
   * @return SubscriptionDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public SubscriptionDto cancelSubscription(String subscriptionId) throws ApiException {
    return cancelSubscriptionWithHttpInfo(subscriptionId).getData();
      }

  /**
   * Cancel subscription
   * 定期課金をキャンセルし、現在の周期の終了日をもって定期課金を終了させます。 終了日以前であれば、定期課金の再開リクエスト(/resume)を行うことで、キャンセルを取り消すことができます。 終了日をむかえた定期課金は自動的に削除されますのでご注意ください。 
   * @param subscriptionId Subscription ID (required)
   * @return ApiResponse&lt;SubscriptionDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SubscriptionDto> cancelSubscriptionWithHttpInfo(String subscriptionId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'subscriptionId' is set
    if (subscriptionId == null) {
      throw new ApiException(400, "Missing the required parameter 'subscriptionId' when calling cancelSubscription");
    }
    
    // create path and map variables
    String localVarPath = "/subscriptions/{subscriptionId}/cancel"
      .replaceAll("\\{" + "subscriptionId" + "\\}", apiClient.escapeString(subscriptionId.toString()));

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

    GenericType<SubscriptionDto> localVarReturnType = new GenericType<SubscriptionDto>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Create subscription
   * 定期課金を作成します。
   * @param subscriptionReq  (required)
   * @return SubscriptionDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public SubscriptionDto createSubscription(SubscriptionReq subscriptionReq) throws ApiException {
    return createSubscriptionWithHttpInfo(subscriptionReq).getData();
      }

  /**
   * Create subscription
   * 定期課金を作成します。
   * @param subscriptionReq  (required)
   * @return ApiResponse&lt;SubscriptionDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SubscriptionDto> createSubscriptionWithHttpInfo(SubscriptionReq subscriptionReq) throws ApiException {
    Object localVarPostBody = subscriptionReq;
    
    // verify the required parameter 'subscriptionReq' is set
    if (subscriptionReq == null) {
      throw new ApiException(400, "Missing the required parameter 'subscriptionReq' when calling createSubscription");
    }
    
    // create path and map variables
    String localVarPath = "/subscriptions";

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

    GenericType<SubscriptionDto> localVarReturnType = new GenericType<SubscriptionDto>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List subscription schedule charges
   * 定期課金周期の支払情報をリストで取得します。
   * @param subscriptionId Subscription ID (required)
   * @param scheduleId Subscription schedule ID (required)
   * @param limit 最大件数 (optional, default to 20)
   * @param offset 検索開始位置 (optional, default to 0)
   * @return SubscriptionScheduleChargesResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public SubscriptionScheduleChargesResponse listSubscriptionScheduleCharges(String subscriptionId, String scheduleId, Integer limit, Integer offset) throws ApiException {
    return listSubscriptionScheduleChargesWithHttpInfo(subscriptionId, scheduleId, limit, offset).getData();
      }

  /**
   * List subscription schedule charges
   * 定期課金周期の支払情報をリストで取得します。
   * @param subscriptionId Subscription ID (required)
   * @param scheduleId Subscription schedule ID (required)
   * @param limit 最大件数 (optional, default to 20)
   * @param offset 検索開始位置 (optional, default to 0)
   * @return ApiResponse&lt;SubscriptionScheduleChargesResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SubscriptionScheduleChargesResponse> listSubscriptionScheduleChargesWithHttpInfo(String subscriptionId, String scheduleId, Integer limit, Integer offset) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'subscriptionId' is set
    if (subscriptionId == null) {
      throw new ApiException(400, "Missing the required parameter 'subscriptionId' when calling listSubscriptionScheduleCharges");
    }
    
    // verify the required parameter 'scheduleId' is set
    if (scheduleId == null) {
      throw new ApiException(400, "Missing the required parameter 'scheduleId' when calling listSubscriptionScheduleCharges");
    }
    
    // create path and map variables
    String localVarPath = "/subscriptions/{subscriptionId}/schedules/{scheduleId}/charges"
      .replaceAll("\\{" + "subscriptionId" + "\\}", apiClient.escapeString(subscriptionId.toString()))
      .replaceAll("\\{" + "scheduleId" + "\\}", apiClient.escapeString(scheduleId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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

    GenericType<SubscriptionScheduleChargesResponse> localVarReturnType = new GenericType<SubscriptionScheduleChargesResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List subscription schedules
   * 定期課金の周期情報をリストで取得します。
   * @param subscriptionId Subscription ID (required)
   * @param limit 最大件数 (optional, default to 20)
   * @param offset 検索開始位置 (optional, default to 0)
   * @return SubscriptionSchedulesResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public SubscriptionSchedulesResponse listSubscriptionSchedules(String subscriptionId, Integer limit, Integer offset) throws ApiException {
    return listSubscriptionSchedulesWithHttpInfo(subscriptionId, limit, offset).getData();
      }

  /**
   * List subscription schedules
   * 定期課金の周期情報をリストで取得します。
   * @param subscriptionId Subscription ID (required)
   * @param limit 最大件数 (optional, default to 20)
   * @param offset 検索開始位置 (optional, default to 0)
   * @return ApiResponse&lt;SubscriptionSchedulesResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SubscriptionSchedulesResponse> listSubscriptionSchedulesWithHttpInfo(String subscriptionId, Integer limit, Integer offset) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'subscriptionId' is set
    if (subscriptionId == null) {
      throw new ApiException(400, "Missing the required parameter 'subscriptionId' when calling listSubscriptionSchedules");
    }
    
    // create path and map variables
    String localVarPath = "/subscriptions/{subscriptionId}/schedules"
      .replaceAll("\\{" + "subscriptionId" + "\\}", apiClient.escapeString(subscriptionId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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

    GenericType<SubscriptionSchedulesResponse> localVarReturnType = new GenericType<SubscriptionSchedulesResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * List subscriptions
   * 定期課金を一覧で取得します。
   * @param customerId Customer ID (optional)
   * @param from 開始時間（UTC）。指定した時間以降に作成されたデータを取得します。 (optional)
   * @param to 終了時間（UTC）。指定した時間以前に作成されたデータを取得します (optional)
   * @param status 定期課金ステータス (optional)
   * @param limit 最大件数 (optional, default to 20)
   * @param offset 検索開始位置 (optional, default to 0)
   * @return SubscriptionsResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public SubscriptionsResponse listSubscriptions(String customerId, Long from, Long to, SubscriptionStatusType status, Integer limit, Integer offset) throws ApiException {
    return listSubscriptionsWithHttpInfo(customerId, from, to, status, limit, offset).getData();
      }

  /**
   * List subscriptions
   * 定期課金を一覧で取得します。
   * @param customerId Customer ID (optional)
   * @param from 開始時間（UTC）。指定した時間以降に作成されたデータを取得します。 (optional)
   * @param to 終了時間（UTC）。指定した時間以前に作成されたデータを取得します (optional)
   * @param status 定期課金ステータス (optional)
   * @param limit 最大件数 (optional, default to 20)
   * @param offset 検索開始位置 (optional, default to 0)
   * @return ApiResponse&lt;SubscriptionsResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SubscriptionsResponse> listSubscriptionsWithHttpInfo(String customerId, Long from, Long to, SubscriptionStatusType status, Integer limit, Integer offset) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/subscriptions";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "customerId", customerId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "from", from));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "to", to));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "status", status));
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

    GenericType<SubscriptionsResponse> localVarReturnType = new GenericType<SubscriptionsResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Resume subscription
   * 定期課金を再開します。 停止中(status&#x3D;paused)、取消済み(statue&#x3D;canceled)の定期課金を再開させます。 再開時の支払いに失敗すると、定期課金は再開されません。 
   * @param subscriptionId Subscription ID (required)
   * @return SubscriptionDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public SubscriptionDto resumeSubscription(String subscriptionId) throws ApiException {
    return resumeSubscriptionWithHttpInfo(subscriptionId).getData();
      }

  /**
   * Resume subscription
   * 定期課金を再開します。 停止中(status&#x3D;paused)、取消済み(statue&#x3D;canceled)の定期課金を再開させます。 再開時の支払いに失敗すると、定期課金は再開されません。 
   * @param subscriptionId Subscription ID (required)
   * @return ApiResponse&lt;SubscriptionDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SubscriptionDto> resumeSubscriptionWithHttpInfo(String subscriptionId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'subscriptionId' is set
    if (subscriptionId == null) {
      throw new ApiException(400, "Missing the required parameter 'subscriptionId' when calling resumeSubscription");
    }
    
    // create path and map variables
    String localVarPath = "/subscriptions/{subscriptionId}/resume"
      .replaceAll("\\{" + "subscriptionId" + "\\}", apiClient.escapeString(subscriptionId.toString()));

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

    GenericType<SubscriptionDto> localVarReturnType = new GenericType<SubscriptionDto>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retrieve subscription
   * 定期課金情報を取得します。
   * @param subscriptionId Subscription ID (required)
   * @return SubscriptionDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public SubscriptionDto retrieveSubscription(String subscriptionId) throws ApiException {
    return retrieveSubscriptionWithHttpInfo(subscriptionId).getData();
      }

  /**
   * Retrieve subscription
   * 定期課金情報を取得します。
   * @param subscriptionId Subscription ID (required)
   * @return ApiResponse&lt;SubscriptionDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SubscriptionDto> retrieveSubscriptionWithHttpInfo(String subscriptionId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'subscriptionId' is set
    if (subscriptionId == null) {
      throw new ApiException(400, "Missing the required parameter 'subscriptionId' when calling retrieveSubscription");
    }
    
    // create path and map variables
    String localVarPath = "/subscriptions/{subscriptionId}"
      .replaceAll("\\{" + "subscriptionId" + "\\}", apiClient.escapeString(subscriptionId.toString()));

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

    GenericType<SubscriptionDto> localVarReturnType = new GenericType<SubscriptionDto>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Update subscription
   * 定期課金を更新します。
   * @param subscriptionId Subscription ID (required)
   * @param subscriptionUpdateReq  (required)
   * @return SubscriptionDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public SubscriptionDto updateSubscription(String subscriptionId, SubscriptionUpdateReq subscriptionUpdateReq) throws ApiException {
    return updateSubscriptionWithHttpInfo(subscriptionId, subscriptionUpdateReq).getData();
      }

  /**
   * Update subscription
   * 定期課金を更新します。
   * @param subscriptionId Subscription ID (required)
   * @param subscriptionUpdateReq  (required)
   * @return ApiResponse&lt;SubscriptionDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<SubscriptionDto> updateSubscriptionWithHttpInfo(String subscriptionId, SubscriptionUpdateReq subscriptionUpdateReq) throws ApiException {
    Object localVarPostBody = subscriptionUpdateReq;
    
    // verify the required parameter 'subscriptionId' is set
    if (subscriptionId == null) {
      throw new ApiException(400, "Missing the required parameter 'subscriptionId' when calling updateSubscription");
    }
    
    // verify the required parameter 'subscriptionUpdateReq' is set
    if (subscriptionUpdateReq == null) {
      throw new ApiException(400, "Missing the required parameter 'subscriptionUpdateReq' when calling updateSubscription");
    }
    
    // create path and map variables
    String localVarPath = "/subscriptions/{subscriptionId}"
      .replaceAll("\\{" + "subscriptionId" + "\\}", apiClient.escapeString(subscriptionId.toString()));

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

    GenericType<SubscriptionDto> localVarReturnType = new GenericType<SubscriptionDto>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
