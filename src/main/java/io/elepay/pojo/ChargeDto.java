/*
 * elepay API リファレンス
 * elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。 
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.elepay.pojo;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.elepay.pojo.PaymentMethodType;
import io.elepay.pojo.RefundExtDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 支払いオブジェクト
 */
@ApiModel(description = "支払いオブジェクト")

public class ChargeDto {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_OBJECT = "object";
  private String _object = "charge";

  public static final String JSON_PROPERTY_LIVE_MODE = "liveMode";
  private Boolean liveMode;

  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private Integer amount;

  public static final String JSON_PROPERTY_CURRENCY = "currency";
  private String currency = "JPY";

  public static final String JSON_PROPERTY_PAYMENT_METHOD = "paymentMethod";
  private PaymentMethodType paymentMethod;

  public static final String JSON_PROPERTY_ORDER_NO = "orderNo";
  private String orderNo;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_EXTRA = "extra";
  private Map<String, Object> extra = null;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private Map<String, Object> metadata = null;

  public static final String JSON_PROPERTY_CLIENT_IP = "clientIp";
  private String clientIp;

  public static final String JSON_PROPERTY_PAID = "paid";
  private Boolean paid;

  public static final String JSON_PROPERTY_REFUNDED = "refunded";
  private Boolean refunded;

  public static final String JSON_PROPERTY_REFUNDS = "refunds";
  private RefundExtDto refunds;

  public static final String JSON_PROPERTY_STATUS = "status";
  private String status;

  public static final String JSON_PROPERTY_CREDENTIAL = "credential";
  private String credential;

  public static final String JSON_PROPERTY_PAID_TIME = "paidTime";
  private Long paidTime;

  public static final String JSON_PROPERTY_REFUND_TIME = "refundTime";
  private Long refundTime;

  public static final String JSON_PROPERTY_EXPIRY_TIME = "expiryTime";
  private Long expiryTime;

  public static final String JSON_PROPERTY_SETTLE_TIME = "settleTime";
  private Long settleTime;

  public static final String JSON_PROPERTY_CREATE_TIME = "createTime";
  private Long createTime;


  public ChargeDto id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Charge ID
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Charge ID")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }



  public void setId(String id) {
    this.id = id;
  }


