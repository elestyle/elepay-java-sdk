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
 * Locationオブジェクト
 */
@ApiModel(description = "Locationオブジェクト")
@JsonPropertyOrder({
  LocationDto.JSON_PROPERTY_ID,
  LocationDto.JSON_PROPERTY_NAME,
  LocationDto.JSON_PROPERTY_COUNTRY,
  LocationDto.JSON_PROPERTY_DESCRIPTION,
  LocationDto.JSON_PROPERTY_LOGO_URL
})

public class LocationDto {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_COUNTRY = "country";
  private String country;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_LOGO_URL = "logoUrl";
  private String logoUrl;


  public LocationDto id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Location ID
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Location ID")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public LocationDto name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Location名
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Location名")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public LocationDto country(String country) {
    
    this.country = country;
    return this;
  }

   /**
   * Location国名
   * @return country
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Location国名")
  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCountry() {
    return country;
  }


  public void setCountry(String country) {
    this.country = country;
  }


  public LocationDto description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Location詳細
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Location詳細")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public LocationDto logoUrl(String logoUrl) {
    
    this.logoUrl = logoUrl;
    return this;
  }

   /**
   * LocationロゴURL
   * @return logoUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "LocationロゴURL")
  @JsonProperty(JSON_PROPERTY_LOGO_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLogoUrl() {
    return logoUrl;
  }


  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocationDto locationDto = (LocationDto) o;
    return Objects.equals(this.id, locationDto.id) &&
        Objects.equals(this.name, locationDto.name) &&
        Objects.equals(this.country, locationDto.country) &&
        Objects.equals(this.description, locationDto.description) &&
        Objects.equals(this.logoUrl, locationDto.logoUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, country, description, logoUrl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocationDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    logoUrl: ").append(toIndentedString(logoUrl)).append("\n");
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

