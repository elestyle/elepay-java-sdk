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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 決済確定リクエスト
 */
@ApiModel(description = "決済確定リクエスト")
@JsonPropertyOrder({
  ChargeCaptureReq.JSON_PROPERTY_AMOUNT,
  ChargeCaptureReq.JSON_PROPERTY_EXTRA
})

public class ChargeCaptureReq {
  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private Integer amount;

  public static final String JSON_PROPERTY_EXTRA = "extra";
  private Map<String, String> extra = null;


  public ChargeCaptureReq amount(Integer amount) {
    
    this.amount = amount;
    return this;
  }

   /**
   * 確定金額 これをセットすることで、支払い生成時の金額と異なる金額の支払い処理を行うことができます。 ただし支払い生成時の金額よりも少額である必要があるためご注意ください。 
   * @return amount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "確定金額 これをセットすることで、支払い生成時の金額と異なる金額の支払い処理を行うことができます。 ただし支払い生成時の金額よりも少額である必要があるためご注意ください。 ")
  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getAmount() {
    return amount;
  }


  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  public ChargeCaptureReq extra(Map<String, String> extra) {
    
    this.extra = extra;
    return this;
  }

  public ChargeCaptureReq putExtraItem(String key, String extraItem) {
    if (this.extra == null) {
      this.extra = new HashMap<>();
    }
    this.extra.put(key, extraItem);
    return this;
  }

   /**
   * Get extra
   * @return extra
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_EXTRA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, String> getExtra() {
    return extra;
  }


  public void setExtra(Map<String, String> extra) {
    this.extra = extra;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChargeCaptureReq chargeCaptureReq = (ChargeCaptureReq) o;
    return Objects.equals(this.amount, chargeCaptureReq.amount) &&
        Objects.equals(this.extra, chargeCaptureReq.extra);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, extra);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChargeCaptureReq {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    extra: ").append(toIndentedString(extra)).append("\n");
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
