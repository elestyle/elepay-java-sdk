

# CodeReq

EasyQRコードリクエスト
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **Integer** | 金額 | 
**currency** | **String** | 通貨コード (ISO_4217) |  [optional]
**orderNo** | **String** | お客様側のシステムオーダーNo（例：注文番号、決済IDなど） 最大桁数は50桁です。  | 
**description** | **String** | 支払いオブジェクトの「決済に関する説明」 |  [optional]
**extra** | **Map&lt;String, String&gt;** | 決済に関する追加情報がある場合に利用します。具体的設定情報は「開発ガイド-&gt;決済Extra情報設定」を参照してください。 決済オブジェクトを作成する時、こちら設定したextra情報を優先利用します。  |  [optional]
**metadata** | **Map&lt;String, String&gt;** | 支払いオブジェクトの「メタデータ」 |  [optional]
**expiryDuration** | **Integer** | EasyQRコード有効期限(分) 最小:3分、最大:30分、デフォルト:10分  |  [optional]
**frontUrl** | **String** | EasyCheckout決済が完了したあとの、戻り先ページのURL |  [optional]
**items** | [**List&lt;CodeItem&gt;**](CodeItem.md) | 商品に関する情報 |  [optional]



