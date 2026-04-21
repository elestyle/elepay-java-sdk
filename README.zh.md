# elepay Java SDK

[English](README.md) | [日本語](README.ja.md) | **简体中文**

[elepay](https://elepay.io) 支付平台官方 Java SDK。为 Charges、Refunds、Customers、Subscriptions、Invoices、Terminal 等业务提供类型安全、文档完备的客户端。

- **当前版本**：`1.3.0`
- **Base URL**：`https://api.elepay.io`
- **开发者中心**：https://developer.elepay.io

## 功能概览

- **Charges 与 Refunds** — `create` / `capture` / `revoke` / `refund`
- **EasyQR codes** — 动态二维码支付流程
- **Customers 与 Sources** — 按顾客绑定支付方式
- **Invoices** — `draft` / `submit` / `send` / `cancel`
- **Subscriptions** — 周期性持续计费
- **Locations** — 门店维度的交易与对账
- **Terminal** — 物理刷卡终端管理
- **Disputes** — 拒付信息查询
- **Payment methods** — 动态查询支持的支付方式

## 运行环境

- Java **1.8 及以上**
- Maven **3.6+** 或 Gradle **7+**

## 安装

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

### 从源码构建

```shell
git clone https://github.com/elestyle/elepay-java-sdk.git
cd elepay-java-sdk
mvn clean install
```

执行后 artifact 会安装到本地 Maven 仓库。如需独立 JAR，运行 `mvn clean package`，从 `target/elepay-java-sdk-1.3.0.jar` 取产物，依赖 JAR 位于 `target/lib/`。

## 快速开始

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

## 认证

两种方式任选其一即可。

**Bearer token（推荐）**

```java
HttpBearerAuth bearer = (HttpBearerAuth) client.getAuthentication("bearerAuth");
bearer.setBearerToken("sk_live_xxxxxxxx");
```

**HTTP Basic**

```java
HttpBasicAuth basic = (HttpBasicAuth) client.getAuthentication("basicAuth");
basic.setUsername("sk_live_xxxxxxxx"); // password 留空
```

> 切勿将 secret key 提交到代码仓库。请通过环境变量或密钥管理服务注入。

## API 目录

各接口的请求/响应结构参见 [`docs/`](docs/) 目录。

| API | 资源 |
|---|---|
| [`ChargeApi`](docs/ChargeApi.md) | `/charges` — `create` / `capture` / `revoke` / `list` |
| [`RefundApi`](docs/RefundApi.md) | `/charges/{id}/refunds` |
| [`CustomerApi`](docs/CustomerApi.md) | `/customers`、`/sources` |
| [`InvoiceApi`](docs/InvoiceApi.md) | `/invoices` — `draft` → `submit` → `send` |
| [`SubscriptionApi`](docs/SubscriptionApi.md) | `/subscriptions` — 持续计费 |
| [`CodeApi`](docs/CodeApi.md) | `/codes` — EasyQR |
| [`CodeSettingApi`](docs/CodeSettingApi.md) | `/code-setting/payment-methods` |
| [`LocationApi`](docs/LocationApi.md) | `/locations` |
| [`TerminalApi`](docs/TerminalApi.md) | `/terminal/readers`、`/terminal/locations` |
| [`PaymentMethodApi`](docs/PaymentMethodApi.md) | `/payment-methods` |
| [`DisputeApi`](docs/DisputeApi.md) | `/disputes` |

数据模型文档同样在 [`docs/*.md`](docs/) 下。

## 错误处理

非 2xx 响应会抛出 `ApiException`，常用方法：

```java
try {
    api.createCharge(req);
} catch (ApiException e) {
    e.getCode();             // HTTP 状态码
    e.getResponseBody();     // 响应体（通常是含 elepay 错误码的 JSON）
    e.getResponseHeaders();  // 响应头
}
```

## Webhooks

接收到 webhook 后，先用 `Webhook.verifyHeader` 验签再处理 body。

```java
import io.elepay.client.charge.webhook.Webhook;
import io.elepay.client.charge.webhook.SignatureVerificationException;

// 读取原始 body — 千万别让 JSON 解析器重排格式，否则签名会对不上。
String payload = new String(request.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
String header  = request.getHeader(Webhook.HEADER_NAME); // "elepay-Signature"

try {
    Webhook.verifyHeader(payload, header, webhookSigningSecret);
    // 验签通过，可解析并分发。
} catch (SignatureVerificationException e) {
    // 签名不匹配 / 时间戳超时 / header 格式不对。返回 HTTP 400。
}
```

默认时间戳容差为 **300 秒**。用 4 参数版可自定义；传 `0` 完全关闭时间戳检查（生产环境不推荐）。

```java
Webhook.verifyHeader(payload, header, secret, 60L); // 容差 60 秒
```

## 并发

`ApiClient` 内部使用 Apache HttpClient 5 的连接池，**单实例可在多线程间共享**。若吞吐非常高、需要独立的认证状态或自定义拦截器，可按线程或按租户各建一个 `ApiClient`。

## 可运行示例

[`samples/quickstart/`](samples/quickstart/) 里有一个 Spring Boot 示例，同时演示 webhook 验签与后台轮询。时序图和"为什么推荐双保险"的说明见 [samples/quickstart/README.md](samples/quickstart/README.md)。

## Contributing

欢迎通过 GitHub Issues 反馈 Bug 或功能需求。Pull Request 也欢迎；改动较大时请先开 Issue 讨论方案。

## 支持

- **邮箱**：support@elestyle.jp
- **API 文档**：https://developer.elepay.io
- **官网**：https://elepay.io

## License

[MIT](LICENSE) — © ELESTYLE, Inc.
