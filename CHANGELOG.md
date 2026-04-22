# Changelog

## 2.0.0

### Breaking changes

#### Response DTO fields: enum → `String`

The following response DTO fields are now typed as `String` instead of their previous enum types. This change ensures that future server-side additions (new payment methods, new statuses, new resource types) flow through old SDK versions without breaking JSON deserialization.

| Class | Field | Previous type | New type |
| --- | --- | --- | --- |
| `ChargeDto` | `status` | `ChargeStatusType` | `String` |
| `ChargeDto` | `paymentMethod` | `PaymentMethodType` | `String` |
| `ChargeDto` | `resource` | `ResourceType` | `String` |
| `ChargeStatusDto` | `status` | `ChargeStatusType` | `String` |
| `RefundDto` | `status` | `RefundStatusType` | `String` |
| `DisputeDto` | `status` | `DisputeStatusType` | `String` |
| `InvoiceDto` | `status` | `InvoiceStatusType` | `String` |
| `SubscriptionDto` | `status` | `SubscriptionStatusType` | `String` |
| `SourceDto` | `paymentMethod` | `PaymentMethodType` | `String` |
| `SourceDto` | `resource` | `ResourceType` | `String` |
| `SourceDto` | `status` | `SourceStatusType` | `String` |
| `SourceStatusDto` | `status` | `SourceStatusType` | `String` |
| `CustomerDto` | `status` | `CustomerStatusType` | `String` |
| `CodeDto` | `status` | `CodeStatusType` | `String` |
| `TerminalReaderDto` | `status` | `ReaderStatusType` | `String` |
| `ChargeLocationDto` | `status` | `ChargeLocationStatusType` | `String` |
| `PaymentMethodDto` | `paymentMethod` | `PaymentMethodType` | `String` |
| `PaymentMethodDto` | `resources` | `List<ResourceType>` | `List<String>` |
| `ChannelPropertiesDto` | `resourceWebEnv` | `ResourceWebEnvType` | `String` |
| `InvoiceTaxSummaryItemDto` | `taxRateType` | `TaxRateType` | `String` |
| `InvoiceItem` | `taxRateType` | `TaxRateType` | `String` |

`InvoiceItem` is used both as a request-side input (inside `InvoiceReq.items`) and as a response-side field (inside `InvoiceDto.items`). Callers constructing `InvoiceItem` for a request must now pass the string form:

```java
// Before
item.taxRateType(TaxRateType.STANDARD);

// After
item.taxRateType(TaxRateType.STANDARD.getValue());
```

#### `fromValue(String)` behavior

`<EnumType>.fromValue(String)` now returns `null` for unknown values (previously threw `IllegalArgumentException`). The `@JsonCreator` annotation has been removed — Jackson no longer calls this method during deserialization because response fields are now `String`.

### Migration

Before:

```java
if (charge.getStatus() == ChargeStatusType.CAPTURED) {
    // ...
}
```

After — two idiomatic options:

```java
// (1) compare with the enum's string value
if (ChargeStatusType.CAPTURED.getValue().equals(charge.getStatus())) {
    // ...
}

// (2) convert String back to enum, remembering unknown values map to null
ChargeStatusType status = ChargeStatusType.fromValue(charge.getStatus());
if (status == ChargeStatusType.CAPTURED) {
    // ...
}
```

### Unchanged

- Request DTOs (`ChargeReq`, `SourceReq`, `InvoiceReq`, `SubscriptionReq`, `ChargeLocationReq`, `ChargeLocationUpdateReq`) still type their enum-like fields as enums — these flow one-way (enum → JSON) and have no deserialization risk.
- API method parameters (`ChargeApi.listCharges(...)`, `SubscriptionApi.listSubscriptions(...)`, etc.) still accept enum parameters for the same reason.
- All enum classes remain available as constant containers; enum constants such as `PaymentMethodType.ALIPAY` continue to work.

---

## 1.3.0 and earlier

See git history.
