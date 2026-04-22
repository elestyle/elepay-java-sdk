# elepay Java SDK

**English** | [日本語](README.ja.md) | [简体中文](README.zh.md)

Official Java SDK for the [elepay](https://elepay.io) payment platform. A typed, documented client for Charges, Refunds, Customers, Subscriptions, Invoices, Terminal, and more.

- **Latest version**: `2.0.0`
- **Base URL**: `https://api.elepay.io`
- **Developer portal**: https://developer.elepay.io

## Features

- **Charges & Refunds** — `create` / `capture` / `revoke` / `refund`
- **EasyQR codes** — dynamic QR payment flows
- **Customers & Sources** — stored payment methods per customer
- **Invoices** — `draft` / `submit` / `send` / `cancel`
- **Subscriptions** — recurring billing with periods
- **Terminal** — physical card reader management
- **Disputes** — chargeback retrieval
- **Payment methods** — query supported methods dynamically

## Requirements

- Java **1.8+**
- Maven **3.6+** or Gradle **7+**

## Installation

### Maven

```xml
<dependency>
  <groupId>io.elepay</groupId>
  <artifactId>elepay-java-sdk</artifactId>
  <version>2.0.0</version>
</dependency>
```

### Gradle

```groovy
implementation 'io.elepay:elepay-java-sdk:2.0.0'
```

### Build from source

```shell
git clone https://github.com/elestyle/elepay-java-sdk.git
cd elepay-java-sdk
mvn clean install
```

This installs the artifact to your local Maven repository. To package a standalone JAR, run `mvn clean package` and grab `target/elepay-java-sdk-2.0.0.jar` plus the runtime dependencies under `target/lib/`.

## Quick Start

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

## Authentication

The API accepts either scheme; pick one.

**Bearer token (recommended)**

```java
HttpBearerAuth bearer = (HttpBearerAuth) client.getAuthentication("bearerAuth");
bearer.setBearerToken("sk_live_xxxxxxxx");
```

**HTTP Basic**

```java
HttpBasicAuth basic = (HttpBasicAuth) client.getAuthentication("basicAuth");
basic.setUsername("sk_live_xxxxxxxx"); // password left empty
```

> Never commit secret keys. Load them from environment variables or a secret manager.

## API Catalog

Per-endpoint request and response schemas are in [`docs/`](docs/).

| API | Resource |
|---|---|
| [`ChargeApi`](docs/ChargeApi.md) | `/charges` — `create` / `capture` / `revoke` / `list` |
| [`RefundApi`](docs/RefundApi.md) | `/charges/{id}/refunds` |
| [`CustomerApi`](docs/CustomerApi.md) | `/customers`, `/sources` |
| [`InvoiceApi`](docs/InvoiceApi.md) | `/invoices` — `draft` → `submit` → `send` |
| [`SubscriptionApi`](docs/SubscriptionApi.md) | `/subscriptions` — recurring billing |
| [`CodeApi`](docs/CodeApi.md) | `/codes` — EasyQR |
| [`CodeSettingApi`](docs/CodeSettingApi.md) | `/code-setting/payment-methods` |
| [`TerminalApi`](docs/TerminalApi.md) | `/terminal/readers`, `/terminal/locations` |
| [`PaymentMethodApi`](docs/PaymentMethodApi.md) | `/payment-methods` |
| [`DisputeApi`](docs/DisputeApi.md) | `/disputes` |

Data models are documented alongside under [`docs/*.md`](docs/).

## Error Handling

All API calls throw `ApiException` on non-2xx responses. Useful accessors:

```java
try {
    api.createCharge(req);
} catch (ApiException e) {
    e.getCode();             // HTTP status code
    e.getResponseBody();     // raw body (typically JSON with elepay error codes)
    e.getResponseHeaders();  // full header map
}
```

## Webhooks

Verify the signature on incoming webhooks with `Webhook.verifyHeader` before trusting the body.

```java
import io.elepay.client.charge.webhook.Webhook;
import io.elepay.client.charge.webhook.SignatureVerificationException;

// Read the RAW body — don't let a JSON parser reformat it, or the signature won't match.
String payload = new String(request.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
String header  = request.getHeader(Webhook.HEADER_NAME); // "elepay-Signature"

try {
    Webhook.verifyHeader(payload, header, webhookSigningSecret);
    // Signature is valid. Parse and dispatch.
} catch (SignatureVerificationException e) {
    // Signature is invalid, timestamp is stale, or header is malformed. Respond 400.
}
```

The default timestamp tolerance is **300 seconds**. Override it with the 4-arg overload, or pass `0` to disable the timestamp check entirely (not recommended in production):

```java
Webhook.verifyHeader(payload, header, secret, 60L); // 60-second tolerance
```

## Concurrency

`ApiClient` wraps an Apache HttpClient 5 connection pool, so a **single instance can be shared across threads**. For very high-throughput workloads where you need independent auth state or custom interceptors, create one `ApiClient` per thread or per tenant.

## Runnable sample

A Spring Boot app that exercises the SDK end-to-end — webhook verification + background status polling — lives in [`samples/quickstart/`](samples/quickstart/). See its [README](samples/quickstart/README.md) for the sequence diagram and why we recommend running webhook and polling in parallel.

## Contributing

Bug reports and feature requests are welcome via GitHub Issues. Pull requests are welcome — please open an issue first for larger changes so we can discuss the approach.

## Support

- **Email**: support@elestyle.jp
- **API docs**: https://developer.elepay.io
- **Website**: https://elepay.io

## License

[MIT](LICENSE) — © ELESTYLE, Inc.
