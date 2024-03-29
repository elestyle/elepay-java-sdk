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
import io.elepay.client.charge.pojo.ChannelPropertiesDto;
import io.elepay.client.charge.pojo.CustomerPropertiesDto;
import io.elepay.client.charge.pojo.PaymentMethodType;
import io.elepay.client.charge.pojo.ResourceType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 決済方法詳細情報
 */
@ApiModel(description = "決済方法詳細情報")
@JsonPropertyOrder({
  PaymentMethodDto.JSON_PROPERTY_PAYMENT_METHOD,
  PaymentMethodDto.JSON_PROPERTY_RESOURCES,
  PaymentMethodDto.JSON_PROPERTY_BRAND,
  PaymentMethodDto.JSON_PROPERTY_UA,
  PaymentMethodDto.JSON_PROPERTY_CHANNEL_PROPERTIES,
  PaymentMethodDto.JSON_PROPERTY_CUSTOMER_PROPERTIES
})

public class PaymentMethodDto {
  public static final String JSON_PROPERTY_PAYMENT_METHOD = "paymentMethod";
  private PaymentMethodType paymentMethod;

  public static final String JSON_PROPERTY_RESOURCES = "resources";
  private List<ResourceType> resources = null;

  public static final String JSON_PROPERTY_BRAND = "brand";
  private List<String> brand = null;

  public static final String JSON_PROPERTY_UA = "ua";
  private String ua;

  public static final String JSON_PROPERTY_CHANNEL_PROPERTIES = "channelProperties";
  private ChannelPropertiesDto channelProperties;

  public static final String JSON_PROPERTY_CUSTOMER_PROPERTIES = "customerProperties";
  private CustomerPropertiesDto customerProperties;


  public PaymentMethodDto paymentMethod(PaymentMethodType paymentMethod) {
    
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


  public PaymentMethodDto resources(List<ResourceType> resources) {
    
    this.resources = resources;
    return this;
  }

  public PaymentMethodDto addResourcesItem(ResourceType resourcesItem) {
    if (this.resources == null) {
      this.resources = new ArrayList<>();
    }
    this.resources.add(resourcesItem);
    return this;
  }

   /**
   * Get resources
   * @return resources
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_RESOURCES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ResourceType> getResources() {
    return resources;
  }


  public void setResources(List<ResourceType> resources) {
    this.resources = resources;
  }


  public PaymentMethodDto brand(List<String> brand) {
    
    this.brand = brand;
    return this;
  }

  public PaymentMethodDto addBrandItem(String brandItem) {
    if (this.brand == null) {
      this.brand = new ArrayList<>();
    }
    this.brand.add(brandItem);
    return this;
  }

   /**
   * クレジットカードの場合、利用できるクレジットカードブランド
   * @return brand
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "クレジットカードの場合、利用できるクレジットカードブランド")
  @JsonProperty(JSON_PROPERTY_BRAND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getBrand() {
    return brand;
  }


  public void setBrand(List<String> brand) {
    this.brand = brand;
  }


  public PaymentMethodDto ua(String ua) {
    
    this.ua = ua;
    return this;
  }

   /**
   * 利用できるブラウザのUserAgent
   * @return ua
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "利用できるブラウザのUserAgent")
  @JsonProperty(JSON_PROPERTY_UA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getUa() {
    return ua;
  }


  public void setUa(String ua) {
    this.ua = ua;
  }


  public PaymentMethodDto channelProperties(ChannelPropertiesDto channelProperties) {
    
    this.channelProperties = channelProperties;
    return this;
  }

   /**
   * Get channelProperties
   * @return channelProperties
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CHANNEL_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ChannelPropertiesDto getChannelProperties() {
    return channelProperties;
  }


  public void setChannelProperties(ChannelPropertiesDto channelProperties) {
    this.channelProperties = channelProperties;
  }


  public PaymentMethodDto customerProperties(CustomerPropertiesDto customerProperties) {
    
    this.customerProperties = customerProperties;
    return this;
  }

   /**
   * Get customerProperties
   * @return customerProperties
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CUSTOMER_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CustomerPropertiesDto getCustomerProperties() {
    return customerProperties;
  }


  public void setCustomerProperties(CustomerPropertiesDto customerProperties) {
    this.customerProperties = customerProperties;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentMethodDto paymentMethodDto = (PaymentMethodDto) o;
    return Objects.equals(this.paymentMethod, paymentMethodDto.paymentMethod) &&
        Objects.equals(this.resources, paymentMethodDto.resources) &&
        Objects.equals(this.brand, paymentMethodDto.brand) &&
        Objects.equals(this.ua, paymentMethodDto.ua) &&
        Objects.equals(this.channelProperties, paymentMethodDto.channelProperties) &&
        Objects.equals(this.customerProperties, paymentMethodDto.customerProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentMethod, resources, brand, ua, channelProperties, customerProperties);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentMethodDto {\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    ua: ").append(toIndentedString(ua)).append("\n");
    sb.append("    channelProperties: ").append(toIndentedString(channelProperties)).append("\n");
    sb.append("    customerProperties: ").append(toIndentedString(customerProperties)).append("\n");
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

