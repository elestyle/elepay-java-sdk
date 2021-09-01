

# DisputeDto

TODO
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Dispute ID |  [optional]
**_object** | **String** | 対象種類の表記 |  [optional]
**chargeId** | **String** | Charge ID |  [optional]
**liveMode** | **Boolean** | 本番モードかどうか - false テストモード - true 本番モード  |  [optional]
**amount** | **Integer** | Disputed amount. Usually the amount of the charge,  but can differ (usually because of currency fluctuation or because only part of the order is disputed).  |  [optional]
**currency** | **String** | 通貨コード (ISO_4217) |  [optional]
**metadata** | **Map&lt;String, String&gt;** | 返金メタデータ |  [optional]
**reason** | **String** | TODO |  [optional]
**status** | [**DisputeStatusType**](DisputeStatusType.md) |  |  [optional]
**resolvedTime** | **Long** | TODO |  [optional]
**createTime** | **Long** | 返金新規時間のUTCタイムスタンプ。 |  [optional]



