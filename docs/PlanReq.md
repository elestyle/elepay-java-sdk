

# PlanReq

プラン作成リクエスト
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | プラン名 | 
**currency** | **String** | 通貨コード (ISO_4217) |  [optional]
**amount** | **Integer** | プラン金額 | 
**interval** | [**PlanIntervalType**](PlanIntervalType.md) |  | 
**trialPeriodDays** | **Integer** | トライアル日数 |  [optional]
**billingDay** | **Integer** | 月次プランの課金日 指定した日が存在しない月の場合、定期課金におけるサイクルは自動的に月末に調整されるため、例えば31を指定した場合は常に月末が課金日となります。  |  [optional]
**metadata** | **Map&lt;String, String&gt;** | メタデータ |  [optional]



