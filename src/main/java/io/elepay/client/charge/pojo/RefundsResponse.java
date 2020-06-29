/*
 * elepay API リファレンス
 * elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。
 *
 * The version of the OpenAPI document: 1.1.12
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
import io.elepay.client.charge.pojo.RefundDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 返金情報リスト
 */
@ApiModel(description = "返金情報リスト")
@JsonPropertyOrder({
  RefundsResponse.JSON_PROPERTY_TOTAL,
  RefundsResponse.JSON_PROPERTY_REFUNDS
})

public class RefundsResponse {
  public static final String JSON_PROPERTY_TOTAL = "total";
  private Integer total;

  public static final String JSON_PROPERTY_REFUNDS = "refunds";
  private List<RefundDto> refunds = null;


  public RefundsResponse total(Integer total) {
    
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


  public RefundsResponse refunds(List<RefundDto> refunds) {
    
    this.refunds = refunds;
    return this;
  }

  public RefundsResponse addRefundsItem(RefundDto refundsItem) {
    if (this.refunds == null) {
      this.refunds = new ArrayList<>();
    }
    this.refunds.add(refundsItem);
    return this;
  }

   /**
   * 返金詳細内容
   * @return refunds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "返金詳細内容")
  @JsonProperty(JSON_PROPERTY_REFUNDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<RefundDto> getRefunds() {
    return refunds;
  }


  public void setRefunds(List<RefundDto> refunds) {
    this.refunds = refunds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RefundsResponse refundsResponse = (RefundsResponse) o;
    return Objects.equals(this.total, refundsResponse.total) &&
        Objects.equals(this.refunds, refundsResponse.refunds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, refunds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RefundsResponse {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    refunds: ").append(toIndentedString(refunds)).append("\n");
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

