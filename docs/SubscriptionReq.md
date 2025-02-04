

# SubscriptionReq

定期課金作成リクエスト

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | 定期課金名 |  [optional] |
|**customerId** | **String** | カスタマID |  |
|**currency** | **String** | 通貨コード (ISO_4217) |  [optional] |
|**amount** | **Integer** | 每期課金金額 |  [optional] |
|**interval** | **SubscriptionIntervalType** |  |  [optional] |
|**intervalSpan** | **Integer** | 定期課金周期間隔（何周期単位ごとに課金されます） |  [optional] |
|**initialAmount** | **Integer** | 初回支払い前の固定支払額 |  [optional] |
|**firstChargeTime** | **Long** | 初回支払いUTCタイムスタンプ |  [optional] |
|**metadata** | **Map&lt;String, String&gt;** | メタデータ |  [optional] |



