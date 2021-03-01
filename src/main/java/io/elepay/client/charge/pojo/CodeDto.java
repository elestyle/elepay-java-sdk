/*
 * elepay API リファレンス
 * elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。
 *
 * The version of the OpenAPI document: 1.1.14
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
import io.elepay.client.charge.pojo.ChargeDto;
import io.elepay.client.charge.pojo.CodeItem;
import io.elepay.client.charge.pojo.CodeStatusType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * EasyQRコードオブジェクト
 */
@ApiModel(description = "EasyQRコードオブジェクト")
@JsonPropertyOrder({
  CodeDto.JSON_PROPERTY_ID,
  CodeDto.JSON_PROPERTY_OBJECT,
  CodeDto.JSON_PROPERTY_LIVE_MODE,
  CodeDto.JSON_PROPERTY_CODE_URL,
  CodeDto.JSON_PROPERTY_AMOUNT,
  CodeDto.JSON_PROPERTY_CURRENCY,
  CodeDto.JSON_PROPERTY_ORDER_NO,
  CodeDto.JSON_PROPERTY_DESCRIPTION,
  CodeDto.JSON_PROPERTY_METADATA,
  CodeDto.JSON_PROPERTY_STATUS,
  CodeDto.JSON_PROPERTY_CHARGE,
  CodeDto.JSON_PROPERTY_FRONT_URL,
  CodeDto.JSON_PROPERTY_ITEMS,
  CodeDto.JSON_PROPERTY_EXPIRED,
  CodeDto.JSON_PROPERTY_EXPIRY_TIME,
  CodeDto.JSON_PROPERTY_EXPIRY_PERIOD,
  CodeDto.JSON_PROPERTY_CREATE_TIME
})

public class CodeDto {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_OBJECT = "object";
  private String _object = "code";

  public static final String JSON_PROPERTY_LIVE_MODE = "liveMode";
  private Boolean liveMode;

  public static final String JSON_PROPERTY_CODE_URL = "codeUrl";
  private String codeUrl;

  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private Integer amount;

  public static final String JSON_PROPERTY_CURRENCY = "currency";
  private String currency = "JPY";

  public static final String JSON_PROPERTY_ORDER_NO = "orderNo";
  private String orderNo;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private Map<String, String> metadata = null;

  public static final String JSON_PROPERTY_STATUS = "status";
  private CodeStatusType status;

  public static final String JSON_PROPERTY_CHARGE = "charge";
  private ChargeDto charge;

  public static final String JSON_PROPERTY_FRONT_URL = "frontUrl";
  private String frontUrl;

  public static final String JSON_PROPERTY_ITEMS = "items";
  private List<CodeItem> items = null;

  public static final String JSON_PROPERTY_EXPIRED = "expired";
  private Boolean expired;

  public static final String JSON_PROPERTY_EXPIRY_TIME = "expiryTime";
  private Long expiryTime;

  public static final String JSON_PROPERTY_EXPIRY_PERIOD = "expiryPeriod";
  private Long expiryPeriod;

  public static final String JSON_PROPERTY_CREATE_TIME = "createTime";
  private Long createTime;


