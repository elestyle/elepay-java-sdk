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
import io.elepay.client.charge.pojo.InvoiceItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * インボイスリクエスト
 */
@ApiModel(description = "インボイスリクエスト")
@JsonPropertyOrder({
  InvoiceReq.JSON_PROPERTY_NAME,
  InvoiceReq.JSON_PROPERTY_MEMO,
  InvoiceReq.JSON_PROPERTY_CUSTOMER_ID,
  InvoiceReq.JSON_PROPERTY_AMOUNT,
  InvoiceReq.JSON_PROPERTY_CURRENCY,
  InvoiceReq.JSON_PROPERTY_EXPIRY_TIME,
  InvoiceReq.JSON_PROPERTY_ITEMS,
  InvoiceReq.JSON_PROPERTY_REMARK,
  InvoiceReq.JSON_PROPERTY_METADATA
})

public class InvoiceReq {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_MEMO = "memo";
  private String memo;

  public static final String JSON_PROPERTY_CUSTOMER_ID = "customerId";
  private String customerId;

  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private Integer amount;

  public static final String JSON_PROPERTY_CURRENCY = "currency";
  private String currency = "JPY";

  public static final String JSON_PROPERTY_EXPIRY_TIME = "expiryTime";
  private Long expiryTime;

  public static final String JSON_PROPERTY_ITEMS = "items";
  private List<InvoiceItem> items = null;

  public static final String JSON_PROPERTY_REMARK = "remark";
  private String remark;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private Map<String, String> metadata = null;


  public InvoiceReq name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public InvoiceReq memo(String memo) {
    
    this.memo = memo;
    return this;
  }

   /**
   * Get memo
   * @return memo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_MEMO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMemo() {
    return memo;
  }


  public void setMemo(String memo) {
    this.memo = memo;
  }


  public InvoiceReq customerId(String customerId) {
    
    this.customerId = customerId;
    return this;
  }

   /**
   * カスタマID
   * @return customerId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "カスタマID")
  @JsonProperty(JSON_PROPERTY_CUSTOMER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCustomerId() {
    return customerId;
  }


  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }


  public InvoiceReq amount(Integer amount) {
    
    this.amount = amount;
    return this;
  }

   /**
   * payment amount
   * @return amount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "payment amount")
  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getAmount() {
    return amount;
  }


  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  public InvoiceReq currency(String currency) {
    
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


  public InvoiceReq expiryTime(Long expiryTime) {
    
    this.expiryTime = expiryTime;
    return this;
  }

   /**
   * expiry time
   * @return expiryTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "expiry time")
  @JsonProperty(JSON_PROPERTY_EXPIRY_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getExpiryTime() {
    return expiryTime;
  }


  public void setExpiryTime(Long expiryTime) {
    this.expiryTime = expiryTime;
  }


  public InvoiceReq items(List<InvoiceItem> items) {
    
    this.items = items;
    return this;
  }

  public InvoiceReq addItemsItem(InvoiceItem itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * Get items
   * @return items
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ITEMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<InvoiceItem> getItems() {
    return items;
  }


  public void setItems(List<InvoiceItem> items) {
    this.items = items;
  }


  public InvoiceReq remark(String remark) {
    
    this.remark = remark;
    return this;
  }

   /**
   * 備考
   * @return remark
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "備考")
  @JsonProperty(JSON_PROPERTY_REMARK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRemark() {
    return remark;
  }


  public void setRemark(String remark) {
    this.remark = remark;
  }


  public InvoiceReq metadata(Map<String, String> metadata) {
    
    this.metadata = metadata;
    return this;
  }

  public InvoiceReq putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

   /**
   * メタデータ
   * @return metadata
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "メタデータ")
  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, String> getMetadata() {
    return metadata;
  }


  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvoiceReq invoiceReq = (InvoiceReq) o;
    return Objects.equals(this.name, invoiceReq.name) &&
        Objects.equals(this.memo, invoiceReq.memo) &&
        Objects.equals(this.customerId, invoiceReq.customerId) &&
        Objects.equals(this.amount, invoiceReq.amount) &&
        Objects.equals(this.currency, invoiceReq.currency) &&
        Objects.equals(this.expiryTime, invoiceReq.expiryTime) &&
        Objects.equals(this.items, invoiceReq.items) &&
        Objects.equals(this.remark, invoiceReq.remark) &&
        Objects.equals(this.metadata, invoiceReq.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, memo, customerId, amount, currency, expiryTime, items, remark, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvoiceReq {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    memo: ").append(toIndentedString(memo)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    expiryTime: ").append(toIndentedString(expiryTime)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    remark: ").append(toIndentedString(remark)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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

