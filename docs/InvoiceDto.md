

# InvoiceDto

インボイスオブジェクト
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Invoice ID |  [optional]
**_object** | **String** | 対象種類の表記 |  [optional]
**liveMode** | **Boolean** | 本番モードかどうか - false テストモード - true 本番モード  |  [optional]
**customer** | [**CustomerDto**](CustomerDto.md) |  |  [optional]
**invoiceNo** | **String** | Invoice Number |  [optional]
**name** | **String** |  |  [optional]
**memo** | **String** |  |  [optional]
**amount** | **Integer** | payment amount |  [optional]
**currency** | **String** | currency code |  [optional]
**status** | [**InvoiceStatusType**](InvoiceStatusType.md) |  |  [optional]
**operator** | **String** | 操作者 |  [optional]
**sendTime** | **Long** | create time |  [optional]
**paidTime** | **Long** | paid time |  [optional]
**expiryTime** | **Long** | expiry time |  [optional]
**createTime** | **Long** | create time |  [optional]
**items** | [**List&lt;InvoiceItem&gt;**](InvoiceItem.md) |  |  [optional]
**remark** | **String** | 備考 |  [optional]
**metadata** | **Map&lt;String, String&gt;** | メタデータ |  [optional]



