# elepay-java-sdk

elepay API リファレンス

- API version: 1.1.19

elepay APIはRESTをベースに構成された決済APIです。支払い処理、返金処理など、決済に関わる運用における様々なことができます。

  For more information, please visit [https://elepay.io](https://elepay.io)

*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*

## Requirements

Building the API client library requires:

1. Java 1.8+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>io.elepay</groupId>
  <artifactId>elepay-java-sdk</artifactId>
  <version>1.1.19</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.elepay:elepay-java-sdk:1.1.19"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

- `target/elepay-java-sdk-1.1.19.jar`
- `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.elepay.client.charge.*;
import io.elepay.client.charge.auth.*;
import io.elepay.client.charge.pojo.*;
import io.elepay.client.charge.api.ChargeApi;

public class ChargeApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.elepay.io");

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("Your Elepay Secret Key");

        ChargeApi apiInstance = new ChargeApi(defaultClient);
        ChargeReq chargeReq = new ChargeReq(); // ChargeReq | 支払リクエスト
        try {
            ChargeDto result = apiInstance.createCharge(chargeReq);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChargeApi#createCharge");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://api.elepay.io*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ChargeApi* | [**captureCharge**](docs/ChargeApi.md#captureCharge) | **POST** /charges/{id}/capture | Capture charge
*ChargeApi* | [**createCharge**](docs/ChargeApi.md#createCharge) | **POST** /charges | Create charge
*ChargeApi* | [**listCharges**](docs/ChargeApi.md#listCharges) | **GET** /charges | List charges
*ChargeApi* | [**retrieveCharge**](docs/ChargeApi.md#retrieveCharge) | **GET** /charges/{id} | Retrieve charge
*ChargeApi* | [**retrieveChargeStatus**](docs/ChargeApi.md#retrieveChargeStatus) | **GET** /charges/{id}/status | Retrieve charge&#39;s status
*ChargeApi* | [**revokeCharge**](docs/ChargeApi.md#revokeCharge) | **POST** /charges/{id}/revoke | Revoke charge
*CodeApi* | [**closeCode**](docs/CodeApi.md#closeCode) | **DELETE** /codes/{codeId} | Close EasyQR code
*CodeApi* | [**createCode**](docs/CodeApi.md#createCode) | **POST** /codes | Create EasyQR code
*CodeApi* | [**retrieveCode**](docs/CodeApi.md#retrieveCode) | **GET** /codes/{codeId} | Retrieve EasyQR code
*CodeSettingApi* | [**listCodePaymentMethods**](docs/CodeSettingApi.md#listCodePaymentMethods) | **GET** /code-setting/payment-methods | List all enabled EasyQR payment methods
*CustomerApi* | [**createCustomer**](docs/CustomerApi.md#createCustomer) | **POST** /customers | Create customer
*CustomerApi* | [**createSource**](docs/CustomerApi.md#createSource) | **POST** /customers/{customerId}/sources | Create source
*CustomerApi* | [**deleteCustomer**](docs/CustomerApi.md#deleteCustomer) | **DELETE** /customers/{customerId} | Delete customer
*CustomerApi* | [**deleteSource**](docs/CustomerApi.md#deleteSource) | **DELETE** /customers/{customerId}/sources/{sourceId} | Delete source
*CustomerApi* | [**listCustomers**](docs/CustomerApi.md#listCustomers) | **GET** /customers | List customers
*CustomerApi* | [**listSources**](docs/CustomerApi.md#listSources) | **GET** /customers/{customerId}/sources | List sources by customer ID
*CustomerApi* | [**retrieveCustomer**](docs/CustomerApi.md#retrieveCustomer) | **GET** /customers/{customerId} | Retrieve customer
*CustomerApi* | [**retrieveSource**](docs/CustomerApi.md#retrieveSource) | **GET** /customers/{customerId}/sources/{sourceId} | Retrieve source
*CustomerApi* | [**updateCustomer**](docs/CustomerApi.md#updateCustomer) | **POST** /customers/{customerId} | update customer
*DisputeApi* | [**listDisputes**](docs/DisputeApi.md#listDisputes) | **GET** /disputes | List disputes
*DisputeApi* | [**retrieveDispute**](docs/DisputeApi.md#retrieveDispute) | **GET** /disputes/{id} | Retrieve dispute
*InvoiceApi* | [**cancelInvoice**](docs/InvoiceApi.md#cancelInvoice) | **POST** /invoices/{invoiceId}/cancel | cancel invoice
*InvoiceApi* | [**createInvoice**](docs/InvoiceApi.md#createInvoice) | **POST** /invoices | Create invoice
*InvoiceApi* | [**deleteInvoice**](docs/InvoiceApi.md#deleteInvoice) | **DELETE** /invoices/{invoiceId} | Delete invoice
*InvoiceApi* | [**listInvoices**](docs/InvoiceApi.md#listInvoices) | **GET** /invoices | List invoices
*InvoiceApi* | [**retrieveInvoice**](docs/InvoiceApi.md#retrieveInvoice) | **GET** /invoices/{invoiceId} | Retrieve invoice
*InvoiceApi* | [**sendInvoice**](docs/InvoiceApi.md#sendInvoice) | **POST** /invoices/{invoiceId}/send | send invoice
*InvoiceApi* | [**updateInvoice**](docs/InvoiceApi.md#updateInvoice) | **POST** /invoices/{invoiceId} | Update invoice
*PaymentMethodApi* | [**listPaymentMethods**](docs/PaymentMethodApi.md#listPaymentMethods) | **GET** /payment-methods | List supported payment methods
*RefundApi* | [**createRefund**](docs/RefundApi.md#createRefund) | **POST** /charges/{id}/refunds | Create refund
*RefundApi* | [**listChargesRefunds**](docs/RefundApi.md#listChargesRefunds) | **GET** /charges/{id}/refunds | List refunds
*RefundApi* | [**retrieveChargeRefund**](docs/RefundApi.md#retrieveChargeRefund) | **GET** /charges/{id}/refunds/{refundId} | Retrieve refund
*TerminalApi* | [**createReader**](docs/TerminalApi.md#createReader) | **POST** /terminal/readers | create terminal reader
*TerminalApi* | [**deleteReader**](docs/TerminalApi.md#deleteReader) | **DELETE** /terminal/readers/{readerId} | delete reader
*TerminalApi* | [**getReader**](docs/TerminalApi.md#getReader) | **GET** /terminal/readers/{readerId} | get reader
*TerminalApi* | [**listLocations**](docs/TerminalApi.md#listLocations) | **GET** /terminal/locations | list locations
*TerminalApi* | [**listReaders**](docs/TerminalApi.md#listReaders) | **GET** /terminal/readers | list readers


## Documentation for Models

 - [CardBrandType](docs/CardBrandType.md)
 - [CardInfo](docs/CardInfo.md)
 - [ChannelPropertiesDto](docs/ChannelPropertiesDto.md)
 - [ChargeCaptureReq](docs/ChargeCaptureReq.md)
 - [ChargeDateTimeType](docs/ChargeDateTimeType.md)
 - [ChargeDto](docs/ChargeDto.md)
 - [ChargeReq](docs/ChargeReq.md)
 - [ChargeStatusDto](docs/ChargeStatusDto.md)
 - [ChargeStatusType](docs/ChargeStatusType.md)
 - [ChargesResponse](docs/ChargesResponse.md)
 - [CodeDto](docs/CodeDto.md)
 - [CodeItem](docs/CodeItem.md)
 - [CodePaymentMethodResponse](docs/CodePaymentMethodResponse.md)
 - [CodeReq](docs/CodeReq.md)
 - [CodeStatusType](docs/CodeStatusType.md)
 - [CustomerDto](docs/CustomerDto.md)
 - [CustomerReq](docs/CustomerReq.md)
 - [CustomerResponse](docs/CustomerResponse.md)
 - [CustomerStatusType](docs/CustomerStatusType.md)
 - [DisputeDateTimeType](docs/DisputeDateTimeType.md)
 - [DisputeDto](docs/DisputeDto.md)
 - [DisputeStatusType](docs/DisputeStatusType.md)
 - [DisputesResponse](docs/DisputesResponse.md)
 - [InvoiceDto](docs/InvoiceDto.md)
 - [InvoiceItem](docs/InvoiceItem.md)
 - [InvoiceReq](docs/InvoiceReq.md)
 - [InvoiceStatusType](docs/InvoiceStatusType.md)
 - [InvoicesResponse](docs/InvoicesResponse.md)
 - [LocationDto](docs/LocationDto.md)
 - [LocationsResponse](docs/LocationsResponse.md)
 - [PaymentMethodDto](docs/PaymentMethodDto.md)
 - [PaymentMethodResponse](docs/PaymentMethodResponse.md)
 - [PaymentMethodType](docs/PaymentMethodType.md)
 - [ReaderStatusType](docs/ReaderStatusType.md)
 - [RefundDto](docs/RefundDto.md)
 - [RefundReq](docs/RefundReq.md)
 - [RefundStatusType](docs/RefundStatusType.md)
 - [RefundsDto](docs/RefundsDto.md)
 - [RefundsResponse](docs/RefundsResponse.md)
 - [ResourceType](docs/ResourceType.md)
 - [SortOrderType](docs/SortOrderType.md)
 - [SourceDto](docs/SourceDto.md)
 - [SourceReq](docs/SourceReq.md)
 - [SourceResponse](docs/SourceResponse.md)
 - [SourceStatusType](docs/SourceStatusType.md)
 - [TerminalReaderDto](docs/TerminalReaderDto.md)
 - [TerminalReaderReq](docs/TerminalReaderReq.md)
 - [TerminalReadersResponse](docs/TerminalReadersResponse.md)
 - [TerminalTokenDto](docs/TerminalTokenDto.md)
 - [TerminalTokenReq](docs/TerminalTokenReq.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### basicAuth


- **Type**: HTTP basic authentication


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

support@elestyle.jp

