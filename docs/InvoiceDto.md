

# InvoiceDto

インボイスオブジェクト

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Invoice ID |  [optional] |
|**_object** | **String** | 対象種類の表記 |  [optional] |
|**liveMode** | **Boolean** | 本番モードかどうか - false テストモード - true 本番モード  |  [optional] |
|**customer** | [**CustomerDto**](CustomerDto.md) |  |  [optional] |
|**invoiceNo** | **String** | Invoice Number |  [optional] |
|**name** | **String** | インバイス件名 |  [optional] |
|**memo** | **String** | インバイスメモ |  [optional] |
|**amount** | **Integer** | 支払い金額 |  [optional] |
|**currency** | **String** | 通貨コード (ISO_4217) |  [optional] |
|**status** | **InvoiceStatusType** |  |  [optional] |
|**operator** | **String** | 操作者 |  [optional] |
|**invoiceTime** | **Long** | 請求日のUTCタイムスタンプ |  [optional] |
|**sendTime** | **Long** | 送信時間のUTCタイムスタンプ |  [optional] |
|**paidTime** | **Long** | 支払い時間のUTCタイムスタンプ |  [optional] |
|**expiryTime** | **Long** | 支払い請求有効時間のUTCタイムスタンプ |  [optional] |
|**createTime** | **Long** | 作成UTCタイムスタンプ |  [optional] |
|**fields** | **List&lt;String&gt;** | インボイスフィールドリスト |  [optional] |
|**items** | [**List&lt;InvoiceItem&gt;**](InvoiceItem.md) | インボイスアイテムリスト |  [optional] |
|**remark** | **String** | 追加説明 |  [optional] |
|**metadata** | **Map&lt;String, String&gt;** | メタデータ |  [optional] |



