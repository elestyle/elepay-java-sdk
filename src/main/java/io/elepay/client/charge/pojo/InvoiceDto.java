/*
 * elepay API リファレンス
 * elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。
 *
 * The version of the OpenAPI document: 1.1.16
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
import io.elepay.client.charge.pojo.InvoiceItem;
import io.elepay.client.charge.pojo.InvoiceStatusType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * インボイスオブジェクト
 */
@ApiModel(description = "インボイスオブジェクト")
@JsonPropertyOrder({
  InvoiceDto.JSON_PROPERTY_ID,
  InvoiceDto.JSON_PROPERTY_OBJECT,
  InvoiceDto.JSON_PROPERTY_LIVE_MODE,
  InvoiceDto.JSON_PROPERTY_CUSTOMER,
  InvoiceDto.JSON_PROPERTY_INVOICE_NO,
  InvoiceDto.JSON_PROPERTY_AMOUNT,
  InvoiceDto.JSON_PROPERTY_CURRENCY,
  InvoiceDto.JSON_PROPERTY_STATUS,
  InvoiceDto.JSON_PROPERTY_OPERATOR,
  InvoiceDto.JSON_PROPERTY_SUBMIT_TIME,
  InvoiceDto.JSON_PROPERTY_PAID_TIME,
  InvoiceDto.JSON_PROPERTY_EXPIRY_TIME,
  InvoiceDto.JSON_PROPERTY_CREATE_TIME,
  InvoiceDto.JSON_PROPERTY_ITEMS,
  InvoiceDto.JSON_PROPERTY_REMARK,
  InvoiceDto.JSON_PROPERTY_METADATA
})

public class InvoiceDto {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_OBJECT = "object";
  private String _object = "invoice";

  public static final String JSON_PROPERTY_LIVE_MODE = "liveMode";
  private Boolean liveMode;

  public static final String JSON_PROPERTY_CUSTOMER = "customer";
  private CustomerDto customer;

  public static final String JSON_PROPERTY_INVOICE_NO = "invoiceNo";
  private String invoiceNo;

  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private Integer amount;

  public static final String JSON_PROPERTY_CURRENCY = "currency";
  private String currency = "JPY";

  public static final String JSON_PROPERTY_STATUS = "status";
  private InvoiceStatusType status;

  public static final String JSON_PROPERTY_OPERATOR = "operator";
  private String operator;

  public static final String JSON_PROPERTY_SUBMIT_TIME = "submitTime";
  private Long submitTime;

  public static final String JSON_PROPERTY_PAID_TIME = "paidTime";
  private Long paidTime;

  public static final String JSON_PROPERTY_EXPIRY_TIME = "expiryTime";
  private Long expiryTime;

  public static final String JSON_PROPERTY_CREATE_TIME = "createTime";
  private Long createTime;

  public static final String JSON_PROPERTY_ITEMS = "items";
  private List<InvoiceItem> items = null;

  public static final String JSON_PROPERTY_REMARK = "remark";
  private String remark;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private Map<String, String> metadata = null;


  public InvoiceDto id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Invoice ID
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Invoice ID")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public InvoiceDto _object(String _object) {
    
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


  public InvoiceDto liveMode(Boolean liveMode) {
    
    this.liveMode = liveMode;
    return this;
  }

