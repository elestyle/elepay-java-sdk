

# ChargeReq

支払リクエスト
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **Integer** | 金額 | 
**currency** | **String** | 通貨コード (ISO_4217) |  [optional]
**paymentMethod** | [**PaymentMethodType**](PaymentMethodType.md) |  | 
**resource** | [**ResourceType**](ResourceType.md) |  |  [optional]
**orderNo** | **String** | お客様側のシステムオーダーNo（例：注文番号、決済IDなど） 最大桁数は20桁です。  | 
**description** | **String** | 決済に関する説明 |  [optional]
**extra** | **Map&lt;String, String&gt;** | 決済に関する追加情報がある場合に利用します。具体的設定情報は「開発ガイド-&gt;決済Extra情報設定」を参照してください。 |  [optional]
**metadata** | **Map&lt;String, String&gt;** | メタデータ |  [optional]
**clientIp** | **String** | Client IP アドレス |  [optional]
**customerId** | **String** | カスタマID |  [optional]
**sourceId** | **String** | カスタマソースID |  [optional]



