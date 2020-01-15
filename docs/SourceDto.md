

# SourceDto

カスタマソースオブジェクト
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Source ID |  [optional]
**_object** | **String** | 対象種類の表記 |  [optional]
**liveMode** | **Boolean** | 本番モードかどうか - false テストモード - true 本番モード  |  [optional]
**paymentMethod** | [**PaymentMethodType**](PaymentMethodType.md) |  |  [optional]
**resource** | [**ResourceType**](ResourceType.md) |  |  [optional]
**description** | **String** | カスタマソースに関する説明 |  [optional]
**extra** | **Map&lt;String, String&gt;** | カスタマソースエキストラデータ |  [optional]
**info** | **Map&lt;String, String&gt;** | カスタマソース補助情報 |  [optional]
**metadata** | **Map&lt;String, String&gt;** | 支払いメタデータ |  [optional]
**credential** | **String** | Client SDK の認証情報 |  [optional]
**status** | [**SourceStatusType**](SourceStatusType.md) |  |  [optional]



