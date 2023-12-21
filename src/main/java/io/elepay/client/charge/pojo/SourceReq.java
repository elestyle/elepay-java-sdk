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
import io.elepay.client.charge.pojo.PaymentMethodType;
import io.elepay.client.charge.pojo.ResourceType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * カスタマソースリクエスト
 */
@ApiModel(description = "カスタマソースリクエスト")
@JsonPropertyOrder({
  SourceReq.JSON_PROPERTY_PAYMENT_METHOD,
  SourceReq.JSON_PROPERTY_RESOURCE,
  SourceReq.JSON_PROPERTY_DESCRIPTION,
  SourceReq.JSON_PROPERTY_EXTRA,
  SourceReq.JSON_PROPERTY_METADATA
})

public class SourceReq {
  public static final String JSON_PROPERTY_PAYMENT_METHOD = "paymentMethod";
  private PaymentMethodType paymentMethod;

  public static final String JSON_PROPERTY_RESOURCE = "resource";
  private ResourceType resource;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_EXTRA = "extra";
  private Map<String, String> extra = null;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private Map<String, String> metadata = null;


  public SourceReq paymentMethod(PaymentMethodType paymentMethod) {
    
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


  public SourceReq resource(ResourceType resource) {
    
    this.resource = resource;
    return this;
  }

   /**
   * Get resource
   * @return resource
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_RESOURCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ResourceType getResource() {
    return resource;
  }


  public void setResource(ResourceType resource) {
    this.resource = resource;
  }


  public SourceReq description(String description) {
    
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


  public SourceReq extra(Map<String, String> extra) {
    
    this.extra = extra;
    return this;
  }

  public SourceReq putExtraItem(String key, String extraItem) {
    if (this.extra == null) {
      this.extra = new HashMap<>();
    }
    this.extra.put(key, extraItem);
    return this;
  }

   /**
   * 決済に関する追加情報がある場合に利用します。具体的設定情報は「開発ガイド-&gt;ソースExtra情報設定」を参照してください。
   * @return extra
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "決済に関する追加情報がある場合に利用します。具体的設定情報は「開発ガイド->ソースExtra情報設定」を参照してください。")
  @JsonProperty(JSON_PROPERTY_EXTRA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, String> getExtra() {
    return extra;
  }


  public void setExtra(Map<String, String> extra) {
    this.extra = extra;
  }


  public SourceReq metadata(Map<String, String> metadata) {
    
    this.metadata = metadata;
    return this;
  }

  public SourceReq putMetadataItem(String key, String metadataItem) {
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
    SourceReq sourceReq = (SourceReq) o;
    return Objects.equals(this.paymentMethod, sourceReq.paymentMethod) &&
        Objects.equals(this.resource, sourceReq.resource) &&
        Objects.equals(this.description, sourceReq.description) &&
        Objects.equals(this.extra, sourceReq.extra) &&
        Objects.equals(this.metadata, sourceReq.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentMethod, resource, description, extra, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceReq {\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    resource: ").append(toIndentedString(resource)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    extra: ").append(toIndentedString(extra)).append("\n");
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

