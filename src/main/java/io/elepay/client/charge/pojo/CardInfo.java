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
import io.elepay.client.charge.pojo.CardBrandType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * カード情報やウォレット情報
 */
@ApiModel(description = "カード情報やウォレット情報")
@JsonPropertyOrder({
  CardInfo.JSON_PROPERTY_BRAND,
  CardInfo.JSON_PROPERTY_LAST4,
  CardInfo.JSON_PROPERTY_EXP_MONTH,
  CardInfo.JSON_PROPERTY_EXP_YEAR,
  CardInfo.JSON_PROPERTY_NAME,
  CardInfo.JSON_PROPERTY_WALLET,
  CardInfo.JSON_PROPERTY_THREE_D_SECURE,
  CardInfo.JSON_PROPERTY_THREE_D_SECURE_VERSION
})

public class CardInfo {
  public static final String JSON_PROPERTY_BRAND = "brand";
  private CardBrandType brand;

  public static final String JSON_PROPERTY_LAST4 = "last4";
  private String last4;

  public static final String JSON_PROPERTY_EXP_MONTH = "expMonth";
  private Integer expMonth;

  public static final String JSON_PROPERTY_EXP_YEAR = "expYear";
  private Integer expYear;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_WALLET = "wallet";
  private String wallet;

  public static final String JSON_PROPERTY_THREE_D_SECURE = "threeDSecure";
  private Boolean threeDSecure;

  public static final String JSON_PROPERTY_THREE_D_SECURE_VERSION = "threeDSecureVersion";
  private String threeDSecureVersion;


  public CardInfo brand(CardBrandType brand) {
    
    this.brand = brand;
    return this;
  }

   /**
   * Get brand
   * @return brand
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BRAND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CardBrandType getBrand() {
    return brand;
  }


  public void setBrand(CardBrandType brand) {
    this.brand = brand;
  }


  public CardInfo last4(String last4) {
    
    this.last4 = last4;
    return this;
  }

   /**
   * カード番号の下四桁
   * @return last4
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "カード番号の下四桁")
  @JsonProperty(JSON_PROPERTY_LAST4)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLast4() {
    return last4;
  }


  public void setLast4(String last4) {
    this.last4 = last4;
  }


  public CardInfo expMonth(Integer expMonth) {
    
    this.expMonth = expMonth;
    return this;
  }

   /**
   * 有効期限月
   * @return expMonth
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "有効期限月")
  @JsonProperty(JSON_PROPERTY_EXP_MONTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getExpMonth() {
    return expMonth;
  }


  public void setExpMonth(Integer expMonth) {
    this.expMonth = expMonth;
  }


  public CardInfo expYear(Integer expYear) {
    
    this.expYear = expYear;
    return this;
  }

   /**
   * 有効期限年
   * @return expYear
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "有効期限年")
  @JsonProperty(JSON_PROPERTY_EXP_YEAR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getExpYear() {
    return expYear;
  }


  public void setExpYear(Integer expYear) {
    this.expYear = expYear;
  }


  public CardInfo name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * カード保有者名
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "カード保有者名")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public CardInfo wallet(String wallet) {
    
    this.wallet = wallet;
    return this;
  }

   /**
   * ウォレット情報
   * @return wallet
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ウォレット情報")
  @JsonProperty(JSON_PROPERTY_WALLET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getWallet() {
    return wallet;
  }


  public void setWallet(String wallet) {
    this.wallet = wallet;
  }


  public CardInfo threeDSecure(Boolean threeDSecure) {
    
    this.threeDSecure = threeDSecure;
    return this;
  }

   /**
   * 3Dセキュア有無
   * @return threeDSecure
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "3Dセキュア有無")
  @JsonProperty(JSON_PROPERTY_THREE_D_SECURE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getThreeDSecure() {
    return threeDSecure;
  }


  public void setThreeDSecure(Boolean threeDSecure) {
    this.threeDSecure = threeDSecure;
  }


  public CardInfo threeDSecureVersion(String threeDSecureVersion) {
    
    this.threeDSecureVersion = threeDSecureVersion;
    return this;
  }

   /**
   * 3Dセキュアバージョン
   * @return threeDSecureVersion
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "3Dセキュアバージョン")
  @JsonProperty(JSON_PROPERTY_THREE_D_SECURE_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getThreeDSecureVersion() {
    return threeDSecureVersion;
  }


  public void setThreeDSecureVersion(String threeDSecureVersion) {
    this.threeDSecureVersion = threeDSecureVersion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardInfo cardInfo = (CardInfo) o;
    return Objects.equals(this.brand, cardInfo.brand) &&
        Objects.equals(this.last4, cardInfo.last4) &&
        Objects.equals(this.expMonth, cardInfo.expMonth) &&
        Objects.equals(this.expYear, cardInfo.expYear) &&
        Objects.equals(this.name, cardInfo.name) &&
        Objects.equals(this.wallet, cardInfo.wallet) &&
        Objects.equals(this.threeDSecure, cardInfo.threeDSecure) &&
        Objects.equals(this.threeDSecureVersion, cardInfo.threeDSecureVersion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(brand, last4, expMonth, expYear, name, wallet, threeDSecure, threeDSecureVersion);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardInfo {\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    last4: ").append(toIndentedString(last4)).append("\n");
    sb.append("    expMonth: ").append(toIndentedString(expMonth)).append("\n");
    sb.append("    expYear: ").append(toIndentedString(expYear)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    wallet: ").append(toIndentedString(wallet)).append("\n");
    sb.append("    threeDSecure: ").append(toIndentedString(threeDSecure)).append("\n");
    sb.append("    threeDSecureVersion: ").append(toIndentedString(threeDSecureVersion)).append("\n");
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

