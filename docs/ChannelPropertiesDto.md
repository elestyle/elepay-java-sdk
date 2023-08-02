

# ChannelPropertiesDto

決済方法関する情報
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**isSupportRefund** | **Boolean** | 返金 true 利用可能 false 利用不可 |  [optional]
**isSupportPartialRefund** | **Boolean** | 一部返金 true 利用可能 false 利用不可 |  [optional]
**isSupportMultipleRefund** | **Boolean** | 複数回返金 true 利用可能 false 一回のみ |  [optional]
**isSupportSource** | **Boolean** | カスタマ機能とソース true 利用可能 false 利用不可 |  [optional]
**isSupportMultipleSource** | **Boolean** | 複数ソース true バインディング可能 false バインディング不可 |  [optional]
**maxAmount** | **Integer** | 最大可能金額 |  [optional]
**minAmount** | **Integer** | 最小可能金額 |  [optional]
**resourceWebEnv** | [**ResourceWebEnvType**](ResourceWebEnvType.md) |  |  [optional]



