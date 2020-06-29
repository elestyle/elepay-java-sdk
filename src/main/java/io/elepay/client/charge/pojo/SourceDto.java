/*
 * elepay API リファレンス
 * elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。
 *
 * The version of the OpenAPI document: 1.1.12
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
import io.elepay.client.charge.pojo.CardInfo;
import io.elepay.client.charge.pojo.PaymentMethodType;
import io.elepay.client.charge.pojo.ResourceType;
import io.elepay.client.charge.pojo.SourceStatusType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * カスタマソースオブジェクト
 */
@ApiModel(description = "カスタマソースオブジェクト")
@JsonPropertyOrder({
  SourceDto.JSON_PROPERTY_ID,
  SourceDto.JSON_PROPERTY_OBJECT,
  SourceDto.JSON_PROPERTY_LIVE_MODE,
  SourceDto.JSON_PROPERTY_PAYMENT_METHOD,
  SourceDto.JSON_PROPERTY_RESOURCE,
  SourceDto.JSON_PROPERTY_DESCRIPTION,
  SourceDto.JSON_PROPERTY_EXTRA,
  SourceDto.JSON_PROPERTY_INFO,
  SourceDto.JSON_PROPERTY_CARD_INFO,
  SourceDto.JSON_PROPERTY_METADATA,
  SourceDto.JSON_PROPERTY_CREDENTIAL,
  SourceDto.JSON_PROPERTY_STATUS
})

public class SourceDto {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_OBJECT = "object";
  private String _object = "source";

  public static final String JSON_PROPERTY_LIVE_MODE = "liveMode";
  private Boolean liveMode;

  public static final String JSON_PROPERTY_PAYMENT_METHOD = "paymentMethod";
  private PaymentMethodType paymentMethod;

  public static final String JSON_PROPERTY_RESOURCE = "resource";
  private ResourceType resource;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_EXTRA = "extra";
  private Map<String, String> extra = null;

  public static final String JSON_PROPERTY_INFO = "info";
  private Map<String, Object> info = null;

  public static final String JSON_PROPERTY_CARD_INFO = "cardInfo";
  private CardInfo cardInfo;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private Map<String, String> metadata = null;

  public static final String JSON_PROPERTY_CREDENTIAL = "credential";
  private String credential;

  public static final String JSON_PROPERTY_STATUS = "status";
  private SourceStatusType status;


  public SourceDto id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Source ID
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Source ID")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public SourceDto _object(String _object) {
    
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


  public SourceDto liveMode(Boolean liveMode) {
    
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


  public SourceDto paymentMethod(PaymentMethodType paymentMethod) {
    
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


  public SourceDto resource(ResourceType resource) {
    
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


  public SourceDto description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * カスタマソースに関する説明
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "カスタマソースに関する説明")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public SourceDto extra(Map<String, String> extra) {
    
    this.extra = extra;
    return this;
  }

  public SourceDto putExtraItem(String key, String extraItem) {
    if (this.extra == null) {
      this.extra = new HashMap<>();
    }
    this.extra.put(key, extraItem);
    return this;
  }

   /**
   * カスタマソースエキストラデータ
   * @return extra
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "カスタマソースエキストラデータ")
  @JsonProperty(JSON_PROPERTY_EXTRA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, String> getExtra() {
    return extra;
  }


  public void setExtra(Map<String, String> extra) {
    this.extra = extra;
  }


  public SourceDto info(Map<String, Object> info) {
    
    this.info = info;
    return this;
  }

  public SourceDto putInfoItem(String key, Object infoItem) {
    if (this.info == null) {
      this.info = new HashMap<>();
    }
    this.info.put(key, infoItem);
    return this;
  }

   /**
   * カスタマソース情報
   * @return info
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "カスタマソース情報")
  @JsonProperty(JSON_PROPERTY_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, Object> getInfo() {
    return info;
  }


  public void setInfo(Map<String, Object> info) {
    this.info = info;
  }


  public SourceDto cardInfo(CardInfo cardInfo) {
    
    this.cardInfo = cardInfo;
    return this;
  }

   /**
   * Get cardInfo
   * @return cardInfo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CARD_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CardInfo getCardInfo() {
    return cardInfo;
  }


  public void setCardInfo(CardInfo cardInfo) {
    this.cardInfo = cardInfo;
  }


  public SourceDto metadata(Map<String, String> metadata) {
    
    this.metadata = metadata;
    return this;
  }

  public SourceDto putMetadataItem(String key, String metadataItem) {
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

  public Map<String, String> getMetadata() {
    return metadata;
  }


  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }


  public SourceDto credential(String credential) {
    
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


  public SourceDto status(SourceStatusType status) {
    
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

  public SourceStatusType getStatus() {
    return status;
  }


  public void setStatus(SourceStatusType status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceDto sourceDto = (SourceDto) o;
    return Objects.equals(this.id, sourceDto.id) &&
        Objects.equals(this._object, sourceDto._object) &&
        Objects.equals(this.liveMode, sourceDto.liveMode) &&
        Objects.equals(this.paymentMethod, sourceDto.paymentMethod) &&
        Objects.equals(this.resource, sourceDto.resource) &&
        Objects.equals(this.description, sourceDto.description) &&
        Objects.equals(this.extra, sourceDto.extra) &&
        Objects.equals(this.info, sourceDto.info) &&
        Objects.equals(this.cardInfo, sourceDto.cardInfo) &&
        Objects.equals(this.metadata, sourceDto.metadata) &&
        Objects.equals(this.credential, sourceDto.credential) &&
        Objects.equals(this.status, sourceDto.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, _object, liveMode, paymentMethod, resource, description, extra, info, cardInfo, metadata, credential, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    liveMode: ").append(toIndentedString(liveMode)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    resource: ").append(toIndentedString(resource)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    extra: ").append(toIndentedString(extra)).append("\n");
    sb.append("    info: ").append(toIndentedString(info)).append("\n");
    sb.append("    cardInfo: ").append(toIndentedString(cardInfo)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    credential: ").append(toIndentedString(credential)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

