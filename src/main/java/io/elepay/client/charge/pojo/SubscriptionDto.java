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
import io.elepay.client.charge.pojo.CustomerDto;
import io.elepay.client.charge.pojo.SubscriptionStatusType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 定期課金オブジェクト
 */
@ApiModel(description = "定期課金オブジェクト")
@JsonPropertyOrder({
  SubscriptionDto.JSON_PROPERTY_ID,
  SubscriptionDto.JSON_PROPERTY_APP_ID,
  SubscriptionDto.JSON_PROPERTY_OBJECT,
  SubscriptionDto.JSON_PROPERTY_LIVE_MODE,
  SubscriptionDto.JSON_PROPERTY_CUSTOMER_ID,
  SubscriptionDto.JSON_PROPERTY_CUSTOMER,
  SubscriptionDto.JSON_PROPERTY_NEXT_CHARGE_TIME,
  SubscriptionDto.JSON_PROPERTY_IS_CHARGING,
  SubscriptionDto.JSON_PROPERTY_CHARGED_PERIODS,
  SubscriptionDto.JSON_PROPERTY_METADATA,
  SubscriptionDto.JSON_PROPERTY_STATUS,
  SubscriptionDto.JSON_PROPERTY_CREATE_TIME,
  SubscriptionDto.JSON_PROPERTY_UPDATE_TIME
})

public class SubscriptionDto {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_APP_ID = "appId";
  private String appId;

  public static final String JSON_PROPERTY_OBJECT = "object";
  private String _object = "subscription";

  public static final String JSON_PROPERTY_LIVE_MODE = "liveMode";
  private Boolean liveMode;

  public static final String JSON_PROPERTY_CUSTOMER_ID = "customerId";
  private String customerId;

  public static final String JSON_PROPERTY_CUSTOMER = "customer";
  private CustomerDto customer;

  public static final String JSON_PROPERTY_NEXT_CHARGE_TIME = "nextChargeTime";
  private Long nextChargeTime;

  public static final String JSON_PROPERTY_IS_CHARGING = "isCharging";
  private Boolean isCharging;

  public static final String JSON_PROPERTY_CHARGED_PERIODS = "chargedPeriods";
  private Integer chargedPeriods;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private Map<String, String> metadata = null;

  public static final String JSON_PROPERTY_STATUS = "status";
  private SubscriptionStatusType status;

  public static final String JSON_PROPERTY_CREATE_TIME = "createTime";
  private Long createTime;

  public static final String JSON_PROPERTY_UPDATE_TIME = "updateTime";
  private Long updateTime;


  public SubscriptionDto id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Subscription ID
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Subscription ID")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public SubscriptionDto appId(String appId) {
    
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


  public SubscriptionDto _object(String _object) {
    
    this._object = _object;
    return this;
  }

