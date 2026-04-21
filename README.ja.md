# elepay Java SDK

[English](README.md) | **日本語** | [简体中文](README.zh.md)

[elepay](https://elepay.io) 決済プラットフォーム公式 Java SDK。Charges・Refunds・Customers・Subscriptions・Invoices・Terminal などを、型付きで十分にドキュメント化されたクライアントから利用できます。

- **最新バージョン**: `1.3.0`
- **Base URL**: `https://api.elepay.io`
- **Developer portal**: https://developer.elepay.io

## 機能

- **Charges と Refunds** — `create` / `capture` / `revoke` / `refund`
- **EasyQR codes** — 動的 QR による支払いフロー
- **Customers と Sources** — 顧客ごとの支払い手段の保存
- **Invoices** — `draft` / `submit` / `send` / `cancel`
- **Subscriptions** — 期間ごとの継続課金
- **Locations** — ロケーションごとの決済とレポート
- **Terminal** — 物理カードリーダーの管理
- **Disputes** — チャージバック情報の取得
- **Payment methods** — 利用可能な決済手段の動的取得

## 必要環境

- Java **1.8 以上**
- Maven **3.6 以上** もしくは Gradle **7 以上**

## インストール

### Maven

```xml
<dependency>
  <groupId>io.elepay</groupId>
  <artifactId>elepay-java-sdk</artifactId>
  <version>1.3.0</version>
</dependency>
```

### Gradle

```groovy
implementation 'io.elepay:elepay-java-sdk:1.3.0'
```

### ソースからビルド

```shell
git clone https://github.com/elestyle/elepay-java-sdk.git
cd elepay-java-sdk
mvn clean install
```

ローカル Maven リポジトリにインストールされます。スタンドアロン JAR が必要な場合は `mvn clean package` を実行し、`target/elepay-java-sdk-1.3.0.jar` と `target/lib/` 配下の依存 JAR を取得してください。

## クイックスタート

```java
import io.elepay.client.charge.ApiClient;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.Configuration;
import io.elepay.client.charge.api.ChargeApi;
import io.elepay.client.charge.auth.HttpBearerAuth;
import io.elepay.client.charge.pojo.ChargeDto;
import io.elepay.client.charge.pojo.ChargeReq;
import io.elepay.client.charge.pojo.PaymentMethodType;

public class Example {
    public static void main(String[] args) {
        ApiClient client = Configuration.getDefaultApiClient();
        HttpBearerAuth bearer = (HttpBearerAuth) client.getAuthentication("bearerAuth");
        bearer.setBearerToken(System.getenv("ELEPAY_SECRET_KEY"));

        ChargeApi api = new ChargeApi(client);
        ChargeReq req = new ChargeReq()
            .amount(1000)
            .currency("JPY")
            .paymentMethod(PaymentMethodType.ALIPAY);

        try {
            ChargeDto charge = api.createCharge(req);
            System.out.println("Created charge: " + charge.getId());
        } catch (ApiException e) {
            System.err.printf("HTTP %d — %s%n", e.getCode(), e.getResponseBody());
        }
    }
}
```

## 認証

API は 2 つの認証方式をサポートしており、いずれか一方を使用します。

**Bearer token（推奨）**

```java
HttpBearerAuth bearer = (HttpBearerAuth) client.getAuthentication("bearerAuth");
bearer.setBearerToken("sk_live_xxxxxxxx");
```

**HTTP Basic**

```java
HttpBasicAuth basic = (HttpBasicAuth) client.getAuthentication("basicAuth");
basic.setUsername("sk_live_xxxxxxxx"); // password は空のまま
```

> シークレットキーは絶対にコミットしないでください。環境変数またはシークレットマネージャから読み込む運用を推奨します。

## API 一覧

各エンドポイントのリクエスト／レスポンス仕様は [`docs/`](docs/) 配下にあります。

| API | リソース |
|---|---|
| [`ChargeApi`](docs/ChargeApi.md) | `/charges` — `create` / `capture` / `revoke` / `list` |
| [`RefundApi`](docs/RefundApi.md) | `/charges/{id}/refunds` |
| [`CustomerApi`](docs/CustomerApi.md) | `/customers`, `/sources` |
| [`InvoiceApi`](docs/InvoiceApi.md) | `/invoices` — `draft` → `submit` → `send` |
| [`SubscriptionApi`](docs/SubscriptionApi.md) | `/subscriptions` — 継続課金 |
| [`CodeApi`](docs/CodeApi.md) | `/codes` — EasyQR |
| [`CodeSettingApi`](docs/CodeSettingApi.md) | `/code-setting/payment-methods` |
| [`LocationApi`](docs/LocationApi.md) | `/locations` |
| [`TerminalApi`](docs/TerminalApi.md) | `/terminal/readers`, `/terminal/locations` |
| [`PaymentMethodApi`](docs/PaymentMethodApi.md) | `/payment-methods` |
| [`DisputeApi`](docs/DisputeApi.md) | `/disputes` |

データモデルのドキュメントも [`docs/*.md`](docs/) 配下にあります。

## エラーハンドリング

2xx 以外の応答では `ApiException` が送出されます。主なアクセッサ:

```java
try {
    api.createCharge(req);
} catch (ApiException e) {
    e.getCode();             // HTTP ステータスコード
    e.getResponseBody();     // レスポンス本文（通常 elepay エラーコードを含む JSON）
    e.getResponseHeaders();  // レスポンスヘッダ
}
```

## Webhooks

受信した webhook は、本文を信頼する前に `Webhook.verifyHeader` で署名を検証してください。

```java
import io.elepay.client.charge.webhook.Webhook;
import io.elepay.client.charge.webhook.SignatureVerificationException;

// 生のボディを読み込む — JSON パーサで整形すると署名が一致しなくなります。
String payload = new String(request.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
String header  = request.getHeader(Webhook.HEADER_NAME); // "elepay-Signature"

try {
    Webhook.verifyHeader(payload, header, webhookSigningSecret);
    // 署名が有効。payload をパースして処理へ。
} catch (SignatureVerificationException e) {
    // 署名不一致／タイムスタンプ超過／ヘッダ不正。HTTP 400 で応答。
}
```

デフォルトの許容時間差は **300 秒**。4 引数版で上書きできます。`0` を渡すとタイムスタンプチェックを完全に無効化します（本番では非推奨）。

```java
Webhook.verifyHeader(payload, header, secret, 60L); // 許容 60 秒
```

## スレッドセーフ

`ApiClient` は内部で Apache HttpClient 5 のコネクションプールを使うため、**1 インスタンスを複数スレッドで共有可能**です。非常に高スループットな環境や、独立した認証情報・カスタムインターセプタが必要な場合は、スレッド／テナントごとに `ApiClient` を作成することを検討してください。

## 動作するサンプル

Webhook 検証と定期ポーリングを組み合わせた Spring Boot サンプルを [`samples/quickstart/`](samples/quickstart/) に同梱しています。シーケンス図と「なぜ両方走らせるのか」の解説は [samples/quickstart/README.md](samples/quickstart/README.md) を参照してください。

## Contributing

バグ報告や機能要望は GitHub Issues へお願いします。Pull Request も歓迎しますが、変更が大きい場合はまず Issue で方針を相談してください。

## サポート

- **メール**: support@elestyle.jp
- **API ドキュメント**: https://developer.elepay.io
- **サイト**: https://elepay.io

## ライセンス

[MIT](LICENSE) — © ELESTYLE, Inc.
