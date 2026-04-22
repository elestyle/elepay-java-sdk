package io.elepay.quickstart.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.elepay.client.charge.pojo.RefundDto;

/**
 * Merchant-level order. A single aggregate over any of Charge / Code /
 * Subscription so the UI and webhook router can treat them uniformly.
 *
 * <p>Identity is {@link #getOrderNo()}, a merchant-generated string. The
 * elepay-side resource id (chargeId / codeId / subscriptionId) lives in
 * {@link #getElepayResourceId()} and is how inbound webhooks locate this
 * order — events reference the resource id, not the merchant orderNo.
 */
public class Order {

    private final String orderNo;
    private final OrderType type;
    private final Instant createdAt;
    private final Integer amount;
    private final String currency;
    private final String paymentMethod;   // display only
    private final String customerId;      // local Customer id (== elepay customer id); nullable

    private volatile String elepayResourceId;
    private volatile String rawStatus;
    private volatile OrderStatus businessStatus = OrderStatus.PENDING;
    private volatile Instant lastUpdatedAt;
    private volatile String lastUpdatedBy;   // "create" | "webhook" | "refresh" | "return" | "action"
    private volatile String lastRawJson;

    private final List<RefundDto> refunds = Collections.synchronizedList(new ArrayList<>());

    public Order(String orderNo, OrderType type, Integer amount, String currency,
                 String paymentMethod, String customerId) {
        this.orderNo = orderNo;
        this.type = type;
        this.createdAt = Instant.now();
        this.amount = amount;
        this.currency = currency;
        this.paymentMethod = paymentMethod == null ? "" : paymentMethod;
        this.customerId = customerId;
        this.lastUpdatedAt = this.createdAt;
        this.lastUpdatedBy = "create";
    }

    public String getOrderNo()      { return orderNo; }
    public OrderType getType()      { return type; }
    public String getTypeLabel()    { return type.name().toLowerCase(); }
    public String getCreatedAt()    { return createdAt.toString(); }
    public Integer getAmount()      { return amount; }
    public String getCurrency()     { return currency == null ? "" : currency; }
    public String getPaymentMethod(){ return paymentMethod; }
    public String getCustomerId()   { return customerId == null ? "" : customerId; }
    public boolean isHasCustomer()  { return customerId != null && !customerId.isEmpty(); }

    public String getElepayResourceId()     { return elepayResourceId == null ? "" : elepayResourceId; }
    public String getRawStatus()            { return rawStatus == null ? "" : rawStatus; }
    public OrderStatus getBusinessStatus()  { return businessStatus; }
    public String getBusinessStatusLabel()  { return businessStatus.name().toLowerCase(); }
    public String getLastUpdatedAt()        { return lastUpdatedAt == null ? "" : lastUpdatedAt.toString(); }
    public String getLastUpdatedBy()        { return lastUpdatedBy == null ? "" : lastUpdatedBy; }
    public String getLastRawJson()          { return lastRawJson == null ? "" : lastRawJson; }

    public String getAmountCurrency() {
        if (amount == null) return "";
        return amount + " " + getCurrency();
    }

    public List<RefundDto> getRefunds() {
        synchronized (refunds) { return new ArrayList<>(refunds); }
    }

    public void setElepayResourceId(String id) { this.elepayResourceId = id; }

    public void applyUpdate(String newRawStatus, String source, String rawJson) {
        this.rawStatus = newRawStatus;
        this.businessStatus = OrderStatus.from(type, newRawStatus);
        this.lastUpdatedAt = Instant.now();
        this.lastUpdatedBy = source;
        if (rawJson != null && !rawJson.isEmpty()) this.lastRawJson = rawJson;
    }

    public void recordRefund(RefundDto refund) {
        if (refund == null) return;
        synchronized (refunds) {
            refunds.removeIf(r -> refund.getId() != null && refund.getId().equals(r.getId()));
            refunds.add(refund);
        }
    }

    public void replaceRefunds(List<RefundDto> list) {
        synchronized (refunds) {
            refunds.clear();
            if (list != null) refunds.addAll(list);
        }
    }
}
