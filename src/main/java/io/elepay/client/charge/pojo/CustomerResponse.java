/*
 * elepay API リファレンス
 * elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。
 *
 * The version of the OpenAPI document: 1.1.19
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
import io.elepay.client.charge.pojo.CustomerDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * カスタマ情報リスト
 */
@ApiModel(description = "カスタマ情報リスト")
@JsonPropertyOrder({
  CustomerResponse.JSON_PROPERTY_TOTAL,
  CustomerResponse.JSON_PROPERTY_CUSTOMERS
})

public class CustomerResponse {
  public static final String JSON_PROPERTY_TOTAL = "total";
  private Integer total;

  public static final String JSON_PROPERTY_CUSTOMERS = "customers";
  private List<CustomerDto> customers = null;


  public CustomerResponse total(Integer total) {
    
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


  public CustomerResponse customers(List<CustomerDto> customers) {
    
    this.customers = customers;
    return this;
  }

  public CustomerResponse addCustomersItem(CustomerDto customersItem) {
    if (this.customers == null) {
      this.customers = new ArrayList<>();
    }
    this.customers.add(customersItem);
    return this;
  }

   /**
   * カスタマ詳細内容
   * @return customers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "カスタマ詳細内容")
  @JsonProperty(JSON_PROPERTY_CUSTOMERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<CustomerDto> getCustomers() {
    return customers;
  }


  public void setCustomers(List<CustomerDto> customers) {
    this.customers = customers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerResponse customerResponse = (CustomerResponse) o;
    return Objects.equals(this.total, customerResponse.total) &&
        Objects.equals(this.customers, customerResponse.customers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, customers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerResponse {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    customers: ").append(toIndentedString(customers)).append("\n");
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

