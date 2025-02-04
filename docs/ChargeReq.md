

# ChargeReq

支払リクエスト

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**amount** | **Integer** | 金額 |  |
|**capture** | **Boolean** | 支払い処理を確定するかどうか falseの場合、承認と支払い額の確保のみ行う。デフォルトはtrue  |  [optional] |
|**currency** | **String** | 通貨コード (ISO_4217) |  [optional] |
|**paymentMethod** | **PaymentMethodType** |  |  |
|**resource** | **ResourceType** |  |  [optional] |
|**orderNo** | **String** | お客様側のシステムオーダーNo（例：注文番号、決済IDなど） 最大桁数は50桁です。  |  |
|**description** | **String** | 決済に関する説明 |  [optional] |
|**extra** | **Map&lt;String, String&gt;** | 決済に関する追加情報がある場合に利用します。具体的設定情報は「開発ガイド-&gt;決済Extra情報設定」を参照してください。 |  [optional] |
|**metadata** | **Map&lt;String, String&gt;** | メタデータ キーバリューの任意データ。 キーは20個まで、バリューは255バイト以内の文字列。 「route」、「__」で始まる文字列は予約キー。  |  [optional] |
|**clientIp** | **String** | Client IP アドレス |  [optional] |
|**customerId** | **String** | カスタマID |  [optional] |
|**sourceId** | **String** | カスタマソースID |  [optional] |
|**locationId** | **String** | ロケーションID |  [optional] |



