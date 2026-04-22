

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
|**name** | **String** | インボイス件名 |  [optional] |
|**memo** | **String** | インボイスメモ |  [optional] |
|**amount** | **Integer** | 支払い金額 |  [optional] |
|**currency** | **String** | 通貨コード (ISO_4217) |  [optional] |
|**status** | **InvoiceStatusType** |  |  [optional] |
|**operator** | **String** | 操作者 |  [optional] |
|**invoiceTime** | **Long** | 請求日（エポックミリ秒） |  [optional] |
|**sendTime** | **Long** | 送信時間（エポックミリ秒） |  [optional] |
|**paidTime** | **Long** | 支払い時間（エポックミリ秒） |  [optional] |
|**expiryTime** | **Long** | 支払い請求有効時間（エポックミリ秒） |  [optional] |
|**createTime** | **Long** | 作成時間（エポックミリ秒） |  [optional] |
|**fields** | **List&lt;String&gt;** | インボイスフィールドリスト |  [optional] |
|**items** | [**List&lt;InvoiceItem&gt;**](InvoiceItem.md) | インボイスアイテムリスト |  [optional] |
|**remark** | **String** | 追加説明 |  [optional] |
|**metadata** | **Map&lt;String, String&gt;** | メタデータ |  [optional] |
|**enableAutoCharge** | **Boolean** | 自動支払いを有効にするかどうか。 true 有効、false 無効  |  [optional] |



