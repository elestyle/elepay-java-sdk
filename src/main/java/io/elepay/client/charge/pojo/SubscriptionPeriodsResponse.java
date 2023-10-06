/*
 * elepay API リファレンス
 * elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。
 *
 * The version of the OpenAPI document: 1.2.2
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
import io.elepay.client.charge.pojo.SubscriptionPeriodDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 定期課金周期情報リスト
 */
@ApiModel(description = "定期課金周期情報リスト")
@JsonPropertyOrder({
  SubscriptionPeriodsResponse.JSON_PROPERTY_TOTAL,
  SubscriptionPeriodsResponse.JSON_PROPERTY_PERIODS
})

public class SubscriptionPeriodsResponse {
  public static final String JSON_PROPERTY_TOTAL = "total";
  private Integer total;

  public static final String JSON_PROPERTY_PERIODS = "periods";
  private List<SubscriptionPeriodDto> periods = null;


  public SubscriptionPeriodsResponse total(Integer total) {
    
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


  public SubscriptionPeriodsResponse periods(List<SubscriptionPeriodDto> periods) {
    
    this.periods = periods;
    return this;
  }

  public SubscriptionPeriodsResponse addPeriodsItem(SubscriptionPeriodDto periodsItem) {
    if (this.periods == null) {
      this.periods = new ArrayList<>();
    }
    this.periods.add(periodsItem);
    return this;
  }

   /**
   * 定期課金周期詳細情報
   * @return periods
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "定期課金周期詳細情報")
  @JsonProperty(JSON_PROPERTY_PERIODS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<SubscriptionPeriodDto> getPeriods() {
    return periods;
  }


  public void setPeriods(List<SubscriptionPeriodDto> periods) {
    this.periods = periods;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriptionPeriodsResponse subscriptionPeriodsResponse = (SubscriptionPeriodsResponse) o;
    return Objects.equals(this.total, subscriptionPeriodsResponse.total) &&
        Objects.equals(this.periods, subscriptionPeriodsResponse.periods);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, periods);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionPeriodsResponse {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    periods: ").append(toIndentedString(periods)).append("\n");
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

