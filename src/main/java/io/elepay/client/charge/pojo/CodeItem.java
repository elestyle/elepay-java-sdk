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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 商品情報
 */
@ApiModel(description = "商品情報")
@JsonPropertyOrder({
  CodeItem.JSON_PROPERTY_NAME,
  CodeItem.JSON_PROPERTY_IMAGE,
  CodeItem.JSON_PROPERTY_PRICE,
  CodeItem.JSON_PROPERTY_COUNT
})

public class CodeItem {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_IMAGE = "image";
  private String image;

  public static final String JSON_PROPERTY_PRICE = "price";
  private Integer price;

  public static final String JSON_PROPERTY_COUNT = "count";
  private Integer count;


  public CodeItem name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * 商品の名前
   * @return name
  **/
  @ApiModelProperty(required = true, value = "商品の名前")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public CodeItem image(String image) {
    
    this.image = image;
    return this;
  }

   /**
   * 商品の画像URL
   * @return image
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "商品の画像URL")
  @JsonProperty(JSON_PROPERTY_IMAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getImage() {
    return image;
  }


  public void setImage(String image) {
    this.image = image;
  }


  public CodeItem price(Integer price) {
    
    this.price = price;
    return this;
  }

   /**
   * 各商品の決済金額
   * @return price
  **/
  @ApiModelProperty(required = true, value = "各商品の決済金額")
  @JsonProperty(JSON_PROPERTY_PRICE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getPrice() {
    return price;
  }


  public void setPrice(Integer price) {
    this.price = price;
  }


  public CodeItem count(Integer count) {
    
    this.count = count;
    return this;
  }

   /**
   * 商品数
   * @return count
  **/
  @ApiModelProperty(required = true, value = "商品数")
  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getCount() {
    return count;
  }


  public void setCount(Integer count) {
    this.count = count;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CodeItem codeItem = (CodeItem) o;
    return Objects.equals(this.name, codeItem.name) &&
        Objects.equals(this.image, codeItem.image) &&
        Objects.equals(this.price, codeItem.price) &&
        Objects.equals(this.count, codeItem.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, image, price, count);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CodeItem {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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

