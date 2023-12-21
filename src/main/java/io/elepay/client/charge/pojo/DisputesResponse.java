/*
 * elepay API リファレンス
 * elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。
 *
 * The version of the OpenAPI document: 1.2.3
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
import io.elepay.client.charge.pojo.DisputeDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 不審請求情報リスト
 */
@ApiModel(description = "不審請求情報リスト")
@JsonPropertyOrder({
  DisputesResponse.JSON_PROPERTY_TOTAL,
  DisputesResponse.JSON_PROPERTY_DISPUTES
})

public class DisputesResponse {
  public static final String JSON_PROPERTY_TOTAL = "total";
  private Integer total;

  public static final String JSON_PROPERTY_DISPUTES = "disputes";
  private List<DisputeDto> disputes = null;


  public DisputesResponse total(Integer total) {
    
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


  public DisputesResponse disputes(List<DisputeDto> disputes) {
    
    this.disputes = disputes;
    return this;
  }

  public DisputesResponse addDisputesItem(DisputeDto disputesItem) {
    if (this.disputes == null) {
      this.disputes = new ArrayList<>();
    }
    this.disputes.add(disputesItem);
    return this;
  }

   /**
   * 不審請求詳細内容
   * @return disputes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "不審請求詳細内容")
  @JsonProperty(JSON_PROPERTY_DISPUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<DisputeDto> getDisputes() {
    return disputes;
  }


  public void setDisputes(List<DisputeDto> disputes) {
    this.disputes = disputes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DisputesResponse disputesResponse = (DisputesResponse) o;
    return Objects.equals(this.total, disputesResponse.total) &&
        Objects.equals(this.disputes, disputesResponse.disputes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, disputes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DisputesResponse {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    disputes: ").append(toIndentedString(disputes)).append("\n");
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

