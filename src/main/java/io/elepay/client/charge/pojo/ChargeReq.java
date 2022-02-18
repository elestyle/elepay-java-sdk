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
import io.elepay.client.charge.pojo.PaymentMethodType;
import io.elepay.client.charge.pojo.ResourceType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 支払リクエスト
 */
@ApiModel(description = "支払リクエスト")
@JsonPropertyOrder({
  ChargeReq.JSON_PROPERTY_AMOUNT,
  ChargeReq.JSON_PROPERTY_CAPTURE,
  ChargeReq.JSON_PROPERTY_CURRENCY,
  ChargeReq.JSON_PROPERTY_PAYMENT_METHOD,
  ChargeReq.JSON_PROPERTY_RESOURCE,
  ChargeReq.JSON_PROPERTY_ORDER_NO,
  ChargeReq.JSON_PROPERTY_DESCRIPTION,
  ChargeReq.JSON_PROPERTY_EXTRA,
  ChargeReq.JSON_PROPERTY_METADATA,
  ChargeReq.JSON_PROPERTY_CLIENT_IP,
  ChargeReq.JSON_PROPERTY_CUSTOMER_ID,
  ChargeReq.JSON_PROPERTY_SOURCE_ID
})

public class ChargeReq {
  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private Integer amount;

  public static final String JSON_PROPERTY_CAPTURE = "capture";
  private Boolean capture = true;

  public static final String JSON_PROPERTY_CURRENCY = "currency";
  private String currency = "JPY";

  public static final String JSON_PROPERTY_PAYMENT_METHOD = "paymentMethod";
  private PaymentMethodType paymentMethod;

  public static final String JSON_PROPERTY_RESOURCE = "resource";
  private ResourceType resource;

  public static final String JSON_PROPERTY_ORDER_NO = "orderNo";
  private String orderNo;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_EXTRA = "extra";
  private Map<String, String> extra = null;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private Map<String, String> metadata = null;

  public static final String JSON_PROPERTY_CLIENT_IP = "clientIp";
  private String clientIp;

  public static final String JSON_PROPERTY_CUSTOMER_ID = "customerId";
  private String customerId;

  public static final String JSON_PROPERTY_SOURCE_ID = "sourceId";
  private String sourceId;


  public ChargeReq amount(Integer amount) {
    
    this.amount = amount;
    return this;
  }

   /**
   * 金額
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "金額")
  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getAmount() {
    return amount;
  }


  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  public ChargeReq capture(Boolean capture) {
    
    this.capture = capture;
    return this;
  }

   /**
   * 支払い処理を確定するかどうか falseの場合、承認と支払い額の確保のみ行う。デフォルトはtrue 
   * @return capture
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "支払い処理を確定するかどうか falseの場合、承認と支払い額の確保のみ行う。デフォルトはtrue ")
  @JsonProperty(JSON_PROPERTY_CAPTURE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getCapture() {
    return capture;
  }


  public void setCapture(Boolean capture) {
    this.capture = capture;
  }


  public ChargeReq currency(String currency) {
    
    this.currency = currency;
    return this;
  }

   /**
   * 通貨コード (ISO_4217)
   * @return currency
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "通貨コード (ISO_4217)")
  @JsonProperty(JSON_PROPERTY_CURRENCY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCurrency() {
    return currency;
  }


  public void setCurrency(String currency) {
    this.currency = currency;
  }


  public ChargeReq paymentMethod(PaymentMethodType paymentMethod) {
    
    this.paymentMethod = paymentMethod;
    return this;
  }

   /**
   * Get paymentMethod
   * @return paymentMethod
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PAYMENT_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public PaymentMethodType getPaymentMethod() {
    return paymentMethod;
  }


  public void setPaymentMethod(PaymentMethodType paymentMethod) {
    this.paymentMethod = paymentMethod;
  }


  public ChargeReq resource(ResourceType resource) {
    
    this.resource = resource;
    return this;
  }

   /**
   * Get resource
   * @return resource
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_RESOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ResourceType getResource() {
    return resource;
  }


  public void setResource(ResourceType resource) {
    this.resource = resource;
  }


  public ChargeReq orderNo(String orderNo) {
    
    this.orderNo = orderNo;
    return this;
  }

   /**
   * お客様側のシステムオーダーNo（例：注文番号、決済IDなど） 最大桁数は50桁です。 
   * @return orderNo
  **/
  @ApiModelProperty(required = true, value = "お客様側のシステムオーダーNo（例：注文番号、決済IDなど） 最大桁数は50桁です。 ")
  @JsonProperty(JSON_PROPERTY_ORDER_NO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getOrderNo() {
    return orderNo;
  }


  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }


