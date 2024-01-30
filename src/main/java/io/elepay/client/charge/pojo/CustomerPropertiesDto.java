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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 決済方法カスタマ関する情報。廃棄予定。ChannelPropertiesDtoを利用してください。 
 */
@ApiModel(description = "決済方法カスタマ関する情報。廃棄予定。ChannelPropertiesDtoを利用してください。 ")
@JsonPropertyOrder({
  CustomerPropertiesDto.JSON_PROPERTY_IS_SUPPORT_CUSTOMER,
  CustomerPropertiesDto.JSON_PROPERTY_IS_SUPPORT_MULTIPLE_SOURCE
})

public class CustomerPropertiesDto {
  public static final String JSON_PROPERTY_IS_SUPPORT_CUSTOMER = "isSupportCustomer";
  private Boolean isSupportCustomer;

  public static final String JSON_PROPERTY_IS_SUPPORT_MULTIPLE_SOURCE = "isSupportMultipleSource";
  private Boolean isSupportMultipleSource;


  public CustomerPropertiesDto isSupportCustomer(Boolean isSupportCustomer) {
    
    this.isSupportCustomer = isSupportCustomer;
    return this;
  }

   /**
   * 廃棄予定。ChannelPropertiesDto.isSupportSourceを利用してください。 カスタマ機能 true 利用可能 false カスタマ利用不可。 
   * @return isSupportCustomer
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "廃棄予定。ChannelPropertiesDto.isSupportSourceを利用してください。 カスタマ機能 true 利用可能 false カスタマ利用不可。 ")
  @JsonProperty(JSON_PROPERTY_IS_SUPPORT_CUSTOMER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getIsSupportCustomer() {
    return isSupportCustomer;
  }


  public void setIsSupportCustomer(Boolean isSupportCustomer) {
    this.isSupportCustomer = isSupportCustomer;
  }


  public CustomerPropertiesDto isSupportMultipleSource(Boolean isSupportMultipleSource) {
    
    this.isSupportMultipleSource = isSupportMultipleSource;
    return this;
  }

   /**
   * 廃棄予定。ChannelPropertiesDto.isSupportMultipleSourceを利用してください。 複数ソース true バインディング可能 false バインディング不可 
   * @return isSupportMultipleSource
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "廃棄予定。ChannelPropertiesDto.isSupportMultipleSourceを利用してください。 複数ソース true バインディング可能 false バインディング不可 ")
  @JsonProperty(JSON_PROPERTY_IS_SUPPORT_MULTIPLE_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getIsSupportMultipleSource() {
    return isSupportMultipleSource;
  }


  public void setIsSupportMultipleSource(Boolean isSupportMultipleSource) {
    this.isSupportMultipleSource = isSupportMultipleSource;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerPropertiesDto customerPropertiesDto = (CustomerPropertiesDto) o;
    return Objects.equals(this.isSupportCustomer, customerPropertiesDto.isSupportCustomer) &&
        Objects.equals(this.isSupportMultipleSource, customerPropertiesDto.isSupportMultipleSource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isSupportCustomer, isSupportMultipleSource);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerPropertiesDto {\n");
    sb.append("    isSupportCustomer: ").append(toIndentedString(isSupportCustomer)).append("\n");
    sb.append("    isSupportMultipleSource: ").append(toIndentedString(isSupportMultipleSource)).append("\n");
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

