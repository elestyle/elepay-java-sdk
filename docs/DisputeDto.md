

# DisputeDto

不審請求オブジェクト
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Dispute ID |  [optional]
**_object** | **String** | 対象種類の表記 |  [optional]
**chargeId** | **String** | Charge ID |  [optional]
**liveMode** | **Boolean** | 本番モードかどうか - false テストモード - true 本番モード  |  [optional]
**amount** | **Integer** | 不審請求金額 |  [optional]
**currency** | **String** | 通貨コード (ISO_4217) |  [optional]
**metadata** | **Map&lt;String, String&gt;** | メタデータ |  [optional]
**reason** | **String** | 不審請求理由 |  [optional]
**status** | [**DisputeStatusType**](DisputeStatusType.md) |  |  [optional]
**resolvedTime** | **Long** | 対応時間のUTCタイムスタンプ |  [optional]
**createTime** | **Long** | 発生時間のUTCタイムスタンプ。 |  [optional]



