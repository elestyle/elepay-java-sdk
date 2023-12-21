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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * インボイスオブジェクト
 */
@ApiModel(description = "インボイスオブジェクト")
@JsonPropertyOrder({
  InvoiceItem.JSON_PROPERTY_ID,
  InvoiceItem.JSON_PROPERTY_OBJECT,
  InvoiceItem.JSON_PROPERTY_NAME,
  InvoiceItem.JSON_PROPERTY_UNIT_PRICE,
  InvoiceItem.JSON_PROPERTY_CURRENCY,
  InvoiceItem.JSON_PROPERTY_QUANTITY
})

public class InvoiceItem {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_OBJECT = "object";
  private String _object = "invoiceItem";

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_UNIT_PRICE = "unitPrice";
  private Integer unitPrice;

  public static final String JSON_PROPERTY_CURRENCY = "currency";
  private String currency = "JPY";

  public static final String JSON_PROPERTY_QUANTITY = "quantity";
  private Integer quantity;


  public InvoiceItem id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Invoice Item ID
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Invoice Item ID")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public InvoiceItem _object(String _object) {
    
    this._object = _object;
    return this;
  }

   /**
   * 対象種類の表記
   * @return _object
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "対象種類の表記")
  @JsonProperty(JSON_PROPERTY_OBJECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getObject() {
    return _object;
  }


  public void setObject(String _object) {
    this._object = _object;
  }


  public InvoiceItem name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * 商品名
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "商品名")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public InvoiceItem unitPrice(Integer unitPrice) {
    
    this.unitPrice = unitPrice;
    return this;
  }

   /**
   * 単価
   * @return unitPrice
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "単価")
  @JsonProperty(JSON_PROPERTY_UNIT_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getUnitPrice() {
    return unitPrice;
  }


  public void setUnitPrice(Integer unitPrice) {
    this.unitPrice = unitPrice;
  }


  public InvoiceItem currency(String currency) {
    
    this.currency = currency;
    return this;
  }

   /**
   * currency code
   * @return currency
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "currency code")
  @JsonProperty(JSON_PROPERTY_CURRENCY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCurrency() {
    return currency;
  }


  public void setCurrency(String currency) {
    this.currency = currency;
  }


  public InvoiceItem quantity(Integer quantity) {
    
    this.quantity = quantity;
    return this;
  }

   /**
   * 件数
   * @return quantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "件数")
  @JsonProperty(JSON_PROPERTY_QUANTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getQuantity() {
    return quantity;
  }


  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvoiceItem invoiceItem = (InvoiceItem) o;
    return Objects.equals(this.id, invoiceItem.id) &&
        Objects.equals(this._object, invoiceItem._object) &&
        Objects.equals(this.name, invoiceItem.name) &&
        Objects.equals(this.unitPrice, invoiceItem.unitPrice) &&
        Objects.equals(this.currency, invoiceItem.currency) &&
        Objects.equals(this.quantity, invoiceItem.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, _object, name, unitPrice, currency, quantity);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvoiceItem {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
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