   /**
   * 対象種類の表記
   * @return _object
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "対象種類の表記")
  @JsonProperty(JSON_PROPERTY_OBJECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getObject() {
    return _object;
  }


  public void setObject(String _object) {
    this._object = _object;
  }


  public SubscriptionDto liveMode(Boolean liveMode) {
    
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


  public SubscriptionDto customerId(String customerId) {
    
    this.customerId = customerId;
    return this;
  }

   /**
   * Customer ID
   * @return customerId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Customer ID")
  @JsonProperty(JSON_PROPERTY_CUSTOMER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCustomerId() {
    return customerId;
  }


  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }


  public SubscriptionDto customer(CustomerDto customer) {
    
    this.customer = customer;
    return this;
  }

   /**
   * Get customer
   * @return customer
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CUSTOMER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CustomerDto getCustomer() {
    return customer;
  }


  public void setCustomer(CustomerDto customer) {
    this.customer = customer;
  }


  public SubscriptionDto nextChargeTime(Long nextChargeTime) {
    
    this.nextChargeTime = nextChargeTime;
    return this;
  }

   /**
   * 次定期課金周期開始UTCタイムスタンプ
   * @return nextChargeTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "次定期課金周期開始UTCタイムスタンプ")
  @JsonProperty(JSON_PROPERTY_NEXT_CHARGE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getNextChargeTime() {
    return nextChargeTime;
  }


  public void setNextChargeTime(Long nextChargeTime) {
    this.nextChargeTime = nextChargeTime;
  }


  public SubscriptionDto isCharging(Boolean isCharging) {
    
    this.isCharging = isCharging;
    return this;
  }

   /**
   * 処理中かどうか
   * @return isCharging
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "処理中かどうか")
  @JsonProperty(JSON_PROPERTY_IS_CHARGING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getIsCharging() {
    return isCharging;
  }


  public void setIsCharging(Boolean isCharging) {
    this.isCharging = isCharging;
  }


  public SubscriptionDto chargedPeriods(Integer chargedPeriods) {
    
    this.chargedPeriods = chargedPeriods;
    return this;
  }

   /**
   * 成功した定期課金回数
   * @return chargedPeriods
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "成功した定期課金回数")
  @JsonProperty(JSON_PROPERTY_CHARGED_PERIODS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getChargedPeriods() {
    return chargedPeriods;
  }


  public void setChargedPeriods(Integer chargedPeriods) {
    this.chargedPeriods = chargedPeriods;
  }


  public SubscriptionDto metadata(Map<String, String> metadata) {
    
    this.metadata = metadata;
    return this;
  }

  public SubscriptionDto putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

   /**
   * メタデータ
   * @return metadata
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "メタデータ")
  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, String> getMetadata() {
    return metadata;
  }


  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }


  public SubscriptionDto status(SubscriptionStatusType status) {
    
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

  public SubscriptionStatusType getStatus() {
    return status;
  }


  public void setStatus(SubscriptionStatusType status) {
    this.status = status;
  }


  public SubscriptionDto createTime(Long createTime) {
    
    this.createTime = createTime;
    return this;
  }

   /**
   * 作成UTCタイムスタンプ
   * @return createTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "作成UTCタイムスタンプ")
  @JsonProperty(JSON_PROPERTY_CREATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getCreateTime() {
    return createTime;
  }


  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }


  public SubscriptionDto updateTime(Long updateTime) {
    
    this.updateTime = updateTime;
    return this;
  }

   /**
   * 更新UTCタイムスタンプ
   * @return updateTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "更新UTCタイムスタンプ")
  @JsonProperty(JSON_PROPERTY_UPDATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getUpdateTime() {
    return updateTime;
  }


  public void setUpdateTime(Long updateTime) {
    this.updateTime = updateTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriptionDto subscriptionDto = (SubscriptionDto) o;
    return Objects.equals(this.id, subscriptionDto.id) &&
        Objects.equals(this.appId, subscriptionDto.appId) &&
        Objects.equals(this._object, subscriptionDto._object) &&
        Objects.equals(this.liveMode, subscriptionDto.liveMode) &&
        Objects.equals(this.customerId, subscriptionDto.customerId) &&
        Objects.equals(this.customer, subscriptionDto.customer) &&
        Objects.equals(this.nextChargeTime, subscriptionDto.nextChargeTime) &&
        Objects.equals(this.isCharging, subscriptionDto.isCharging) &&
        Objects.equals(this.chargedPeriods, subscriptionDto.chargedPeriods) &&
        Objects.equals(this.metadata, subscriptionDto.metadata) &&
        Objects.equals(this.status, subscriptionDto.status) &&
        Objects.equals(this.createTime, subscriptionDto.createTime) &&
        Objects.equals(this.updateTime, subscriptionDto.updateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, appId, _object, liveMode, customerId, customer, nextChargeTime, isCharging, chargedPeriods, metadata, status, createTime, updateTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    liveMode: ").append(toIndentedString(liveMode)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    nextChargeTime: ").append(toIndentedString(nextChargeTime)).append("\n");
    sb.append("    isCharging: ").append(toIndentedString(isCharging)).append("\n");
    sb.append("    chargedPeriods: ").append(toIndentedString(chargedPeriods)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
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

