package io.elepay.quickstart.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.elepay.quickstart.domain.Customer;
import io.elepay.quickstart.domain.Order;
import io.elepay.quickstart.domain.OrderType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.elepay.client.charge.pojo.ChargeDto;
import io.elepay.client.charge.pojo.CodeDto;
import io.elepay.client.charge.pojo.SubscriptionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Central index of merchant {@link Order}s keyed by merchant-generated
 * {@code orderNo}. A secondary index by elepay resource id lets inbound
 * webhooks locate the right order in O(1) — elepay events carry the
 * resource id, not the merchant orderNo, so that mapping has to live
 * somewhere.
 *
 * <p>Also exposes a small {@link #toJson(Object)} helper so controllers
 * can serialize SDK DTOs for the events timeline without every one of
 * them handling {@link JsonProcessingException}.
 */
@Repository
public class OrderRepository {

    private static final Logger log = LoggerFactory.getLogger(OrderRepository.class);
    private static final int MAX_ENTRIES = 200;

    private final EventLog events;
    private final CustomerRepository customers;
    private final Map<String, Order>  byOrderNo             = Collections.synchronizedMap(new LinkedHashMap<>());
    private final Map<String, String> resourceIdToOrderNo   = Collections.synchronizedMap(new LinkedHashMap<>());
    private final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public OrderRepository(EventLog events, CustomerRepository customers) {
        this.events = events;
        this.customers = customers;
    }

    public Order registerCharge(String orderNo, ChargeDto charge, String customerId) {
        Order o = new Order(orderNo, OrderType.CHARGE, charge.getAmount(), charge.getCurrency(),
                charge.getPaymentMethod(), customerId);
        o.setElepayResourceId(charge.getId());
        o.applyUpdate(charge.getStatus(), "create", toJson(charge));
        register(o, charge.getId());
        return o;
    }

    public Order registerCode(String orderNo, CodeDto code, String customerId) {
        Order o = new Order(orderNo, OrderType.CODE, code.getAmount(), code.getCurrency(),
                "code", customerId);
        o.setElepayResourceId(code.getId());
        o.applyUpdate(code.getStatus(), "create", toJson(code));
        register(o, code.getId());
        return o;
    }

    public Order registerSubscription(String orderNo, SubscriptionDto sub, String customerId,
                                      Integer amount, String currency) {
        Order o = new Order(orderNo, OrderType.SUBSCRIPTION, amount, currency, "subscription", customerId);
        o.setElepayResourceId(sub.getId());
        o.applyUpdate(String.valueOf(sub.getStatus()), "create", toJson(sub));
        register(o, sub.getId());
        return o;
    }

    private void register(Order o, String resourceId) {
        synchronized (byOrderNo) {
            byOrderNo.put(o.getOrderNo(), o);
            while (byOrderNo.size() > MAX_ENTRIES) {
                Iterator<Map.Entry<String, Order>> it = byOrderNo.entrySet().iterator();
                Map.Entry<String, Order> oldest = it.next();
                resourceIdToOrderNo.values().remove(oldest.getKey());
                it.remove();
            }
        }
        if (resourceId != null) resourceIdToOrderNo.put(resourceId, o.getOrderNo());
        if (o.isHasCustomer()) {
            Customer c = customers.get(o.getCustomerId());
            if (c != null) c.addOrder(o.getOrderNo());
        }
        events.record(EventLog.Entry.create(
                o.getType().name().toLowerCase() + "." + o.getOrderNo(),
                o.getType().name().toLowerCase() + " created: resource=" + resourceId + " status=" + o.getRawStatus(),
                o.getLastRawJson()));
        log.info("[orders] created {} {} (resource={}, status={})",
                o.getType(), o.getOrderNo(), resourceId, o.getRawStatus());
    }

    public Order getByOrderNo(String orderNo) { return byOrderNo.get(orderNo); }

    public Order getByResourceId(String resourceId) {
        if (resourceId == null) return null;
        String orderNo = resourceIdToOrderNo.get(resourceId);
        return orderNo == null ? null : byOrderNo.get(orderNo);
    }

    /** Update an order's status from an inbound verified webhook. */
    public Order applyWebhook(String resourceId, String newStatus, String rawPayload) {
        Order o = getByResourceId(resourceId);
        if (o == null) return null;
        String old = o.getRawStatus();
        o.applyUpdate(newStatus, "webhook", rawPayload);
        events.record(EventLog.Entry.webhook(
                o.getType().name().toLowerCase() + "." + o.getOrderNo(),
                "webhook: " + resourceId + " " + nz(old) + " -> " + nz(newStatus),
                rawPayload));
        log.info("[orders] {} webhook {} -> {} via {}", o.getOrderNo(), old, newStatus, resourceId);
        return o;
    }

    /** Apply an explicit refresh result (caller supplies the fresh DTO's status and JSON). */
    public Order applyRefresh(String orderNo, String newStatus, String source, String rawJson) {
        Order o = byOrderNo.get(orderNo);
        if (o == null) return null;
        String old = o.getRawStatus();
        o.applyUpdate(newStatus, source, rawJson);
        events.record(EventLog.Entry.refresh(
                o.getType().name().toLowerCase() + "." + orderNo,
                source + ": " + orderNo + " " + nz(old) + " -> " + nz(newStatus),
                rawJson));
        return o;
    }

    public List<Order> recent() {
        synchronized (byOrderNo) {
            List<Order> list = new ArrayList<>(byOrderNo.values());
            Collections.reverse(list);
            return list;
        }
    }

    public List<Order> byCustomer(String customerId) {
        List<Order> out = new ArrayList<>();
        synchronized (byOrderNo) {
            for (Order o : byOrderNo.values()) {
                if (customerId != null && customerId.equals(o.getCustomerId())) out.add(o);
            }
        }
        Collections.reverse(out);
        return out;
    }

    /** JSON-serialize an SDK DTO with indentation, returning an error placeholder on failure. */
    public String toJson(Object dto) {
        try {
            return mapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            return "<failed to serialize " + dto.getClass().getSimpleName() + ": " + e.getMessage() + ">";
        }
    }

    public void clear() {
        byOrderNo.clear();
        resourceIdToOrderNo.clear();
    }

    private static String nz(String s) { return s == null ? "(null)" : s; }
}
