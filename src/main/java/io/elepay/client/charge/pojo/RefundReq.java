/*
 * elepay API リファレンス
 * elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。
 *
 * The version of the OpenAPI document: 1.1.3
 * 
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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 返金リクエスト
 */
@ApiModel(description = "返金リクエスト")
@JsonPropertyOrder({
  RefundReq.JSON_PROPERTY_AMOUNT,
  RefundReq.JSON_PROPERTY_CURRENCY,
  RefundReq.JSON_PROPERTY_REASON
})

public class RefundReq {
  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private Integer amount;

  public static final String JSON_PROPERTY_CURRENCY = "currency";
  private String currency = "JPY";

  public static final String JSON_PROPERTY_REASON = "reason";
  private String reason;


  public RefundReq amount(Integer amount) {
    
    this.amount = amount;
    return this;
  }

   /**
   * 返金額。全額返金、及び amount の指定で任意の金額で返金ができます。
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "返金額。全額返金、及び amount の指定で任意の金額で返金ができます。")
  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getAmount() {
    return amount;
  }


  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  public RefundReq currency(String currency) {
    
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


  public RefundReq reason(String reason) {
    
    this.reason = reason;
    return this;
  }

   /**
   * 返金理由
   * @return reason
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "返金理由")
  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getReason() {
    return reason;
  }


  public void setReason(String reason) {
    this.reason = reason;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RefundReq refundReq = (RefundReq) o;
    return Objects.equals(this.amount, refundReq.amount) &&
        Objects.equals(this.currency, refundReq.currency) &&
        Objects.equals(this.reason, refundReq.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, currency, reason);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RefundReq {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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

