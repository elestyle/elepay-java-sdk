

# SubscriptionReq

定期課金作成リクエスト
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**customerId** | **String** | Customer ID | 
**planId** | **String** | Plan ID | 
**discount** | [**DiscountDto**](DiscountDto.md) |  |  [optional]
**trialPeriodDays** | **Integer** | トライアル日数 |  [optional]
**prorate** | **Boolean** | 日割り課金設定、デフォルトはfalse billingDay設定した場合のみ有効。  |  [optional]
**metadata** | **Map&lt;String, String&gt;** | メタデータ |  [optional]



