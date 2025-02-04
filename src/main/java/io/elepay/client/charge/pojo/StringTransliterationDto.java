/*
 * elepay API リファレンス
 * elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。
 *
 * The version of the OpenAPI document: 1.2.5
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
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * 名前内容オブジェクト
 */
@JsonPropertyOrder({
  StringTransliterationDto.JSON_PROPERTY_KANJI,
  StringTransliterationDto.JSON_PROPERTY_KANA,
  StringTransliterationDto.JSON_PROPERTY_ROMAJI
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class StringTransliterationDto {
  public static final String JSON_PROPERTY_KANJI = "kanji";
  private String kanji;

  public static final String JSON_PROPERTY_KANA = "kana";
  private String kana;

  public static final String JSON_PROPERTY_ROMAJI = "romaji";
  private String romaji;

  public StringTransliterationDto() {
  }

  public StringTransliterationDto kanji(String kanji) {
    
    this.kanji = kanji;
    return this;
  }

   /**
   * 漢字
   * @return kanji
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_KANJI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getKanji() {
    return kanji;
  }


  @JsonProperty(JSON_PROPERTY_KANJI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setKanji(String kanji) {
    this.kanji = kanji;
  }


  public StringTransliterationDto kana(String kana) {
    
    this.kana = kana;
    return this;
  }

   /**
   * カナ
   * @return kana
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_KANA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getKana() {
    return kana;
  }


  @JsonProperty(JSON_PROPERTY_KANA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setKana(String kana) {
    this.kana = kana;
  }


  public StringTransliterationDto romaji(String romaji) {
    
    this.romaji = romaji;
    return this;
  }

   /**
   * ローマ字
   * @return romaji
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ROMAJI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRomaji() {
    return romaji;
  }


  @JsonProperty(JSON_PROPERTY_ROMAJI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRomaji(String romaji) {
    this.romaji = romaji;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StringTransliterationDto stringTransliterationDto = (StringTransliterationDto) o;
    return Objects.equals(this.kanji, stringTransliterationDto.kanji) &&
        Objects.equals(this.kana, stringTransliterationDto.kana) &&
        Objects.equals(this.romaji, stringTransliterationDto.romaji);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kanji, kana, romaji);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StringTransliterationDto {\n");
    sb.append("    kanji: ").append(toIndentedString(kanji)).append("\n");
    sb.append("    kana: ").append(toIndentedString(kana)).append("\n");
    sb.append("    romaji: ").append(toIndentedString(romaji)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Convert the instance into URL query string.
   *
   * @return URL query string
   */
  public String toUrlQueryString() {
    return toUrlQueryString(null);
  }

  /**
   * Convert the instance into URL query string.
   *
   * @param prefix prefix of the query string
   * @return URL query string
   */
  public String toUrlQueryString(String prefix) {
    String suffix = "";
    String containerSuffix = "";
    String containerPrefix = "";
    if (prefix == null) {
      // style=form, explode=true, e.g. /pet?name=cat&type=manx
      prefix = "";
    } else {
      // deepObject style e.g. /pet?id[name]=cat&id[type]=manx
      prefix = prefix + "[";
      suffix = "]";
      containerSuffix = "]";
      containerPrefix = "[";
    }

    StringJoiner joiner = new StringJoiner("&");

    // add `kanji` to the URL query string
    if (getKanji() != null) {
      try {
        joiner.add(String.format("%skanji%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getKanji()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `kana` to the URL query string
    if (getKana() != null) {
      try {
        joiner.add(String.format("%skana%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getKana()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `romaji` to the URL query string
    if (getRomaji() != null) {
      try {
        joiner.add(String.format("%sromaji%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getRomaji()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    return joiner.toString();
  }

}

