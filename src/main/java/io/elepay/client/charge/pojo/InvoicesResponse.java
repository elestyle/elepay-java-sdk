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
import io.elepay.client.charge.pojo.InvoiceDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * インボイス情報リスト
 */
@ApiModel(description = "インボイス情報リスト")
@JsonPropertyOrder({
  InvoicesResponse.JSON_PROPERTY_TOTAL,
  InvoicesResponse.JSON_PROPERTY_INVOICES
})

public class InvoicesResponse {
  public static final String JSON_PROPERTY_TOTAL = "total";
  private Integer total;

  public static final String JSON_PROPERTY_INVOICES = "invoices";
  private List<InvoiceDto> invoices = null;


  public InvoicesResponse total(Integer total) {
    
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


  public InvoicesResponse invoices(List<InvoiceDto> invoices) {
    
    this.invoices = invoices;
    return this;
  }

  public InvoicesResponse addInvoicesItem(InvoiceDto invoicesItem) {
    if (this.invoices == null) {
      this.invoices = new ArrayList<>();
    }
    this.invoices.add(invoicesItem);
    return this;
  }

   /**
   * インボイス詳細内容
   * @return invoices
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "インボイス詳細内容")
  @JsonProperty(JSON_PROPERTY_INVOICES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<InvoiceDto> getInvoices() {
    return invoices;
  }


  public void setInvoices(List<InvoiceDto> invoices) {
    this.invoices = invoices;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvoicesResponse invoicesResponse = (InvoicesResponse) o;
    return Objects.equals(this.total, invoicesResponse.total) &&
        Objects.equals(this.invoices, invoicesResponse.invoices);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, invoices);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvoicesResponse {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    invoices: ").append(toIndentedString(invoices)).append("\n");
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

