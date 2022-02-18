

# SubscriptionDto

定期課金オブジェクト
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Subscription ID |  [optional]
**appId** | **String** | App ID |  [optional]
**_object** | **String** | 対象種類の表記 |  [optional]
**liveMode** | **Boolean** | 本番モードかどうか - false テストモード - true 本番モード  |  [optional]
**customerId** | **String** | Customer ID |  [optional]
**customer** | [**CustomerDto**](CustomerDto.md) |  |  [optional]
**planId** | **String** | Plan ID |  [optional]
**plan** | [**PlanDto**](PlanDto.md) |  |  [optional]
**currentSchedule** | [**SubscriptionScheduleDto**](SubscriptionScheduleDto.md) |  |  [optional]
**prorate** | **Boolean** | 日割り課金が有効かどうか |  [optional]
**startTime** | **Long** | 定期課金開始UTCタイムスタンプ |  [optional]
**endTime** | **Long** | 定期課金終了UTCタイムスタンプ |  [optional]
**nextScheduleTime** | **Long** | 次定期課金周期開始UTCタイムスタンプ |  [optional]
**trialStart** | **Long** | トライアル開始UTCタイムスタンプ |  [optional]
**trialEnd** | **Long** | トライアル終了UTCタイムスタンプ |  [optional]
**discount** | [**DiscountDto**](DiscountDto.md) |  |  [optional]
**metadata** | **Map&lt;String, String&gt;** | メタデータ |  [optional]
**status** | [**SubscriptionStatusType**](SubscriptionStatusType.md) |  |  [optional]
**createTime** | **Long** | 作成UTCタイムスタンプ |  [optional]
**updateTime** | **Long** | 更新UTCタイムスタンプ |  [optional]



