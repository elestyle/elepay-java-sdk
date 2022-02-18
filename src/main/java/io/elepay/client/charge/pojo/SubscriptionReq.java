/*
 * elepay API リファレンス
 * elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。
 *
 * The version of the OpenAPI document: 1.1.24
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
import io.elepay.client.charge.pojo.DiscountDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 定期課金作成リクエスト
 */
@ApiModel(description = "定期課金作成リクエスト")
@JsonPropertyOrder({
  SubscriptionReq.JSON_PROPERTY_CUSTOMER_ID,
  SubscriptionReq.JSON_PROPERTY_PLAN_ID,
  SubscriptionReq.JSON_PROPERTY_DISCOUNT,
  SubscriptionReq.JSON_PROPERTY_TRIAL_PERIOD_DAYS,
  SubscriptionReq.JSON_PROPERTY_PRORATE,
  SubscriptionReq.JSON_PROPERTY_METADATA
})

public class SubscriptionReq {
  public static final String JSON_PROPERTY_CUSTOMER_ID = "customerId";
  private String customerId;

  public static final String JSON_PROPERTY_PLAN_ID = "planId";
  private String planId;

  public static final String JSON_PROPERTY_DISCOUNT = "discount";
  private DiscountDto discount;

  public static final String JSON_PROPERTY_TRIAL_PERIOD_DAYS = "trialPeriodDays";
  private Integer trialPeriodDays;

  public static final String JSON_PROPERTY_PRORATE = "prorate";
  private Boolean prorate = false;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private Map<String, String> metadata = null;


  public SubscriptionReq customerId(String customerId) {
    
    this.customerId = customerId;
    return this;
  }

   /**
   * Customer ID
   * @return customerId
  **/
  @ApiModelProperty(required = true, value = "Customer ID")
  @JsonProperty(JSON_PROPERTY_CUSTOMER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCustomerId() {
    return customerId;
  }


  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }


  public SubscriptionReq planId(String planId) {
    
    this.planId = planId;
    return this;
  }

   /**
   * Plan ID
   * @return planId
  **/
  @ApiModelProperty(required = true, value = "Plan ID")
  @JsonProperty(JSON_PROPERTY_PLAN_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getPlanId() {
    return planId;
  }


  public void setPlanId(String planId) {
    this.planId = planId;
  }


  public SubscriptionReq discount(DiscountDto discount) {
    
    this.discount = discount;
    return this;
  }

   /**
   * Get discount
   * @return discount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DISCOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public DiscountDto getDiscount() {
    return discount;
  }


  public void setDiscount(DiscountDto discount) {
    this.discount = discount;
  }


  public SubscriptionReq trialPeriodDays(Integer trialPeriodDays) {
    
    this.trialPeriodDays = trialPeriodDays;
    return this;
  }

   /**
   * トライアル日数
   * @return trialPeriodDays
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "トライアル日数")
  @JsonProperty(JSON_PROPERTY_TRIAL_PERIOD_DAYS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getTrialPeriodDays() {
    return trialPeriodDays;
  }


  public void setTrialPeriodDays(Integer trialPeriodDays) {
    this.trialPeriodDays = trialPeriodDays;
  }


  public SubscriptionReq prorate(Boolean prorate) {
    
    this.prorate = prorate;
    return this;
  }

   /**
   * 日割り課金設定、デフォルトはfalse billingDay設定した場合のみ有効。 
   * @return prorate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "日割り課金設定、デフォルトはfalse billingDay設定した場合のみ有効。 ")
  @JsonProperty(JSON_PROPERTY_PRORATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getProrate() {
    return prorate;
  }


  public void setProrate(Boolean prorate) {
    this.prorate = prorate;
  }


  public SubscriptionReq metadata(Map<String, String> metadata) {
    
    this.metadata = metadata;
    return this;
  }

  public SubscriptionReq putMetadataItem(String key, String metadataItem) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriptionReq subscriptionReq = (SubscriptionReq) o;
    return Objects.equals(this.customerId, subscriptionReq.customerId) &&
        Objects.equals(this.planId, subscriptionReq.planId) &&
        Objects.equals(this.discount, subscriptionReq.discount) &&
        Objects.equals(this.trialPeriodDays, subscriptionReq.trialPeriodDays) &&
        Objects.equals(this.prorate, subscriptionReq.prorate) &&
        Objects.equals(this.metadata, subscriptionReq.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, planId, discount, trialPeriodDays, prorate, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionReq {\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
    sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
    sb.append("    trialPeriodDays: ").append(toIndentedString(trialPeriodDays)).append("\n");
    sb.append("    prorate: ").append(toIndentedString(prorate)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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

