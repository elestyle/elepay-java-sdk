/*
 * elepay API リファレンス
 * elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。
 *
 * The version of the OpenAPI document: 1.2.0
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
import io.elepay.client.charge.pojo.ChargeDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 定期課金周期支払情報リスト
 */
@ApiModel(description = "定期課金周期支払情報リスト")
@JsonPropertyOrder({
  SubscriptionScheduleChargesResponse.JSON_PROPERTY_TOTAL,
  SubscriptionScheduleChargesResponse.JSON_PROPERTY_CHARGES
})

public class SubscriptionScheduleChargesResponse {
  public static final String JSON_PROPERTY_TOTAL = "total";
  private Integer total;

  public static final String JSON_PROPERTY_CHARGES = "charges";
  private List<ChargeDto> charges = null;


  public SubscriptionScheduleChargesResponse total(Integer total) {
    
    this.total = total;
    return this;
  }

   /**
   * 件数
   * @return total
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "件数")
  @JsonProperty(JSON_PROPERTY_TOTAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getTotal() {
    return total;
  }


  public void setTotal(Integer total) {
    this.total = total;
  }


  public SubscriptionScheduleChargesResponse charges(List<ChargeDto> charges) {
    
    this.charges = charges;
    return this;
  }

  public SubscriptionScheduleChargesResponse addChargesItem(ChargeDto chargesItem) {
    if (this.charges == null) {
      this.charges = new ArrayList<>();
    }
    this.charges.add(chargesItem);
    return this;
  }

   /**
   * 定期課金周期支払詳細情報
   * @return charges
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "定期課金周期支払詳細情報")
  @JsonProperty(JSON_PROPERTY_CHARGES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ChargeDto> getCharges() {
    return charges;
  }


  public void setCharges(List<ChargeDto> charges) {
    this.charges = charges;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriptionScheduleChargesResponse subscriptionScheduleChargesResponse = (SubscriptionScheduleChargesResponse) o;
    return Objects.equals(this.total, subscriptionScheduleChargesResponse.total) &&
        Objects.equals(this.charges, subscriptionScheduleChargesResponse.charges);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, charges);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionScheduleChargesResponse {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    charges: ").append(toIndentedString(charges)).append("\n");
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

