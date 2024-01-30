/*
 * elepay API リファレンス
 * elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。
 *
 * The version of the OpenAPI document: 1.2.4
 * Contact: support@elestyle.jp
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.elepay.client.charge.pojo;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.elepay.client.charge.pojo.SourceStatusType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * カスタマソースステータスオブジェクト
 */
@ApiModel(description = "カスタマソースステータスオブジェクト")
@JsonPropertyOrder({
  SourceStatusDto.JSON_PROPERTY_ID,
  SourceStatusDto.JSON_PROPERTY_APP_ID,
  SourceStatusDto.JSON_PROPERTY_LIVE_MODE,
  SourceStatusDto.JSON_PROPERTY_STATUS
})

public class SourceStatusDto {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_APP_ID = "appId";
  private String appId;

  public static final String JSON_PROPERTY_LIVE_MODE = "liveMode";
  private Boolean liveMode;

  public static final String JSON_PROPERTY_STATUS = "status";
  private SourceStatusType status;


  public SourceStatusDto id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Source ID
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Source ID")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public SourceStatusDto appId(String appId) {
    
    this.appId = appId;
    return this;
  }

   /**
   * App ID
   * @return appId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "App ID")
  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAppId() {
    return appId;
  }


  public void setAppId(String appId) {
    this.appId = appId;
  }


  public SourceStatusDto liveMode(Boolean liveMode) {
    
    this.liveMode = liveMode;
    return this;
  }

   /**
   * 本番モードかどうか - false テストモード - true 本番モード 
   * @return liveMode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "本番モードかどうか - false テストモード - true 本番モード ")
  @JsonProperty(JSON_PROPERTY_LIVE_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getLiveMode() {
    return liveMode;
  }


  public void setLiveMode(Boolean liveMode) {
    this.liveMode = liveMode;
  }


  public SourceStatusDto status(SourceStatusType status) {
    
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SourceStatusType getStatus() {
    return status;
  }


  public void setStatus(SourceStatusType status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceStatusDto sourceStatusDto = (SourceStatusDto) o;
    return Objects.equals(this.id, sourceStatusDto.id) &&
        Objects.equals(this.appId, sourceStatusDto.appId) &&
        Objects.equals(this.liveMode, sourceStatusDto.liveMode) &&
        Objects.equals(this.status, sourceStatusDto.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, appId, liveMode, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceStatusDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    liveMode: ").append(toIndentedString(liveMode)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

