package io.elepay.client.charge.api;

import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiResponse;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.Pair;

import javax.ws.rs.core.GenericType;

import io.elepay.client.charge.pojo.CodePaymentMethodResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CodeSettingApi {
  private ApiClient apiClient;

  public CodeSettingApi() {
    this(Configuration.getDefaultApiClient());
  }

  public CodeSettingApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * List all enabled EasyQR payment methods
   * EasyQR利用できる決済方法を取得します。
   * @return CodePaymentMethodResponse
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> EasyQR利用できる決済方法リスト </td><td>  -  </td></tr>
     </table>
   */
  public CodePaymentMethodResponse listCodePaymentMethods() throws ApiException {
    return listCodePaymentMethodsWithHttpInfo().getData();
      }

  /**
   * List all enabled EasyQR payment methods
   * EasyQR利用できる決済方法を取得します。
   * @return ApiResponse&lt;CodePaymentMethodResponse&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> EasyQR利用できる決済方法リスト </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CodePaymentMethodResponse> listCodePaymentMethodsWithHttpInfo() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/code-setting/payment-methods";

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

    GenericType<CodePaymentMethodResponse> localVarReturnType = new GenericType<CodePaymentMethodResponse>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
