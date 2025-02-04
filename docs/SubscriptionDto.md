

# SubscriptionDto

定期課金オブジェクト

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Subscription ID |  [optional] |
|**appId** | **String** | App ID |  [optional] |
|**_object** | **String** | 対象種類の表記 |  [optional] |
|**liveMode** | **Boolean** | 本番モードかどうか - false テストモード - true 本番モード  |  [optional] |
|**customerId** | **String** | Customer ID |  [optional] |
|**customer** | [**CustomerDto**](CustomerDto.md) |  |  [optional] |
|**nextChargeTime** | **Long** | 次定期課金周期開始UTCタイムスタンプ |  [optional] |
|**isCharging** | **Boolean** | 処理中かどうか |  [optional] |
|**chargedPeriods** | **Integer** | 成功した定期課金回数 |  [optional] |
|**metadata** | **Map&lt;String, String&gt;** | メタデータ |  [optional] |
|**status** | **SubscriptionStatusType** |  |  [optional] |
|**createTime** | **Long** | 作成UTCタイムスタンプ |  [optional] |
|**updateTime** | **Long** | 更新UTCタイムスタンプ |  [optional] |



