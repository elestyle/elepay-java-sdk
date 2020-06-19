/*
 * elepay API リファレンス
 * elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。
 *
 * The version of the OpenAPI document: 1.1.11
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
import io.elepay.client.charge.pojo.PaymentMethodDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 利用できる決済方法リスト
 */
@ApiModel(description = "利用できる決済方法リスト")
@JsonPropertyOrder({
  PaymentMethodResponse.JSON_PROPERTY_TOTAL,
  PaymentMethodResponse.JSON_PROPERTY_PAYMENT_METHODS
})

public class PaymentMethodResponse {
  public static final String JSON_PROPERTY_TOTAL = "total";
  private Integer total;

  public static final String JSON_PROPERTY_PAYMENT_METHODS = "paymentMethods";
  private List<PaymentMethodDto> paymentMethods = null;


  public PaymentMethodResponse total(Integer total) {
    
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


  public PaymentMethodResponse paymentMethods(List<PaymentMethodDto> paymentMethods) {
    
    this.paymentMethods = paymentMethods;
    return this;
  }

  public PaymentMethodResponse addPaymentMethodsItem(PaymentMethodDto paymentMethodsItem) {
    if (this.paymentMethods == null) {
      this.paymentMethods = new ArrayList<>();
    }
    this.paymentMethods.add(paymentMethodsItem);
    return this;
  }

   /**
   * 決済方法詳細情報
   * @return paymentMethods
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "決済方法詳細情報")
  @JsonProperty(JSON_PROPERTY_PAYMENT_METHODS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<PaymentMethodDto> getPaymentMethods() {
    return paymentMethods;
  }


  public void setPaymentMethods(List<PaymentMethodDto> paymentMethods) {
    this.paymentMethods = paymentMethods;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentMethodResponse paymentMethodResponse = (PaymentMethodResponse) o;
    return Objects.equals(this.total, paymentMethodResponse.total) &&
        Objects.equals(this.paymentMethods, paymentMethodResponse.paymentMethods);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, paymentMethods);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentMethodResponse {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    paymentMethods: ").append(toIndentedString(paymentMethods)).append("\n");
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

