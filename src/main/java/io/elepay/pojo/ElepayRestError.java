/*
 * elepay API リファレンス
 * elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。 
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.elepay.pojo;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * エラー情報
 */
@ApiModel(description = "エラー情報")

public class ElepayRestError {
  public static final String JSON_PROPERTY_CODE = "code";
  private String code;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  private String message;


  public ElepayRestError code(String code) {
    
    this.code = code;
    return this;
  }

   /**
   * エラーコード
   * @return code
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "エラーコード")
  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCode() {
    return code;
  }



  public void setCode(String code) {
    this.code = code;
  }


  public ElepayRestError message(String message) {
    
    this.message = message;
    return this;
  }

   /**
   * エラーメッセージ
   * @return message
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "エラーメッセージ")
  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMessage() {
    return message;
  }



  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElepayRestError elepayRestError = (ElepayRestError) o;
    return Objects.equals(this.code, elepayRestError.code) &&
        Objects.equals(this.message, elepayRestError.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ElepayRestError {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

