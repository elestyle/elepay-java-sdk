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
import io.elepay.client.charge.pojo.PlanDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * プラン情報リスト
 */
@ApiModel(description = "プラン情報リスト")
@JsonPropertyOrder({
  PlansResponse.JSON_PROPERTY_TOTAL,
  PlansResponse.JSON_PROPERTY_PLANS
})

public class PlansResponse {
  public static final String JSON_PROPERTY_TOTAL = "total";
  private Integer total;

  public static final String JSON_PROPERTY_PLANS = "plans";
  private List<PlanDto> plans = null;


  public PlansResponse total(Integer total) {
    
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


  public PlansResponse plans(List<PlanDto> plans) {
    
    this.plans = plans;
    return this;
  }

  public PlansResponse addPlansItem(PlanDto plansItem) {
    if (this.plans == null) {
      this.plans = new ArrayList<>();
    }
    this.plans.add(plansItem);
    return this;
  }

   /**
   * プラン詳細内容
   * @return plans
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "プラン詳細内容")
  @JsonProperty(JSON_PROPERTY_PLANS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<PlanDto> getPlans() {
    return plans;
  }


  public void setPlans(List<PlanDto> plans) {
    this.plans = plans;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlansResponse plansResponse = (PlansResponse) o;
    return Objects.equals(this.total, plansResponse.total) &&
        Objects.equals(this.plans, plansResponse.plans);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, plans);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlansResponse {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    plans: ").append(toIndentedString(plans)).append("\n");
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

