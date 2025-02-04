

# InvoiceReq

インボイスリクエスト

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | インバイス件名 |  [optional] |
|**memo** | **String** | インバイスメモ |  [optional] |
|**customerId** | **String** | カスタマID |  |
|**amount** | **Integer** | 支払い金額 |  |
|**currency** | **String** | 通貨コード (ISO_4217) |  [optional] |
|**taxType** | **TaxType** |  |  [optional] |
|**taxCalcType** | **TaxCalcType** |  |  [optional] |
|**invoiceTime** | **Long** | 請求日のUTCタイムスタンプ |  [optional] |
|**expiryTime** | **Long** | 支払い請求有効時間のUTCタイムスタンプ |  [optional] |
|**fields** | **List&lt;String&gt;** | インボイスフィールドリスト |  [optional] |
|**items** | [**List&lt;InvoiceItem&gt;**](InvoiceItem.md) |  |  [optional] |
|**remark** | **String** | 追加説明 |  [optional] |
|**metadata** | **Map&lt;String, String&gt;** | メタデータ |  [optional] |



