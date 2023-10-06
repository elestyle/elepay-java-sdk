/*
 * elepay API リファレンス
 * elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。
 *
 * The version of the OpenAPI document: 1.2.2
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
import io.elepay.client.charge.pojo.ResourceWebEnvType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 決済方法関する情報
 */
@ApiModel(description = "決済方法関する情報")
@JsonPropertyOrder({
  ChannelPropertiesDto.JSON_PROPERTY_IS_SUPPORT_REFUND,
  ChannelPropertiesDto.JSON_PROPERTY_IS_SUPPORT_PARTIAL_REFUND,
  ChannelPropertiesDto.JSON_PROPERTY_IS_SUPPORT_MULTIPLE_REFUND,
  ChannelPropertiesDto.JSON_PROPERTY_IS_SUPPORT_SOURCE,
  ChannelPropertiesDto.JSON_PROPERTY_IS_SUPPORT_MULTIPLE_SOURCE,
  ChannelPropertiesDto.JSON_PROPERTY_MAX_AMOUNT,
  ChannelPropertiesDto.JSON_PROPERTY_MIN_AMOUNT,
  ChannelPropertiesDto.JSON_PROPERTY_RESOURCE_WEB_ENV
})

public class ChannelPropertiesDto {
  public static final String JSON_PROPERTY_IS_SUPPORT_REFUND = "isSupportRefund";
  private Boolean isSupportRefund;

  public static final String JSON_PROPERTY_IS_SUPPORT_PARTIAL_REFUND = "isSupportPartialRefund";
  private Boolean isSupportPartialRefund;

  public static final String JSON_PROPERTY_IS_SUPPORT_MULTIPLE_REFUND = "isSupportMultipleRefund";
  private Boolean isSupportMultipleRefund;

  public static final String JSON_PROPERTY_IS_SUPPORT_SOURCE = "isSupportSource";
  private Boolean isSupportSource;

  public static final String JSON_PROPERTY_IS_SUPPORT_MULTIPLE_SOURCE = "isSupportMultipleSource";
  private Boolean isSupportMultipleSource;

  public static final String JSON_PROPERTY_MAX_AMOUNT = "maxAmount";
  private Integer maxAmount;

  public static final String JSON_PROPERTY_MIN_AMOUNT = "minAmount";
  private Integer minAmount;

  public static final String JSON_PROPERTY_RESOURCE_WEB_ENV = "resourceWebEnv";
  private ResourceWebEnvType resourceWebEnv;


  public ChannelPropertiesDto isSupportRefund(Boolean isSupportRefund) {
    
    this.isSupportRefund = isSupportRefund;
    return this;
  }

