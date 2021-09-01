

# ChargeDto

支払いオブジェクト
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Charge ID |  [optional]
**appId** | **String** | App ID |  [optional]
**_object** | **String** | 対象種類の表記 |  [optional]
**liveMode** | **Boolean** | 本番モードかどうか - false テストモード - true 本番モード  |  [optional]
**amount** | **Integer** | 支払い金額 |  [optional]
**currency** | **String** | 通貨コード (ISO_4217) |  [optional]
**paymentMethod** | [**PaymentMethodType**](PaymentMethodType.md) |  |  [optional]
**resource** | [**ResourceType**](ResourceType.md) |  |  [optional]
**orderNo** | **String** | お客様システム側のオーダーNo、例えば注文番号、決済IDなど |  [optional]
**description** | **String** | 支払い説明文 |  [optional]
**extra** | **Map&lt;String, String&gt;** | 支払いエキストラデータ |  [optional]
**metadata** | **Map&lt;String, String&gt;** | 支払いメタデータ |  [optional]
**cardInfo** | [**CardInfo**](CardInfo.md) |  |  [optional]
**voucherNo** | **String** | プロバイダー決済伝票番号 |  [optional]
**clientIp** | **String** | Client IP アドレス |  [optional]
**paid** | **Boolean** | 支払い済みフラグ |  [optional]
**refunded** | **Boolean** | 返金済みフラグ |  [optional]
**disputed** | **Boolean** | TODO |  [optional]
**refunds** | [**RefundsDto**](RefundsDto.md) |  |  [optional]
**status** | [**ChargeStatusType**](ChargeStatusType.md) |  |  [optional]
**codeContent** | **String** | 店舗側提示型QRコード(リソースはmpm場合のみ) |  [optional]
**credential** | **String** | Client SDK の認証情報 |  [optional]
**paidTime** | **Long** | 支払い時間のUTCタイムスタンプ |  [optional]
**refundTime** | **Long** | 返金時間のUTCタイムスタンプ |  [optional]
**expiryTime** | **Long** | 支払い請求有効時間のUTCタイムスタンプ |  [optional]
**settleTime** | **Long** | 支払い締め時間のUTCタイムスタンプ |  [optional]
**createTime** | **Long** | 支払い新規時間のUTCタイムスタンプ |  [optional]



