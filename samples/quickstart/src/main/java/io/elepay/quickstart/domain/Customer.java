package io.elepay.quickstart.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Merchant-side customer record. 1:1 with an elepay
 * {@link io.elepay.client.charge.pojo.CustomerDto} — we keep the id as
 * {@link #getId()} and cache name/email for list rendering. Source ids
 * and order numbers are tracked locally so we can group by customer
 * without re-calling {@code listSources} / scanning all orders.
 *
 * <p>The type is deliberately named {@code Customer} (not {@code User}) so
 * it reads the same way as the SDK's own vocabulary.
 */
public class Customer {

    private final String id;                  // elepay customer id
    private final String name;
    private final String email;
    private final Instant createdAt;
    private final List<String> sourceIds = Collections.synchronizedList(new ArrayList<>());
    private final List<String> orderNos  = Collections.synchronizedList(new ArrayList<>());

    public Customer(String id, String name, String email) {
        this.id = id;
        this.name = name == null ? "" : name;
        this.email = email == null ? "" : email;
        this.createdAt = Instant.now();
    }

    public String getId()        { return id; }
    public String getName()      { return name; }
    public String getEmail()     { return email; }
    public String getCreatedAt() { return createdAt.toString(); }
    public List<String> getSourceIds() { return new ArrayList<>(sourceIds); }
    public List<String> getOrderNos()  { return new ArrayList<>(orderNos); }

    public void addSource(String sourceId) {
        if (sourceId != null && !sourceIds.contains(sourceId)) sourceIds.add(sourceId);
    }

    public void removeSource(String sourceId) { sourceIds.remove(sourceId); }

    public void addOrder(String orderNo) {
        if (orderNo != null && !orderNos.contains(orderNo)) orderNos.add(orderNo);
    }
}
