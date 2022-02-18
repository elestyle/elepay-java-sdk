

# PlanDto

定期課金プランオブジェクト
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Plan ID |  [optional]
**appId** | **String** | App ID |  [optional]
**_object** | **String** | 対象種類の表記 |  [optional]
**liveMode** | **Boolean** | 本番モードかどうか - false テストモード - true 本番モード  |  [optional]
**name** | **String** | プラン名 |  [optional]
**amount** | **Integer** | プラン金額 |  [optional]
**currency** | **String** | 通貨コード (ISO_4217) |  [optional]
**interval** | [**PlanIntervalType**](PlanIntervalType.md) |  |  [optional]
**trialPeriodDays** | **Integer** | トライアル日数 |  [optional]
**billingDay** | **Integer** | 月次プランの課金日 指定した日が存在しない月の場合、定期課金におけるサイクルは自動的に月末に調整されるため、例えば31を指定した場合は常に月末が課金日となります。  |  [optional]
**metadata** | **Map&lt;String, String&gt;** | メタデータ |  [optional]
**status** | [**PlanStatusType**](PlanStatusType.md) |  |  [optional]
**createTime** | **Long** | 作成UTCタイムスタンプ |  [optional]
**updateTime** | **Long** | 更新UTCタイムスタンプ |  [optional]



