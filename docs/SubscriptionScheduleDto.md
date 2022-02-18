

# SubscriptionScheduleDto

定期課金周期情報オブジェクト
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Subscription Schedule ID |  [optional]
**_object** | **String** | 対象種類の表記 |  [optional]
**amount** | **Integer** | 課金金額 |  [optional]
**currency** | **String** | 通貨コード (ISO_4217) |  [optional]
**periodStart** | **Long** | 周期開始UTCタイムスタンプ |  [optional]
**periodEnd** | **Long** | 周期終了UTCタイムスタンプ |  [optional]
**trialing** | **Boolean** | トライアル期間フラグ |  [optional]
**status** | [**SubscriptionScheduleStatusType**](SubscriptionScheduleStatusType.md) |  |  [optional]



