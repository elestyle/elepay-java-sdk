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
import io.elepay.client.charge.pojo.TerminalReaderDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * リーダー情報リスト
 */
@ApiModel(description = "リーダー情報リスト")
@JsonPropertyOrder({
  TerminalReadersResponse.JSON_PROPERTY_TOTAL,
  TerminalReadersResponse.JSON_PROPERTY_READERS
})

public class TerminalReadersResponse {
  public static final String JSON_PROPERTY_TOTAL = "total";
  private Integer total;

  public static final String JSON_PROPERTY_READERS = "readers";
  private List<TerminalReaderDto> readers = null;


  public TerminalReadersResponse total(Integer total) {
    
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


  public TerminalReadersResponse readers(List<TerminalReaderDto> readers) {
    
    this.readers = readers;
    return this;
  }

  public TerminalReadersResponse addReadersItem(TerminalReaderDto readersItem) {
    if (this.readers == null) {
      this.readers = new ArrayList<>();
    }
    this.readers.add(readersItem);
    return this;
  }

   /**
   * リーダー詳細情報
   * @return readers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "リーダー詳細情報")
  @JsonProperty(JSON_PROPERTY_READERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<TerminalReaderDto> getReaders() {
    return readers;
  }


  public void setReaders(List<TerminalReaderDto> readers) {
    this.readers = readers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TerminalReadersResponse terminalReadersResponse = (TerminalReadersResponse) o;
    return Objects.equals(this.total, terminalReadersResponse.total) &&
        Objects.equals(this.readers, terminalReadersResponse.readers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, readers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TerminalReadersResponse {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    readers: ").append(toIndentedString(readers)).append("\n");
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