  public ChargeReq description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * 決済に関する説明
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "決済に関する説明")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public ChargeReq extra(Map<String, String> extra) {
    
    this.extra = extra;
    return this;
  }

  public ChargeReq putExtraItem(String key, String extraItem) {
    if (this.extra == null) {
      this.extra = new HashMap<>();
    }
    this.extra.put(key, extraItem);
    return this;
  }

   /**
   * 決済に関する追加情報がある場合に利用します。具体的設定情報は「開発ガイド-&gt;決済Extra情報設定」を参照してください。
   * @return extra
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "決済に関する追加情報がある場合に利用します。具体的設定情報は「開発ガイド->決済Extra情報設定」を参照してください。")
  @JsonProperty(JSON_PROPERTY_EXTRA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, String> getExtra() {
    return extra;
  }


  public void setExtra(Map<String, String> extra) {
    this.extra = extra;
  }


  public ChargeReq metadata(Map<String, String> metadata) {
    
    this.metadata = metadata;
    return this;
  }

  public ChargeReq putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

   /**
   * メタデータ キーバリューの任意データ。 キーは20個まで、バリューは255バイト以内の文字列。 「route」、「__」で始まる文字列は予約キー。 
   * @return metadata
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "メタデータ キーバリューの任意データ。 キーは20個まで、バリューは255バイト以内の文字列。 「route」、「__」で始まる文字列は予約キー。 ")
  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, String> getMetadata() {
    return metadata;
  }


  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }


  public ChargeReq clientIp(String clientIp) {
    
    this.clientIp = clientIp;
    return this;
  }

   /**
   * Client IP アドレス
   * @return clientIp
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Client IP アドレス")
  @JsonProperty(JSON_PROPERTY_CLIENT_IP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getClientIp() {
    return clientIp;
  }


  public void setClientIp(String clientIp) {
    this.clientIp = clientIp;
  }


  public ChargeReq customerId(String customerId) {
    
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


  public ChargeReq sourceId(String sourceId) {
    
    this.sourceId = sourceId;
    return this;
  }

   /**
   * カスタマソースID
   * @return sourceId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "カスタマソースID")
  @JsonProperty(JSON_PROPERTY_SOURCE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSourceId() {
    return sourceId;
  }


  public void setSourceId(String sourceId) {
    this.sourceId = sourceId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChargeReq chargeReq = (ChargeReq) o;
    return Objects.equals(this.amount, chargeReq.amount) &&
        Objects.equals(this.capture, chargeReq.capture) &&
        Objects.equals(this.currency, chargeReq.currency) &&
        Objects.equals(this.paymentMethod, chargeReq.paymentMethod) &&
        Objects.equals(this.resource, chargeReq.resource) &&
        Objects.equals(this.orderNo, chargeReq.orderNo) &&
        Objects.equals(this.description, chargeReq.description) &&
        Objects.equals(this.extra, chargeReq.extra) &&
        Objects.equals(this.metadata, chargeReq.metadata) &&
        Objects.equals(this.clientIp, chargeReq.clientIp) &&
        Objects.equals(this.customerId, chargeReq.customerId) &&
        Objects.equals(this.sourceId, chargeReq.sourceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, capture, currency, paymentMethod, resource, orderNo, description, extra, metadata, clientIp, customerId, sourceId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChargeReq {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    capture: ").append(toIndentedString(capture)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    resource: ").append(toIndentedString(resource)).append("\n");
    sb.append("    orderNo: ").append(toIndentedString(orderNo)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    extra: ").append(toIndentedString(extra)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    clientIp: ").append(toIndentedString(clientIp)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    sourceId: ").append(toIndentedString(sourceId)).append("\n");
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

