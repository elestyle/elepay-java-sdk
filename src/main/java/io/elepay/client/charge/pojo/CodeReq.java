/*
 * elepay API リファレンス
 * elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。
 *
 * The version of the OpenAPI document: 1.2.4
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
import io.elepay.client.charge.pojo.CodeItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * EasyQRコードリクエスト
 */
@ApiModel(description = "EasyQRコードリクエスト")
@JsonPropertyOrder({
  CodeReq.JSON_PROPERTY_AMOUNT,
  CodeReq.JSON_PROPERTY_CURRENCY,
  CodeReq.JSON_PROPERTY_ORDER_NO,
  CodeReq.JSON_PROPERTY_DESCRIPTION,
  CodeReq.JSON_PROPERTY_EXTRA,
  CodeReq.JSON_PROPERTY_METADATA,
  CodeReq.JSON_PROPERTY_EXPIRY_DURATION,
  CodeReq.JSON_PROPERTY_FRONT_URL,
  CodeReq.JSON_PROPERTY_ITEMS
})

public class CodeReq {
  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private Integer amount;

  public static final String JSON_PROPERTY_CURRENCY = "currency";
  private String currency = "JPY";

  public static final String JSON_PROPERTY_ORDER_NO = "orderNo";
  private String orderNo;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_EXTRA = "extra";
  private Map<String, String> extra = null;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private Map<String, String> metadata = null;

  public static final String JSON_PROPERTY_EXPIRY_DURATION = "expiryDuration";
  private Integer expiryDuration;

  public static final String JSON_PROPERTY_FRONT_URL = "frontUrl";
  private String frontUrl;

  public static final String JSON_PROPERTY_ITEMS = "items";
  private List<CodeItem> items = null;


  public CodeReq amount(Integer amount) {
    
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


  public CodeReq currency(String currency) {
    
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


  public CodeReq orderNo(String orderNo) {
    
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


  public CodeReq description(String description) {
    
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


  public CodeReq extra(Map<String, String> extra) {
    
    this.extra = extra;
    return this;
  }

  public CodeReq putExtraItem(String key, String extraItem) {
    if (this.extra == null) {
      this.extra = new HashMap<>();
    }
    this.extra.put(key, extraItem);
    return this;
  }

   /**
   * 決済に関する追加情報がある場合に利用します。具体的設定情報は「開発ガイド-&gt;決済Extra情報設定」を参照してください。 決済オブジェクトを作成する時、こちら設定したextra情報を優先利用します。 
   * @return extra
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "決済に関する追加情報がある場合に利用します。具体的設定情報は「開発ガイド->決済Extra情報設定」を参照してください。 決済オブジェクトを作成する時、こちら設定したextra情報を優先利用します。 ")
  @JsonProperty(JSON_PROPERTY_EXTRA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, String> getExtra() {
    return extra;
  }


  public void setExtra(Map<String, String> extra) {
    this.extra = extra;
  }


  public CodeReq metadata(Map<String, String> metadata) {
    
    this.metadata = metadata;
    return this;
  }

  public CodeReq putMetadataItem(String key, String metadataItem) {
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


  public CodeReq expiryDuration(Integer expiryDuration) {
    
    this.expiryDuration = expiryDuration;
    return this;
  }

   /**
   * EasyQRコード有効期限(分) 最小:3分、最大:30分、デフォルト:10分 
   * @return expiryDuration
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "EasyQRコード有効期限(分) 最小:3分、最大:30分、デフォルト:10分 ")
  @JsonProperty(JSON_PROPERTY_EXPIRY_DURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getExpiryDuration() {
    return expiryDuration;
  }


  public void setExpiryDuration(Integer expiryDuration) {
    this.expiryDuration = expiryDuration;
  }


  public CodeReq frontUrl(String frontUrl) {
    
    this.frontUrl = frontUrl;
    return this;
  }

   /**
   * EasyCheckout決済が完了したあとの、戻り先ページのURL
   * @return frontUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "EasyCheckout決済が完了したあとの、戻り先ページのURL")
  @JsonProperty(JSON_PROPERTY_FRONT_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFrontUrl() {
    return frontUrl;
  }


  public void setFrontUrl(String frontUrl) {
    this.frontUrl = frontUrl;
  }


  public CodeReq items(List<CodeItem> items) {
    
    this.items = items;
    return this;
  }

  public CodeReq addItemsItem(CodeItem itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * 商品に関する情報
   * @return items
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "商品に関する情報")
  @JsonProperty(JSON_PROPERTY_ITEMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<CodeItem> getItems() {
    return items;
  }


  public void setItems(List<CodeItem> items) {
    this.items = items;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CodeReq codeReq = (CodeReq) o;
    return Objects.equals(this.amount, codeReq.amount) &&
        Objects.equals(this.currency, codeReq.currency) &&
        Objects.equals(this.orderNo, codeReq.orderNo) &&
        Objects.equals(this.description, codeReq.description) &&
        Objects.equals(this.extra, codeReq.extra) &&
        Objects.equals(this.metadata, codeReq.metadata) &&
        Objects.equals(this.expiryDuration, codeReq.expiryDuration) &&
        Objects.equals(this.frontUrl, codeReq.frontUrl) &&
        Objects.equals(this.items, codeReq.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, currency, orderNo, description, extra, metadata, expiryDuration, frontUrl, items);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CodeReq {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    orderNo: ").append(toIndentedString(orderNo)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    extra: ").append(toIndentedString(extra)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    expiryDuration: ").append(toIndentedString(expiryDuration)).append("\n");
    sb.append("    frontUrl: ").append(toIndentedString(frontUrl)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

