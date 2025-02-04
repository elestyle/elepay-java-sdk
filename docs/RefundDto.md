

# RefundDto

返金オブジェクト

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Refund ID |  [optional] |
|**_object** | **String** | 対象種類の表記 |  [optional] |
|**chargeId** | **String** | Charge ID |  [optional] |
|**liveMode** | **Boolean** | 本番モードかどうか - false テストモード - true 本番モード  |  [optional] |
|**amount** | **Integer** | 返金金額。全額返金、及び amount を指定することで金額の部分返金を行うことができます。 |  [optional] |
|**currency** | **String** | 通貨コード (ISO_4217) |  [optional] |
|**metadata** | **Map&lt;String, String&gt;** | 返金メタデータ |  [optional] |
|**reason** | **String** | 返金理由 |  [optional] |
|**status** | **RefundStatusType** |  |  [optional] |
|**refundedTime** | **Long** | 返金を行う時間のUTCタイムスタンプ。 |  [optional] |
|**createTime** | **Long** | 返金新規時間のUTCタイムスタンプ。 |  [optional] |