   /**
   * 本番モードかどうか - false テストモード - true 本番モード 
   * @return liveMode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "本番モードかどうか - false テストモード - true 本番モード ")
  @JsonProperty(JSON_PROPERTY_LIVE_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getLiveMode() {
    return liveMode;
  }


  public void setLiveMode(Boolean liveMode) {
    this.liveMode = liveMode;
  }


  public InvoiceDto customer(CustomerDto customer) {
    
    this.customer = customer;
    return this;
  }

   /**
   * Get customer
   * @return customer
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CUSTOMER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CustomerDto getCustomer() {
    return customer;
  }


  public void setCustomer(CustomerDto customer) {
    this.customer = customer;
  }


  public InvoiceDto invoiceNo(String invoiceNo) {
    
    this.invoiceNo = invoiceNo;
    return this;
  }

   /**
   * Invoice Number
   * @return invoiceNo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Invoice Number")
  @JsonProperty(JSON_PROPERTY_INVOICE_NO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInvoiceNo() {
    return invoiceNo;
  }


  public void setInvoiceNo(String invoiceNo) {
    this.invoiceNo = invoiceNo;
  }


  public InvoiceDto amount(Integer amount) {
    
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


  public InvoiceDto currency(String currency) {
    
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


  public InvoiceDto status(InvoiceStatusType status) {
    
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public InvoiceStatusType getStatus() {
    return status;
  }


  public void setStatus(InvoiceStatusType status) {
    this.status = status;
  }


  public InvoiceDto operator(String operator) {
    
    this.operator = operator;
    return this;
  }

   /**
   * 操作者
   * @return operator
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "操作者")
  @JsonProperty(JSON_PROPERTY_OPERATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getOperator() {
    return operator;
  }


  public void setOperator(String operator) {
    this.operator = operator;
  }


  public InvoiceDto submitTime(Long submitTime) {
    
    this.submitTime = submitTime;
    return this;
  }

   /**
   * create time
   * @return submitTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "create time")
  @JsonProperty(JSON_PROPERTY_SUBMIT_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getSubmitTime() {
    return submitTime;
  }


  public void setSubmitTime(Long submitTime) {
    this.submitTime = submitTime;
  }


  public InvoiceDto paidTime(Long paidTime) {
    
    this.paidTime = paidTime;
    return this;
  }

   /**
   * paid time
   * @return paidTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "paid time")
  @JsonProperty(JSON_PROPERTY_PAID_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getPaidTime() {
    return paidTime;
  }


  public void setPaidTime(Long paidTime) {
    this.paidTime = paidTime;
  }


  public InvoiceDto expiryTime(Long expiryTime) {
    
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


  public InvoiceDto createTime(Long createTime) {
    
    this.createTime = createTime;
    return this;
  }

   /**
   * create time
   * @return createTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "create time")
  @JsonProperty(JSON_PROPERTY_CREATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getCreateTime() {
    return createTime;
  }


  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }


  public InvoiceDto items(List<InvoiceItem> items) {
    
    this.items = items;
    return this;
  }

  public InvoiceDto addItemsItem(InvoiceItem itemsItem) {
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


  public InvoiceDto remark(String remark) {
    
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


  public InvoiceDto metadata(Map<String, String> metadata) {
    
    this.metadata = metadata;
    return this;
  }

  public InvoiceDto putMetadataItem(String key, String metadataItem) {
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
    InvoiceDto invoiceDto = (InvoiceDto) o;
    return Objects.equals(this.id, invoiceDto.id) &&
        Objects.equals(this._object, invoiceDto._object) &&
        Objects.equals(this.liveMode, invoiceDto.liveMode) &&
        Objects.equals(this.customer, invoiceDto.customer) &&
        Objects.equals(this.invoiceNo, invoiceDto.invoiceNo) &&
        Objects.equals(this.amount, invoiceDto.amount) &&
        Objects.equals(this.currency, invoiceDto.currency) &&
        Objects.equals(this.status, invoiceDto.status) &&
        Objects.equals(this.operator, invoiceDto.operator) &&
        Objects.equals(this.submitTime, invoiceDto.submitTime) &&
        Objects.equals(this.paidTime, invoiceDto.paidTime) &&
        Objects.equals(this.expiryTime, invoiceDto.expiryTime) &&
        Objects.equals(this.createTime, invoiceDto.createTime) &&
        Objects.equals(this.items, invoiceDto.items) &&
        Objects.equals(this.remark, invoiceDto.remark) &&
        Objects.equals(this.metadata, invoiceDto.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, _object, liveMode, customer, invoiceNo, amount, currency, status, operator, submitTime, paidTime, expiryTime, createTime, items, remark, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvoiceDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    liveMode: ").append(toIndentedString(liveMode)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    invoiceNo: ").append(toIndentedString(invoiceNo)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
    sb.append("    submitTime: ").append(toIndentedString(submitTime)).append("\n");
    sb.append("    paidTime: ").append(toIndentedString(paidTime)).append("\n");
    sb.append("    expiryTime: ").append(toIndentedString(expiryTime)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
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