  public ChargeDto _object(String _object) {
    
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


  public ChargeDto liveMode(Boolean liveMode) {
    
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


  public ChargeDto amount(Integer amount) {
    
    this.amount = amount;
    return this;
  }

   /**
   * 支払い金額
   * @return amount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "支払い金額")
  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getAmount() {
    return amount;
  }



  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  public ChargeDto currency(String currency) {
    
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


  public ChargeDto paymentMethod(PaymentMethodType paymentMethod) {
    
    this.paymentMethod = paymentMethod;
    return this;
  }

   /**
   * Get paymentMethod
   * @return paymentMethod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PAYMENT_METHOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PaymentMethodType getPaymentMethod() {
    return paymentMethod;
  }



  public void setPaymentMethod(PaymentMethodType paymentMethod) {
    this.paymentMethod = paymentMethod;
  }


  public ChargeDto orderNo(String orderNo) {
    
    this.orderNo = orderNo;
    return this;
  }

   /**
   * お客様システム側のオーダーNo、例えば注文番号、決済IDなど
   * @return orderNo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "お客様システム側のオーダーNo、例えば注文番号、決済IDなど")
  @JsonProperty(JSON_PROPERTY_ORDER_NO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getOrderNo() {
    return orderNo;
  }



  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }


  public ChargeDto description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * 支払い説明文
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "支払い説明文")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }



  public void setDescription(String description) {
    this.description = description;
  }


  public ChargeDto extra(Map<String, Object> extra) {
    
    this.extra = extra;
    return this;
  }

  public ChargeDto putExtraItem(String key, Object extraItem) {
    if (this.extra == null) {
      this.extra = new HashMap<>();
    }
    this.extra.put(key, extraItem);
    return this;
  }

   /**
   * 支払いエキストラデータ
   * @return extra
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "支払いエキストラデータ")
  @JsonProperty(JSON_PROPERTY_EXTRA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, Object> getExtra() {
    return extra;
  }



  public void setExtra(Map<String, Object> extra) {
    this.extra = extra;
  }


  public ChargeDto metadata(Map<String, Object> metadata) {
    
    this.metadata = metadata;
    return this;
  }

  public ChargeDto putMetadataItem(String key, Object metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

   /**
   * 支払いメタデータ
   * @return metadata
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "支払いメタデータ")
  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, Object> getMetadata() {
    return metadata;
  }



  public void setMetadata(Map<String, Object> metadata) {
    this.metadata = metadata;
  }


  public ChargeDto clientIp(String clientIp) {
    
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


  public ChargeDto paid(Boolean paid) {
    
    this.paid = paid;
    return this;
  }

   /**
   * 支払い済みフラグ
   * @return paid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "支払い済みフラグ")
  @JsonProperty(JSON_PROPERTY_PAID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getPaid() {
    return paid;
  }



  public void setPaid(Boolean paid) {
    this.paid = paid;
  }


  public ChargeDto refunded(Boolean refunded) {
    
    this.refunded = refunded;
    return this;
  }

   /**
   * 返金済みフラグ
   * @return refunded
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "返金済みフラグ")
  @JsonProperty(JSON_PROPERTY_REFUNDED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getRefunded() {
    return refunded;
  }



  public void setRefunded(Boolean refunded) {
    this.refunded = refunded;
  }


  public ChargeDto refunds(RefundExtDto refunds) {
    
    this.refunds = refunds;
    return this;
  }

   /**
   * Get refunds
   * @return refunds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_REFUNDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RefundExtDto getRefunds() {
    return refunds;
  }



  public void setRefunds(RefundExtDto refunds) {
    this.refunds = refunds;
  }


  public ChargeDto status(String status) {
    
    this.status = status;
    return this;
  }

   /**
   * 支払い状態
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "支払い状態")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getStatus() {
    return status;
  }



  public void setStatus(String status) {
    this.status = status;
  }


  public ChargeDto credential(String credential) {
    
    this.credential = credential;
    return this;
  }

   /**
   * Client SDK の認証情報
   * @return credential
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Client SDK の認証情報")
  @JsonProperty(JSON_PROPERTY_CREDENTIAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCredential() {
    return credential;
  }



  public void setCredential(String credential) {
    this.credential = credential;
  }


  public ChargeDto paidTime(Long paidTime) {
    
    this.paidTime = paidTime;
    return this;
  }

   /**
   * 支払い時間のUTCタイムスタンプ
   * @return paidTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "支払い時間のUTCタイムスタンプ")
  @JsonProperty(JSON_PROPERTY_PAID_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getPaidTime() {
    return paidTime;
  }



  public void setPaidTime(Long paidTime) {
    this.paidTime = paidTime;
  }


  public ChargeDto refundTime(Long refundTime) {
    
    this.refundTime = refundTime;
    return this;
  }

   /**
   * 返金時間のUTCタイムスタンプ
   * @return refundTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "返金時間のUTCタイムスタンプ")
  @JsonProperty(JSON_PROPERTY_REFUND_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getRefundTime() {
    return refundTime;
  }



  public void setRefundTime(Long refundTime) {
    this.refundTime = refundTime;
  }


  public ChargeDto expiryTime(Long expiryTime) {
    
    this.expiryTime = expiryTime;
    return this;
  }

   /**
   * 支払い請求有効時間のUTCタイムスタンプ
   * @return expiryTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "支払い請求有効時間のUTCタイムスタンプ")
  @JsonProperty(JSON_PROPERTY_EXPIRY_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getExpiryTime() {
    return expiryTime;
  }



  public void setExpiryTime(Long expiryTime) {
    this.expiryTime = expiryTime;
  }


  public ChargeDto settleTime(Long settleTime) {
    
    this.settleTime = settleTime;
    return this;
  }

   /**
   * 支払い締め時間のUTCタイムスタンプ
   * @return settleTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "支払い締め時間のUTCタイムスタンプ")
  @JsonProperty(JSON_PROPERTY_SETTLE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getSettleTime() {
    return settleTime;
  }



  public void setSettleTime(Long settleTime) {
    this.settleTime = settleTime;
  }


  public ChargeDto createTime(Long createTime) {
    
    this.createTime = createTime;
    return this;
  }

   /**
   * 支払い新規時間のUTCタイムスタンプ
   * @return createTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "支払い新規時間のUTCタイムスタンプ")
  @JsonProperty(JSON_PROPERTY_CREATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getCreateTime() {
    return createTime;
  }



  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChargeDto chargeDto = (ChargeDto) o;
    return Objects.equals(this.id, chargeDto.id) &&
        Objects.equals(this._object, chargeDto._object) &&
        Objects.equals(this.liveMode, chargeDto.liveMode) &&
        Objects.equals(this.amount, chargeDto.amount) &&
        Objects.equals(this.currency, chargeDto.currency) &&
        Objects.equals(this.paymentMethod, chargeDto.paymentMethod) &&
        Objects.equals(this.orderNo, chargeDto.orderNo) &&
        Objects.equals(this.description, chargeDto.description) &&
        Objects.equals(this.extra, chargeDto.extra) &&
        Objects.equals(this.metadata, chargeDto.metadata) &&
        Objects.equals(this.clientIp, chargeDto.clientIp) &&
        Objects.equals(this.paid, chargeDto.paid) &&
        Objects.equals(this.refunded, chargeDto.refunded) &&
        Objects.equals(this.refunds, chargeDto.refunds) &&
        Objects.equals(this.status, chargeDto.status) &&
        Objects.equals(this.credential, chargeDto.credential) &&
        Objects.equals(this.paidTime, chargeDto.paidTime) &&
        Objects.equals(this.refundTime, chargeDto.refundTime) &&
        Objects.equals(this.expiryTime, chargeDto.expiryTime) &&
        Objects.equals(this.settleTime, chargeDto.settleTime) &&
        Objects.equals(this.createTime, chargeDto.createTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, _object, liveMode, amount, currency, paymentMethod, orderNo, description, extra, metadata, clientIp, paid, refunded, refunds, status, credential, paidTime, refundTime, expiryTime, settleTime, createTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChargeDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    liveMode: ").append(toIndentedString(liveMode)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    orderNo: ").append(toIndentedString(orderNo)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    extra: ").append(toIndentedString(extra)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    clientIp: ").append(toIndentedString(clientIp)).append("\n");
    sb.append("    paid: ").append(toIndentedString(paid)).append("\n");
    sb.append("    refunded: ").append(toIndentedString(refunded)).append("\n");
    sb.append("    refunds: ").append(toIndentedString(refunds)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    credential: ").append(toIndentedString(credential)).append("\n");
    sb.append("    paidTime: ").append(toIndentedString(paidTime)).append("\n");
    sb.append("    refundTime: ").append(toIndentedString(refundTime)).append("\n");
    sb.append("    expiryTime: ").append(toIndentedString(expiryTime)).append("\n");
    sb.append("    settleTime: ").append(toIndentedString(settleTime)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
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

