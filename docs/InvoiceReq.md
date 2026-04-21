

# InvoiceReq

インボイスリクエスト

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | インボイス件名 |  [optional] |
|**memo** | **String** | インボイスメモ |  [optional] |
|**customerId** | **String** | カスタマID |  |
|**amount** | **Integer** | 支払い金額 |  |
|**currency** | **String** | 通貨コード (ISO_4217) |  [optional] |
|**taxType** | **TaxType** |  |  [optional] |
|**taxCalcType** | **TaxCalcType** |  |  [optional] |
|**invoiceTime** | **Long** | 請求日（エポックミリ秒） |  [optional] |
|**expiryTime** | **Long** | 支払い請求有効時間（エポックミリ秒） |  [optional] |
|**fields** | **List&lt;String&gt;** | インボイスフィールドリスト |  [optional] |
|**items** | [**List&lt;InvoiceItem&gt;**](InvoiceItem.md) |  |  [optional] |
|**remark** | **String** | 追加説明 |  [optional] |
|**metadata** | **Map&lt;String, String&gt;** | メタデータ |  [optional] |
|**enableAutoCharge** | **Boolean** | 自動支払いを有効にするかどうか。 true 有効、false 無効  |  [optional] |
|**autoChargeTime** | **Long** | 自動支払いの時間（エポックミリ秒） |  [optional] |