   /**
   * 返金 true 利用可能 false 利用不可
   * @return isSupportRefund
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "返金 true 利用可能 false 利用不可")
  @JsonProperty(JSON_PROPERTY_IS_SUPPORT_REFUND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getIsSupportRefund() {
    return isSupportRefund;
  }


  public void setIsSupportRefund(Boolean isSupportRefund) {
    this.isSupportRefund = isSupportRefund;
  }


  public ChannelPropertiesDto isSupportPartialRefund(Boolean isSupportPartialRefund) {
    
    this.isSupportPartialRefund = isSupportPartialRefund;
    return this;
  }

   /**
   * 一部返金 true 利用可能 false 利用不可
   * @return isSupportPartialRefund
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "一部返金 true 利用可能 false 利用不可")
  @JsonProperty(JSON_PROPERTY_IS_SUPPORT_PARTIAL_REFUND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getIsSupportPartialRefund() {
    return isSupportPartialRefund;
  }


  public void setIsSupportPartialRefund(Boolean isSupportPartialRefund) {
    this.isSupportPartialRefund = isSupportPartialRefund;
  }


  public ChannelPropertiesDto isSupportMultipleRefund(Boolean isSupportMultipleRefund) {
    
    this.isSupportMultipleRefund = isSupportMultipleRefund;
    return this;
  }

   /**
   * 複数回返金 true 利用可能 false 一回のみ
   * @return isSupportMultipleRefund
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "複数回返金 true 利用可能 false 一回のみ")
  @JsonProperty(JSON_PROPERTY_IS_SUPPORT_MULTIPLE_REFUND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getIsSupportMultipleRefund() {
    return isSupportMultipleRefund;
  }


  public void setIsSupportMultipleRefund(Boolean isSupportMultipleRefund) {
    this.isSupportMultipleRefund = isSupportMultipleRefund;
  }


  public ChannelPropertiesDto isSupportSource(Boolean isSupportSource) {
    
    this.isSupportSource = isSupportSource;
    return this;
  }

   /**
   * カスタマ機能とソース true 利用可能 false 利用不可
   * @return isSupportSource
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "カスタマ機能とソース true 利用可能 false 利用不可")
  @JsonProperty(JSON_PROPERTY_IS_SUPPORT_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getIsSupportSource() {
    return isSupportSource;
  }


  public void setIsSupportSource(Boolean isSupportSource) {
    this.isSupportSource = isSupportSource;
  }


  public ChannelPropertiesDto isSupportMultipleSource(Boolean isSupportMultipleSource) {
    
    this.isSupportMultipleSource = isSupportMultipleSource;
    return this;
  }

   /**
   * 複数ソース true バインディング可能 false バインディング不可
   * @return isSupportMultipleSource
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "複数ソース true バインディング可能 false バインディング不可")
  @JsonProperty(JSON_PROPERTY_IS_SUPPORT_MULTIPLE_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getIsSupportMultipleSource() {
    return isSupportMultipleSource;
  }


  public void setIsSupportMultipleSource(Boolean isSupportMultipleSource) {
    this.isSupportMultipleSource = isSupportMultipleSource;
  }


  public ChannelPropertiesDto maxAmount(Integer maxAmount) {
    
    this.maxAmount = maxAmount;
    return this;
  }

   /**
   * 最大可能金額
   * @return maxAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "最大可能金額")
  @JsonProperty(JSON_PROPERTY_MAX_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getMaxAmount() {
    return maxAmount;
  }


  public void setMaxAmount(Integer maxAmount) {
    this.maxAmount = maxAmount;
  }


  public ChannelPropertiesDto minAmount(Integer minAmount) {
    
    this.minAmount = minAmount;
    return this;
  }

   /**
   * 最小可能金額
   * @return minAmount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "最小可能金額")
  @JsonProperty(JSON_PROPERTY_MIN_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getMinAmount() {
    return minAmount;
  }


  public void setMinAmount(Integer minAmount) {
    this.minAmount = minAmount;
  }


  public ChannelPropertiesDto resourceWebEnv(ResourceWebEnvType resourceWebEnv) {
    
    this.resourceWebEnv = resourceWebEnv;
    return this;
  }

   /**
   * Get resourceWebEnv
   * @return resourceWebEnv
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_RESOURCE_WEB_ENV)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ResourceWebEnvType getResourceWebEnv() {
    return resourceWebEnv;
  }


  public void setResourceWebEnv(ResourceWebEnvType resourceWebEnv) {
    this.resourceWebEnv = resourceWebEnv;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelPropertiesDto channelPropertiesDto = (ChannelPropertiesDto) o;
    return Objects.equals(this.isSupportRefund, channelPropertiesDto.isSupportRefund) &&
        Objects.equals(this.isSupportPartialRefund, channelPropertiesDto.isSupportPartialRefund) &&
        Objects.equals(this.isSupportMultipleRefund, channelPropertiesDto.isSupportMultipleRefund) &&
        Objects.equals(this.isSupportSource, channelPropertiesDto.isSupportSource) &&
        Objects.equals(this.isSupportMultipleSource, channelPropertiesDto.isSupportMultipleSource) &&
        Objects.equals(this.maxAmount, channelPropertiesDto.maxAmount) &&
        Objects.equals(this.minAmount, channelPropertiesDto.minAmount) &&
        Objects.equals(this.resourceWebEnv, channelPropertiesDto.resourceWebEnv);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isSupportRefund, isSupportPartialRefund, isSupportMultipleRefund, isSupportSource, isSupportMultipleSource, maxAmount, minAmount, resourceWebEnv);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelPropertiesDto {\n");
    sb.append("    isSupportRefund: ").append(toIndentedString(isSupportRefund)).append("\n");
    sb.append("    isSupportPartialRefund: ").append(toIndentedString(isSupportPartialRefund)).append("\n");
    sb.append("    isSupportMultipleRefund: ").append(toIndentedString(isSupportMultipleRefund)).append("\n");
    sb.append("    isSupportSource: ").append(toIndentedString(isSupportSource)).append("\n");
    sb.append("    isSupportMultipleSource: ").append(toIndentedString(isSupportMultipleSource)).append("\n");
    sb.append("    maxAmount: ").append(toIndentedString(maxAmount)).append("\n");
    sb.append("    minAmount: ").append(toIndentedString(minAmount)).append("\n");
    sb.append("    resourceWebEnv: ").append(toIndentedString(resourceWebEnv)).append("\n");
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

