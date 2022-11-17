/*
 * elepay API リファレンス
 * elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。
 *
 * The version of the OpenAPI document: 1.2.0
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
import io.elepay.client.charge.pojo.DisputeStatusType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 不審請求オブジェクト
 */
@ApiModel(description = "不審請求オブジェクト")
@JsonPropertyOrder({
  DisputeDto.JSON_PROPERTY_ID,
  DisputeDto.JSON_PROPERTY_OBJECT,
  DisputeDto.JSON_PROPERTY_CHARGE_ID,
  DisputeDto.JSON_PROPERTY_LIVE_MODE,
  DisputeDto.JSON_PROPERTY_AMOUNT,
  DisputeDto.JSON_PROPERTY_CURRENCY,
  DisputeDto.JSON_PROPERTY_METADATA,
  DisputeDto.JSON_PROPERTY_REASON,
  DisputeDto.JSON_PROPERTY_STATUS,
  DisputeDto.JSON_PROPERTY_RESOLVED_TIME,
  DisputeDto.JSON_PROPERTY_CREATE_TIME
})

public class DisputeDto {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_OBJECT = "object";
  private String _object = "dispute";

  public static final String JSON_PROPERTY_CHARGE_ID = "chargeId";
  private String chargeId;

  public static final String JSON_PROPERTY_LIVE_MODE = "liveMode";
  private Boolean liveMode;

  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private Integer amount;

  public static final String JSON_PROPERTY_CURRENCY = "currency";
  private String currency;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private Map<String, String> metadata = null;

  public static final String JSON_PROPERTY_REASON = "reason";
  private String reason;

  public static final String JSON_PROPERTY_STATUS = "status";
  private DisputeStatusType status;

  public static final String JSON_PROPERTY_RESOLVED_TIME = "resolvedTime";
  private Long resolvedTime;

  public static final String JSON_PROPERTY_CREATE_TIME = "createTime";
  private Long createTime;


  public DisputeDto id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Dispute ID
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Dispute ID")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public DisputeDto _object(String _object) {
    
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


  public DisputeDto chargeId(String chargeId) {
    
    this.chargeId = chargeId;
    return this;
  }

   /**
   * Charge ID
   * @return chargeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Charge ID")
  @JsonProperty(JSON_PROPERTY_CHARGE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getChargeId() {
    return chargeId;
  }


  public void setChargeId(String chargeId) {
    this.chargeId = chargeId;
  }


  public DisputeDto liveMode(Boolean liveMode) {
    
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


  public DisputeDto amount(Integer amount) {
    
    this.amount = amount;
    return this;
  }

   /**
   * 不審請求金額
   * @return amount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "不審請求金額")
  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getAmount() {
    return amount;
  }


  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  public DisputeDto currency(String currency) {
    
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


  public DisputeDto metadata(Map<String, String> metadata) {
    
    this.metadata = metadata;
    return this;
  }

  public DisputeDto putMetadataItem(String key, String metadataItem) {
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


  public DisputeDto reason(String reason) {
    
    this.reason = reason;
    return this;
  }

   /**
   * 不審請求理由
   * @return reason
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "不審請求理由")
  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getReason() {
    return reason;
  }


  public void setReason(String reason) {
    this.reason = reason;
  }


  public DisputeDto status(DisputeStatusType status) {
    
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

  public DisputeStatusType getStatus() {
    return status;
  }


  public void setStatus(DisputeStatusType status) {
    this.status = status;
  }


  public DisputeDto resolvedTime(Long resolvedTime) {
    
    this.resolvedTime = resolvedTime;
    return this;
  }

   /**
   * 対応時間のUTCタイムスタンプ
   * @return resolvedTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "対応時間のUTCタイムスタンプ")
  @JsonProperty(JSON_PROPERTY_RESOLVED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getResolvedTime() {
    return resolvedTime;
  }


  public void setResolvedTime(Long resolvedTime) {
    this.resolvedTime = resolvedTime;
  }


  public DisputeDto createTime(Long createTime) {
    
    this.createTime = createTime;
    return this;
  }

   /**
   * 発生時間のUTCタイムスタンプ。
   * @return createTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "発生時間のUTCタイムスタンプ。")
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
    DisputeDto disputeDto = (DisputeDto) o;
    return Objects.equals(this.id, disputeDto.id) &&
        Objects.equals(this._object, disputeDto._object) &&
        Objects.equals(this.chargeId, disputeDto.chargeId) &&
        Objects.equals(this.liveMode, disputeDto.liveMode) &&
        Objects.equals(this.amount, disputeDto.amount) &&
        Objects.equals(this.currency, disputeDto.currency) &&
        Objects.equals(this.metadata, disputeDto.metadata) &&
        Objects.equals(this.reason, disputeDto.reason) &&
        Objects.equals(this.status, disputeDto.status) &&
        Objects.equals(this.resolvedTime, disputeDto.resolvedTime) &&
        Objects.equals(this.createTime, disputeDto.createTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, _object, chargeId, liveMode, amount, currency, metadata, reason, status, resolvedTime, createTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DisputeDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    chargeId: ").append(toIndentedString(chargeId)).append("\n");
    sb.append("    liveMode: ").append(toIndentedString(liveMode)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    resolvedTime: ").append(toIndentedString(resolvedTime)).append("\n");
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

