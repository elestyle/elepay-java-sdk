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
import io.elepay.client.charge.pojo.RefundDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 返金のサマリー。複数回返金された場合、返金内容をサマリーして返します。
 */
@ApiModel(description = "返金のサマリー。複数回返金された場合、返金内容をサマリーして返します。")
@JsonPropertyOrder({
  RefundsDto.JSON_PROPERTY_AMOUNT,
  RefundsDto.JSON_PROPERTY_TOTAL_COUNT,
  RefundsDto.JSON_PROPERTY_DATA
})

public class RefundsDto {
  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private Integer amount;

  public static final String JSON_PROPERTY_TOTAL_COUNT = "totalCount";
  private Integer totalCount;

  public static final String JSON_PROPERTY_DATA = "data";
  private List<RefundDto> data = null;


  public RefundsDto amount(Integer amount) {
    
    this.amount = amount;
    return this;
  }

   /**
   * 返金総額
   * @return amount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "返金総額")
  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getAmount() {
    return amount;
  }


  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  public RefundsDto totalCount(Integer totalCount) {
    
    this.totalCount = totalCount;
    return this;
  }

   /**
   * 返金回数
   * @return totalCount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "返金回数")
  @JsonProperty(JSON_PROPERTY_TOTAL_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getTotalCount() {
    return totalCount;
  }


  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }


  public RefundsDto data(List<RefundDto> data) {
    
    this.data = data;
    return this;
  }

  public RefundsDto addDataItem(RefundDto dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * 返金詳細情報
   * @return data
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "返金詳細情報")
  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<RefundDto> getData() {
    return data;
  }


  public void setData(List<RefundDto> data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RefundsDto refundsDto = (RefundsDto) o;
    return Objects.equals(this.amount, refundsDto.amount) &&
        Objects.equals(this.totalCount, refundsDto.totalCount) &&
        Objects.equals(this.data, refundsDto.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, totalCount, data);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RefundsDto {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

