

# CardInfo

カード情報やウォレット情報

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**brand** | **String** | - unknown - visa - mastercard - amex - jcb - diners - unionpay - discover - felica - seven_eleven - lawson - familymart - ministop - seicomart  |  [optional] |
|**last4** | **String** | カード番号の下四桁 |  [optional] |
|**expMonth** | **Integer** | 有効期限月 |  [optional] |
|**expYear** | **Integer** | 有効期限年 |  [optional] |
|**name** | **String** | カード保有者名 |  [optional] |
|**wallet** | **String** | ウォレット情報 |  [optional] |
|**walletApp** | **String** | ウォレットアプリ情報(paymentMethodはalipayplusやsmartcodeの場合は、実際利用しているアプリ名) |  [optional] |
|**repaymentType** | **String** | リペイメントタイプ - 1 一括払い - revolving リボ払い - bonus_one_time ボーナス一括払い - 2 分割2回払い - 3 分割3回払い  |  [optional] |
|**approvalCode** | **String** | 承認コード |  [optional] |
|**threeDSecure** | **Boolean** | 3Dセキュア有無 |  [optional] |
|**threeDSecureVersion** | **String** | 3Dセキュアバージョン |  [optional] |
|**threeDSecureDetail** | **String** | 3Dセキュア詳細情報 |  [optional] |
|**konbiniScanTime** | **Long** | コンビニがラストスキャンする日時 |  [optional] |
|**konbiniType** | **String** | 実際支払い時のコンビニタイプ - unknown - seven_eleven - lawson - familymart - ministop - seicomart  |  [optional] |
|**receivedAmount** | **Integer** | コンビニ、または銀行から実際入金の金額 |  [optional] |
|**receivedTime** | **Long** | コンビニ、または銀行に実際入金の日時、この数値が年月日のみ（零時）の可能性もある |  [optional] |
|**bankUserCode** | **String** | 銀行、振り込んだユーザーのコード |  [optional] |
|**bankUserName** | **String** | 銀行、振り込んだユーザーの名義 |  [optional] |
|**bankName** | **String** | 振り込められた銀行名 |  [optional] |
|**bankBranchName** | **String** | 振り込められた銀行支店名 |  [optional] |
|**bankAccountNo** | **String** | 振り込められた銀行番号 |  [optional] |
|**billingNo** | **String** | 請求番号（決済ステーション用） |  [optional] |