  public CodeDto id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * EasyQRコードID
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "EasyQRコードID")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public CodeDto _object(String _object) {
    
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


  public CodeDto liveMode(Boolean liveMode) {
    
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


  public CodeDto codeUrl(String codeUrl) {
    
    this.codeUrl = codeUrl;
    return this;
  }

   /**
   * EasyQRコードURL
   * @return codeUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "EasyQRコードURL")
  @JsonProperty(JSON_PROPERTY_CODE_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCodeUrl() {
    return codeUrl;
  }


  public void setCodeUrl(String codeUrl) {
    this.codeUrl = codeUrl;
  }


  public CodeDto amount(Integer amount) {
    
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


  public CodeDto currency(String currency) {
    
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


  public CodeDto orderNo(String orderNo) {
    
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


  public CodeDto description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * 支払いオブジェクトの「決済に関する説明」
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "支払いオブジェクトの「決済に関する説明」")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public CodeDto metadata(Map<String, String> metadata) {
    
    this.metadata = metadata;
    return this;
  }

  public CodeDto putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

   /**
   * 支払いオブジェクトの「メタデータ」
   * @return metadata
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "支払いオブジェクトの「メタデータ」")
  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, String> getMetadata() {
    return metadata;
  }


  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }


  public CodeDto status(CodeStatusType status) {
    
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

  public CodeStatusType getStatus() {
    return status;
  }


  public void setStatus(CodeStatusType status) {
    this.status = status;
  }


  public CodeDto charge(ChargeDto charge) {
    
    this.charge = charge;
    return this;
  }

   /**
   * Get charge
   * @return charge
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CHARGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ChargeDto getCharge() {
    return charge;
  }


  public void setCharge(ChargeDto charge) {
    this.charge = charge;
  }


  public CodeDto frontUrl(String frontUrl) {
    
    this.frontUrl = frontUrl;
    return this;
  }

   /**
   * Get frontUrl
   * @return frontUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FRONT_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFrontUrl() {
    return frontUrl;
  }


  public void setFrontUrl(String frontUrl) {
    this.frontUrl = frontUrl;
  }


  public CodeDto items(List<CodeItem> items) {
    
    this.items = items;
    return this;
  }

  public CodeDto addItemsItem(CodeItem itemsItem) {
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

  public List<CodeItem> getItems() {
    return items;
  }


  public void setItems(List<CodeItem> items) {
    this.items = items;
  }


  public CodeDto expired(Boolean expired) {
    
    this.expired = expired;
    return this;
  }

   /**
   * EasyQRコード有効有無
   * @return expired
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "EasyQRコード有効有無")
  @JsonProperty(JSON_PROPERTY_EXPIRED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getExpired() {
    return expired;
  }


  public void setExpired(Boolean expired) {
    this.expired = expired;
  }


  public CodeDto expiryTime(Long expiryTime) {
    
    this.expiryTime = expiryTime;
    return this;
  }

   /**
   * EasyQRコード有効期限のUTCタイムスタンプ
   * @return expiryTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "EasyQRコード有効期限のUTCタイムスタンプ")
  @JsonProperty(JSON_PROPERTY_EXPIRY_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getExpiryTime() {
    return expiryTime;
  }


  public void setExpiryTime(Long expiryTime) {
    this.expiryTime = expiryTime;
  }


  public CodeDto expiryPeriod(Long expiryPeriod) {
    
    this.expiryPeriod = expiryPeriod;
    return this;
  }

   /**
   * EasyQRコード有効期限までの残りミリ秒数
   * @return expiryPeriod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "EasyQRコード有効期限までの残りミリ秒数")
  @JsonProperty(JSON_PROPERTY_EXPIRY_PERIOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getExpiryPeriod() {
    return expiryPeriod;
  }


  public void setExpiryPeriod(Long expiryPeriod) {
    this.expiryPeriod = expiryPeriod;
  }


  public CodeDto createTime(Long createTime) {
    
    this.createTime = createTime;
    return this;
  }

   /**
   * コード新規時間のUTCタイムスタンプ
   * @return createTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "コード新規時間のUTCタイムスタンプ")
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
    CodeDto codeDto = (CodeDto) o;
    return Objects.equals(this.id, codeDto.id) &&
        Objects.equals(this._object, codeDto._object) &&
        Objects.equals(this.liveMode, codeDto.liveMode) &&
        Objects.equals(this.codeUrl, codeDto.codeUrl) &&
        Objects.equals(this.amount, codeDto.amount) &&
        Objects.equals(this.currency, codeDto.currency) &&
        Objects.equals(this.orderNo, codeDto.orderNo) &&
        Objects.equals(this.description, codeDto.description) &&
        Objects.equals(this.metadata, codeDto.metadata) &&
        Objects.equals(this.status, codeDto.status) &&
        Objects.equals(this.charge, codeDto.charge) &&
        Objects.equals(this.frontUrl, codeDto.frontUrl) &&
        Objects.equals(this.items, codeDto.items) &&
        Objects.equals(this.expired, codeDto.expired) &&
        Objects.equals(this.expiryTime, codeDto.expiryTime) &&
        Objects.equals(this.expiryPeriod, codeDto.expiryPeriod) &&
        Objects.equals(this.createTime, codeDto.createTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, _object, liveMode, codeUrl, amount, currency, orderNo, description, metadata, status, charge, frontUrl, items, expired, expiryTime, expiryPeriod, createTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CodeDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    liveMode: ").append(toIndentedString(liveMode)).append("\n");
    sb.append("    codeUrl: ").append(toIndentedString(codeUrl)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    orderNo: ").append(toIndentedString(orderNo)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    charge: ").append(toIndentedString(charge)).append("\n");
    sb.append("    frontUrl: ").append(toIndentedString(frontUrl)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    expired: ").append(toIndentedString(expired)).append("\n");
    sb.append("    expiryTime: ").append(toIndentedString(expiryTime)).append("\n");
    sb.append("    expiryPeriod: ").append(toIndentedString(expiryPeriod)).append("\n");
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

