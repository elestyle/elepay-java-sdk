

# CodeDto

EasyQRコードオブジェクト
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | EasyQRコードID |  [optional]
**_object** | **String** | 対象種類の表記 |  [optional]
**liveMode** | **Boolean** | 本番モードかどうか - false テストモード - true 本番モード  |  [optional]
**codeUrl** | **String** | EasyQRコードURL |  [optional]
**amount** | **Integer** | 支払い金額 |  [optional]
**currency** | **String** | 通貨コード (ISO_4217) |  [optional]
**orderNo** | **String** | お客様システム側のオーダーNo、例えば注文番号、決済IDなど |  [optional]
**description** | **String** | 支払いオブジェクトの「決済に関する説明」 |  [optional]
**metadata** | **Map&lt;String, String&gt;** | 支払いオブジェクトの「メタデータ」 |  [optional]
**status** | [**CodeStatusType**](CodeStatusType.md) |  |  [optional]
**charge** | [**ChargeDto**](ChargeDto.md) |  |  [optional]
**frontUrl** | **String** |  |  [optional]
**items** | [**List&lt;CodeItem&gt;**](CodeItem.md) |  |  [optional]
**expired** | **Boolean** | EasyQRコード有効有無 |  [optional]
**expiryTime** | **Long** | EasyQRコード有効期限のUTCタイムスタンプ |  [optional]
**expiryPeriod** | **Long** | EasyQRコード有効期限までの残りミリ秒数 |  [optional]
**createTime** | **Long** | コード新規時間のUTCタイムスタンプ |  [optional]



