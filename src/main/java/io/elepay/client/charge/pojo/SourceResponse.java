/*
 * elepay API リファレンス
 * elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。
 *
 * The version of the OpenAPI document: 1.1.5
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
import io.elepay.client.charge.pojo.SourceDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * カスタマソース情報リスト
 */
@ApiModel(description = "カスタマソース情報リスト")
@JsonPropertyOrder({
  SourceResponse.JSON_PROPERTY_TOTAL,
  SourceResponse.JSON_PROPERTY_SOURCES
})

public class SourceResponse {
  public static final String JSON_PROPERTY_TOTAL = "total";
  private Integer total;

  public static final String JSON_PROPERTY_SOURCES = "sources";
  private List<SourceDto> sources = null;


  public SourceResponse total(Integer total) {
    
    this.total = total;
    return this;
  }

   /**
   * 件数
   * @return total
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "件数")
  @JsonProperty(JSON_PROPERTY_TOTAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getTotal() {
    return total;
  }


  public void setTotal(Integer total) {
    this.total = total;
  }


  public SourceResponse sources(List<SourceDto> sources) {
    
    this.sources = sources;
    return this;
  }

  public SourceResponse addSourcesItem(SourceDto sourcesItem) {
    if (this.sources == null) {
      this.sources = new ArrayList<>();
    }
    this.sources.add(sourcesItem);
    return this;
  }

   /**
   * カスタマソース詳細内容
   * @return sources
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "カスタマソース詳細内容")
  @JsonProperty(JSON_PROPERTY_SOURCES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<SourceDto> getSources() {
    return sources;
  }


  public void setSources(List<SourceDto> sources) {
    this.sources = sources;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceResponse sourceResponse = (SourceResponse) o;
    return Objects.equals(this.total, sourceResponse.total) &&
        Objects.equals(this.sources, sourceResponse.sources);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, sources);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceResponse {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    sources: ").append(toIndentedString(sources)).append("\n");
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

