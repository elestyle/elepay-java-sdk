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
import io.elepay.client.charge.pojo.CustomerStatusType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * カスタマオブジェクト
 */
@ApiModel(description = "カスタマオブジェクト")
@JsonPropertyOrder({
  CustomerDto.JSON_PROPERTY_ID,
  CustomerDto.JSON_PROPERTY_OBJECT,
  CustomerDto.JSON_PROPERTY_LIVE_MODE,
  CustomerDto.JSON_PROPERTY_DEFAULT_SOURCE,
  CustomerDto.JSON_PROPERTY_NAME,
  CustomerDto.JSON_PROPERTY_DESCRIPTION,
  CustomerDto.JSON_PROPERTY_EMAIL,
  CustomerDto.JSON_PROPERTY_PHONE,
  CustomerDto.JSON_PROPERTY_REMARK,
  CustomerDto.JSON_PROPERTY_OPERATOR,
  CustomerDto.JSON_PROPERTY_STATUS,
  CustomerDto.JSON_PROPERTY_METADATA,
  CustomerDto.JSON_PROPERTY_UPDATE_TIME
})

public class CustomerDto {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_OBJECT = "object";
  private String _object = "customer";

  public static final String JSON_PROPERTY_LIVE_MODE = "liveMode";
  private Boolean liveMode;

  public static final String JSON_PROPERTY_DEFAULT_SOURCE = "defaultSource";
  private String defaultSource;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_EMAIL = "email";
  private String email;

  public static final String JSON_PROPERTY_PHONE = "phone";
  private String phone;

  public static final String JSON_PROPERTY_REMARK = "remark";
  private String remark;

  public static final String JSON_PROPERTY_OPERATOR = "operator";
  private String operator;

  public static final String JSON_PROPERTY_STATUS = "status";
  private CustomerStatusType status;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private Map<String, String> metadata = null;

  public static final String JSON_PROPERTY_UPDATE_TIME = "updateTime";
  private Long updateTime;


  public CustomerDto id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Customer ID
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Customer ID")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public CustomerDto _object(String _object) {
    
    this._object = _object;
    return this;
  }

   /**
   * 対象種類の表記
   * @return _object
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "対象種類の表記")
  @JsonProperty(JSON_PROPERTY_OBJECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getObject() {
    return _object;
  }


  public void setObject(String _object) {
    this._object = _object;
  }


  public CustomerDto liveMode(Boolean liveMode) {
    
    this.liveMode = liveMode;
    return this;
  }

   /**
   * 本番モードかどうか - false テストモード - true 本番モード 
   * @return liveMode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "本番モードかどうか - false テストモード - true 本番モード ")
  @JsonProperty(JSON_PROPERTY_LIVE_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getLiveMode() {
    return liveMode;
  }


  public void setLiveMode(Boolean liveMode) {
    this.liveMode = liveMode;
  }


  public CustomerDto defaultSource(String defaultSource) {
    
    this.defaultSource = defaultSource;
    return this;
  }

   /**
   * デフォルトカスタマソースID
   * @return defaultSource
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "デフォルトカスタマソースID")
  @JsonProperty(JSON_PROPERTY_DEFAULT_SOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDefaultSource() {
    return defaultSource;
  }


  public void setDefaultSource(String defaultSource) {
    this.defaultSource = defaultSource;
  }


  public CustomerDto name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * 名前
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "名前")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public CustomerDto description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * カスタマに関する説明
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "カスタマに関する説明")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public CustomerDto email(String email) {
    
    this.email = email;
    return this;
  }

   /**
   * メールアドレス
   * @return email
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "メールアドレス")
  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public CustomerDto phone(String phone) {
    
    this.phone = phone;
    return this;
  }

   /**
   * 電話番号
   * @return phone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "電話番号")
  @JsonProperty(JSON_PROPERTY_PHONE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPhone() {
    return phone;
  }


  public void setPhone(String phone) {
    this.phone = phone;
  }


  public CustomerDto remark(String remark) {
    
    this.remark = remark;
    return this;
  }

   /**
   * 備考
   * @return remark
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "備考")
  @JsonProperty(JSON_PROPERTY_REMARK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRemark() {
    return remark;
  }


  public void setRemark(String remark) {
    this.remark = remark;
  }


  public CustomerDto operator(String operator) {
    
    this.operator = operator;
    return this;
  }

   /**
   * 操作者
   * @return operator
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "操作者")
  @JsonProperty(JSON_PROPERTY_OPERATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getOperator() {
    return operator;
  }


  public void setOperator(String operator) {
    this.operator = operator;
  }


  public CustomerDto status(CustomerStatusType status) {
    
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CustomerStatusType getStatus() {
    return status;
  }


  public void setStatus(CustomerStatusType status) {
    this.status = status;
  }


  public CustomerDto metadata(Map<String, String> metadata) {
    
    this.metadata = metadata;
    return this;
  }

  public CustomerDto putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

   /**
   * メタデータ
   * @return metadata
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "メタデータ")
  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, String> getMetadata() {
    return metadata;
  }


  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }


  public CustomerDto updateTime(Long updateTime) {
    
    this.updateTime = updateTime;
    return this;
  }

   /**
   * update time
   * @return updateTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "update time")
  @JsonProperty(JSON_PROPERTY_UPDATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getUpdateTime() {
    return updateTime;
  }


  public void setUpdateTime(Long updateTime) {
    this.updateTime = updateTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDto customerDto = (CustomerDto) o;
    return Objects.equals(this.id, customerDto.id) &&
        Objects.equals(this._object, customerDto._object) &&
        Objects.equals(this.liveMode, customerDto.liveMode) &&
        Objects.equals(this.defaultSource, customerDto.defaultSource) &&
        Objects.equals(this.name, customerDto.name) &&
        Objects.equals(this.description, customerDto.description) &&
        Objects.equals(this.email, customerDto.email) &&
        Objects.equals(this.phone, customerDto.phone) &&
        Objects.equals(this.remark, customerDto.remark) &&
        Objects.equals(this.operator, customerDto.operator) &&
        Objects.equals(this.status, customerDto.status) &&
        Objects.equals(this.metadata, customerDto.metadata) &&
        Objects.equals(this.updateTime, customerDto.updateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, _object, liveMode, defaultSource, name, description, email, phone, remark, operator, status, metadata, updateTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
    sb.append("    liveMode: ").append(toIndentedString(liveMode)).append("\n");
    sb.append("    defaultSource: ").append(toIndentedString(defaultSource)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    remark: ").append(toIndentedString(remark)).append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
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

