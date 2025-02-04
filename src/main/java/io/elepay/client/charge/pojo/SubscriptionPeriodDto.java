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
import io.elepay.client.charge.pojo.ChargeDto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringJoiner;

/**
 * 定期課金周期情報オブジェクト
 */
@JsonPropertyOrder({
  SubscriptionPeriodDto.JSON_PROPERTY_ID,
  SubscriptionPeriodDto.JSON_PROPERTY_OBJECT,
  SubscriptionPeriodDto.JSON_PROPERTY_START_TIME,
  SubscriptionPeriodDto.JSON_PROPERTY_END_TIME,
  SubscriptionPeriodDto.JSON_PROPERTY_CHARGE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SubscriptionPeriodDto {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_OBJECT = "object";
  private String _object = "subscription_period";

  public static final String JSON_PROPERTY_START_TIME = "startTime";
  private Long startTime;

  public static final String JSON_PROPERTY_END_TIME = "endTime";
  private Long endTime;

  public static final String JSON_PROPERTY_CHARGE = "charge";
  private ChargeDto charge;

  public SubscriptionPeriodDto() {
  }

  public SubscriptionPeriodDto id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Subscription Period ID
   * @return id
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }


  public SubscriptionPeriodDto _object(String _object) {
    
    this._object = _object;
    return this;
  }

   /**
   * 対象種類の表記
   * @return _object
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_OBJECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getObject() {
    return _object;
  }


  @JsonProperty(JSON_PROPERTY_OBJECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setObject(String _object) {
    this._object = _object;
  }


  public SubscriptionPeriodDto startTime(Long startTime) {
    
    this.startTime = startTime;
    return this;
  }

   /**
   * 周期開始UTCタイムスタンプ
   * @return startTime
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_START_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getStartTime() {
    return startTime;
  }


  @JsonProperty(JSON_PROPERTY_START_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStartTime(Long startTime) {
    this.startTime = startTime;
  }


  public SubscriptionPeriodDto endTime(Long endTime) {
    
    this.endTime = endTime;
    return this;
  }

   /**
   * 周期終了UTCタイムスタンプ
   * @return endTime
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_END_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getEndTime() {
    return endTime;
  }


  @JsonProperty(JSON_PROPERTY_END_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEndTime(Long endTime) {
    this.endTime = endTime;
  }


  public SubscriptionPeriodDto charge(ChargeDto charge) {
    
    this.charge = charge;
    return this;
  }

   /**
   * Get charge
   * @return charge
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CHARGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ChargeDto getCharge() {
    return charge;
  }


  @JsonProperty(JSON_PROPERTY_CHARGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCharge(ChargeDto charge) {
    this.charge = charge;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriptionPeriodDto subscriptionPeriodDto = (SubscriptionPeriodDto) o;
    return Objects.equals(this.id, subscriptionPeriodDto.id) &&
        Objects.equals(this._object, subscriptionPeriodDto._object) &&
        Objects.equals(this.startTime, subscriptionPeriodDto.startTime) &&
        Objects.equals(this.endTime, subscriptionPeriodDto.endTime) &&
        Objects.equals(this.charge, subscriptionPeriodDto.charge);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, _object, startTime, endTime, charge);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionPeriodDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    charge: ").append(toIndentedString(charge)).append("\n");
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

    // add `id` to the URL query string
    if (getId() != null) {
      try {
        joiner.add(String.format("%sid%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getId()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `object` to the URL query string
    if (getObject() != null) {
      try {
        joiner.add(String.format("%sobject%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getObject()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `startTime` to the URL query string
    if (getStartTime() != null) {
      try {
        joiner.add(String.format("%sstartTime%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getStartTime()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `endTime` to the URL query string
    if (getEndTime() != null) {
      try {
        joiner.add(String.format("%sendTime%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getEndTime()), "UTF-8").replaceAll("\\+", "%20")));
      } catch (UnsupportedEncodingException e) {
        // Should never happen, UTF-8 is always supported
        throw new RuntimeException(e);
      }
    }

    // add `charge` to the URL query string
    if (getCharge() != null) {
      joiner.add(getCharge().toUrlQueryString(prefix + "charge" + suffix));
    }

    return joiner.toString();
  }

}

