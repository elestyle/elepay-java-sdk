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
import io.elepay.client.charge.pojo.PlanIntervalType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * プラン作成リクエスト
 */
@ApiModel(description = "プラン作成リクエスト")
@JsonPropertyOrder({
  PlanReq.JSON_PROPERTY_NAME,
  PlanReq.JSON_PROPERTY_CURRENCY,
  PlanReq.JSON_PROPERTY_AMOUNT,
  PlanReq.JSON_PROPERTY_INTERVAL,
  PlanReq.JSON_PROPERTY_TRIAL_PERIOD_DAYS,
  PlanReq.JSON_PROPERTY_BILLING_DAY,
  PlanReq.JSON_PROPERTY_METADATA
})

public class PlanReq {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_CURRENCY = "currency";
  private String currency = "JPY";

  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private Integer amount;

  public static final String JSON_PROPERTY_INTERVAL = "interval";
  private PlanIntervalType interval;

  public static final String JSON_PROPERTY_TRIAL_PERIOD_DAYS = "trialPeriodDays";
  private Integer trialPeriodDays;

  public static final String JSON_PROPERTY_BILLING_DAY = "billingDay";
  private Integer billingDay;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private Map<String, String> metadata = null;


  public PlanReq name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * プラン名
   * @return name
  **/
  @ApiModelProperty(required = true, value = "プラン名")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public PlanReq currency(String currency) {
    
    this.currency = currency;
    return this;
  }

   /**
   * 通貨コード (ISO_4217)
   * @return currency
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "通貨コード (ISO_4217)")
  @JsonProperty(JSON_PROPERTY_CURRENCY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCurrency() {
    return currency;
  }


  public void setCurrency(String currency) {
    this.currency = currency;
  }


  public PlanReq amount(Integer amount) {
    
    this.amount = amount;
    return this;
  }

   /**
   * プラン金額
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "プラン金額")
  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getAmount() {
    return amount;
  }


  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  public PlanReq interval(PlanIntervalType interval) {
    
    this.interval = interval;
    return this;
  }

   /**
   * Get interval
   * @return interval
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_INTERVAL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public PlanIntervalType getInterval() {
    return interval;
  }


  public void setInterval(PlanIntervalType interval) {
    this.interval = interval;
  }


  public PlanReq trialPeriodDays(Integer trialPeriodDays) {
    
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


  public PlanReq billingDay(Integer billingDay) {
    
    this.billingDay = billingDay;
    return this;
  }

   /**
   * 月次プランの課金日 指定した日が存在しない月の場合、定期課金におけるサイクルは自動的に月末に調整されるため、例えば31を指定した場合は常に月末が課金日となります。 
   * @return billingDay
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "月次プランの課金日 指定した日が存在しない月の場合、定期課金におけるサイクルは自動的に月末に調整されるため、例えば31を指定した場合は常に月末が課金日となります。 ")
  @JsonProperty(JSON_PROPERTY_BILLING_DAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getBillingDay() {
    return billingDay;
  }


  public void setBillingDay(Integer billingDay) {
    this.billingDay = billingDay;
  }


  public PlanReq metadata(Map<String, String> metadata) {
    
    this.metadata = metadata;
    return this;
  }

  public PlanReq putMetadataItem(String key, String metadataItem) {
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
    PlanReq planReq = (PlanReq) o;
    return Objects.equals(this.name, planReq.name) &&
        Objects.equals(this.currency, planReq.currency) &&
        Objects.equals(this.amount, planReq.amount) &&
        Objects.equals(this.interval, planReq.interval) &&
        Objects.equals(this.trialPeriodDays, planReq.trialPeriodDays) &&
        Objects.equals(this.billingDay, planReq.billingDay) &&
        Objects.equals(this.metadata, planReq.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, currency, amount, interval, trialPeriodDays, billingDay, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanReq {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    interval: ").append(toIndentedString(interval)).append("\n");
    sb.append("    trialPeriodDays: ").append(toIndentedString(trialPeriodDays)).append("\n");
    sb.append("    billingDay: ").append(toIndentedString(billingDay)).append("\n");
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
