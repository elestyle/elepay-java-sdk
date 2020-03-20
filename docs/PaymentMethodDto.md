

# PaymentMethodDto

決済方法詳細情報
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paymentMethod** | [**PaymentMethodType**](PaymentMethodType.md) |  |  [optional]
**resources** | [**List&lt;ResourceType&gt;**](ResourceType.md) |  |  [optional]
**brand** | **List&lt;String&gt;** | クレジットカードの場合、利用できるクレジットカードブランド |  [optional]
**ua** | **String** | 利用できるブラウザのUserAgent |  [optional]
**channelProperties** | **Map&lt;String, Object&gt;** | 決済方法そのた設定 - isSupportPartialRefund: 一部返金 true 利用可能 false 利用不可 - isSupportMultipleRefund: 複数返金 true 複数可能 false 一回のみ  |  [optional]



