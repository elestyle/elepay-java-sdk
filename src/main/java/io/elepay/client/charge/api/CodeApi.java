package io.elepay.client.charge.api;

import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiResponse;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.Pair;

import javax.ws.rs.core.GenericType;

import io.elepay.client.charge.pojo.CodeDto;
import io.elepay.client.charge.pojo.CodeReq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CodeApi {
  private ApiClient apiClient;

  public CodeApi() {
    this(Configuration.getDefaultApiClient());
  }

  public CodeApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Close EasyQR code
   * EasyQRコードを削除します
   * @param codeId EasyQRコード (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Closed </td><td>  -  </td></tr>
     </table>
   */
  public void closeCode(String codeId) throws ApiException {

    closeCodeWithHttpInfo(codeId);
  }

  /**
   * Close EasyQR code
   * EasyQRコードを削除します
   * @param codeId EasyQRコード (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Closed </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> closeCodeWithHttpInfo(String codeId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'codeId' is set
    if (codeId == null) {
      throw new ApiException(400, "Missing the required parameter 'codeId' when calling closeCode");
    }
    
    // create path and map variables
    String localVarPath = "/codes/{codeId}"
      .replaceAll("\\{" + "codeId" + "\\}", apiClient.escapeString(codeId.toString()));

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
   * Create EasyQR code
   * EasyQRコードを作成します。
   * @param codeReq EasyQRコードリクエスト (required)
   * @return CodeDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
   */
  public CodeDto createCode(CodeReq codeReq) throws ApiException {
    return createCodeWithHttpInfo(codeReq).getData();
      }

  /**
   * Create EasyQR code
   * EasyQRコードを作成します。
   * @param codeReq EasyQRコードリクエスト (required)
   * @return ApiResponse&lt;CodeDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CodeDto> createCodeWithHttpInfo(CodeReq codeReq) throws ApiException {
    Object localVarPostBody = codeReq;
    
    // verify the required parameter 'codeReq' is set
    if (codeReq == null) {
      throw new ApiException(400, "Missing the required parameter 'codeReq' when calling createCode");
    }
    
    // create path and map variables
    String localVarPath = "/codes";

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

    GenericType<CodeDto> localVarReturnType = new GenericType<CodeDto>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retrieve EasyQR code
   * EasyQRコードオブジェクトを取得する
   * @param codeId EasyQRコード (required)
   * @return CodeDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public CodeDto retrieveCode(String codeId) throws ApiException {
    return retrieveCodeWithHttpInfo(codeId).getData();
      }

  /**
   * Retrieve EasyQR code
   * EasyQRコードオブジェクトを取得する
   * @param codeId EasyQRコード (required)
   * @return ApiResponse&lt;CodeDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CodeDto> retrieveCodeWithHttpInfo(String codeId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'codeId' is set
    if (codeId == null) {
      throw new ApiException(400, "Missing the required parameter 'codeId' when calling retrieveCode");
    }
    
    // create path and map variables
    String localVarPath = "/codes/{codeId}"
      .replaceAll("\\{" + "codeId" + "\\}", apiClient.escapeString(codeId.toString()));

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

    GenericType<CodeDto> localVarReturnType = new GenericType<CodeDto>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
