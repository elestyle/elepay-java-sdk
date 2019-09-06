

# ChargeDto

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Charge ID |  [optional]
**_object** | **String** | 対象種類の表記 |  [optional]
**liveMode** | **Boolean** | 本番モードかどうか - false テストモード - true 本番モード  |  [optional]
**amount** | **Integer** | 支払い金額 |  [optional]
**currency** | **String** | 通貨コード (ISO_4217) |  [optional]
**paymentMethod** | [**PaymentMethodType**](PaymentMethodType.md) |  |  [optional]
**orderNo** | **String** | お客様システム側のオーダーNo、例えば注文番号、決済IDなど |  [optional]
**description** | **String** | 支払い説明文 |  [optional]
**extra** | **Map&lt;String, Object&gt;** | 支払いエキストラデータ |  [optional]
**metadata** | **Map&lt;String, Object&gt;** | 支払いメタデータ |  [optional]
**clientIp** | **String** | Client IP アドレス |  [optional]
**paid** | **Boolean** | 支払い済みフラグ |  [optional]
**refunded** | **Boolean** | 返金済みフラグ |  [optional]
**refunds** | [**RefundExtDto**](RefundExtDto.md) |  |  [optional]
**status** | **String** | 支払い状態 |  [optional]
**credential** | **String** | Client SDK の認証情報 |  [optional]
**paidTime** | **Long** | 支払い時間のUTCタイムスタンプ |  [optional]
**refundTime** | **Long** | 返金時間のUTCタイムスタンプ |  [optional]
**expiryTime** | **Long** | 支払い請求有効時間のUTCタイムスタンプ |  [optional]
**settleTime** | **Long** | 支払い締め時間のUTCタイムスタンプ |  [optional]
**createTime** | **Long** | 支払い新規時間のUTCタイムスタンプ |  [optional]



