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
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 決済リソース - web WEBブラウザ - ios iOS Nativeアプリ - android Android Nativeアプリ - liff Line LIFFアプリ - mini WeChatミニプログラム - cpm CPM決済、利用者提示型QRコード - mpm MPM決済、店舗側提示型QRコード - reader カードリーダー決済(リーダー設備が必要) - posapp POSアプリ決済(POSアプリが連携必要) 
 */
public enum ResourceType {
  
  WEB("web"),
  
  IOS("ios"),
  
  ANDROID("android"),
  
  LIFF("liff"),
  
  MINI("mini"),
  
  CPM("cpm"),
  
  MPM("mpm"),
  
  READER("reader"),
  
  POSAPP("posapp");

  private String value;

  ResourceType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ResourceType fromValue(String value) {
    for (ResourceType b : ResourceType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

