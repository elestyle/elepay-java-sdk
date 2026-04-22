package io.elepay.quickstart.web;

import io.elepay.quickstart.domain.Order;
import io.elepay.quickstart.domain.OrderType;
import io.elepay.quickstart.repository.CustomerRepository;
import io.elepay.quickstart.repository.EventLog;
import io.elepay.quickstart.repository.OrderRepository;

import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.api.CustomerApi;
import io.elepay.client.charge.api.SubscriptionApi;
import io.elepay.client.charge.pojo.SubscriptionDto;
import io.elepay.client.charge.pojo.SubscriptionIntervalType;
import io.elepay.client.charge.pojo.SubscriptionPeriodsResponse;
import io.elepay.client.charge.pojo.SubscriptionReq;
import io.elepay.client.charge.pojo.SubscriptionUpdateReq;
import io.elepay.client.charge.pojo.SubscriptionsResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Demonstrates {@link SubscriptionApi}: create / list / retrieve / start /
 * resume / cancel / update / listPeriods. A subscription requires a customer;
 * once created, remember to call {@code startSubscription} before billing
 * begins.
 *
 * <p>Periods populate after the first billing cycle runs — sandbox rarely
 * shows non-empty period lists during a short demo session.
 */
@Controller
public class SubscriptionController {

    private final SubscriptionApi subscriptionApi;
    private final CustomerApi customerApi;
    private final OrderRepository orders;
    private final CustomerRepository customers;
    private final EventLog events;

    public SubscriptionController(SubscriptionApi subscriptionApi, CustomerApi customerApi,
                                  OrderRepository orders, CustomerRepository customers, EventLog events) {
        this.subscriptionApi = subscriptionApi;
        this.customerApi     = customerApi;
        this.orders          = orders;
        this.customers       = customers;
        this.events          = events;
    }

    @GetMapping("/subscriptions")
    public String page(@RequestParam(required = false) String customerId, Model model) {
        model.addAttribute("customers", remoteCustomers());
        model.addAttribute("intervals", SubscriptionIntervalType.values());
        model.addAttribute("localOrders", orders.recent().stream()
                .filter(o -> o.getType() == OrderType.SUBSCRIPTION).toList());
        model.addAttribute("customerId", customerId);
        try {
            // --- elepay SDK ---
            SubscriptionsResponse resp = subscriptionApi.listSubscriptions(
                    customerId == null || customerId.isEmpty() ? null : customerId,
                    null, null, null, 20, 0);
            model.addAttribute("remote", resp.getSubscriptions());
            model.addAttribute("remoteTotal", resp.getTotal());
        } catch (ApiException e) {
            model.addAttribute("error", "listSubscriptions HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        return "subscriptions";
    }

    @PostMapping("/subscriptions/new")
    public String create(@RequestParam String name,
                         @RequestParam String customerId,
                         @RequestParam int amount,
                         @RequestParam(defaultValue = "JPY") String currency,
                         @RequestParam String interval,
                         @RequestParam(defaultValue = "1") int intervalSpan,
                         @RequestParam(required = false) Integer initialAmount,
                         RedirectAttributes flash) {
        try {
            SubscriptionIntervalType iv = SubscriptionIntervalType.fromValue(interval);
            if (iv == null) {
                flash.addFlashAttribute("error", "unsupported interval: " + interval);
                return "redirect:/subscriptions";
            }
            SubscriptionReq req = new SubscriptionReq()
                    .name(name)
                    .customerId(customerId)
                    .amount(amount)
                    .currency(currency)
                    .interval(iv)
                    .intervalSpan(intervalSpan);
            if (initialAmount != null) req.setInitialAmount(initialAmount);
            // --- elepay SDK ---
            SubscriptionDto sub = subscriptionApi.createSubscription(req);
            String orderNo = "sub-" + System.currentTimeMillis();
            Order o = orders.registerSubscription(orderNo, sub, customerId, amount, currency);
            flash.addFlashAttribute("info", "created subscription " + sub.getId()
                    + " (status=" + sub.getStatus() + ") — remember to call startSubscription");
            return "redirect:/orders/" + o.getOrderNo();
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "createSubscription HTTP " + e.getCode() + ": " + e.getResponseBody());
            return "redirect:/subscriptions";
        }
    }

    @PostMapping("/subscriptions/{orderNo}/refresh")
    public String refresh(@PathVariable String orderNo, RedirectAttributes flash) {
        Order o = mustSub(orderNo, flash);
        if (o == null) return "redirect:/subscriptions";
        try {
            // --- elepay SDK ---
            SubscriptionDto fresh = subscriptionApi.retrieveSubscription(o.getElepayResourceId());
            orders.applyRefresh(orderNo, String.valueOf(fresh.getStatus()), "refresh", orders.toJson(fresh));
            flash.addFlashAttribute("info", "refreshed " + orderNo + " status=" + fresh.getStatus());
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        return "redirect:/orders/" + orderNo;
    }

    @PostMapping("/subscriptions/{orderNo}/start")
    public String start(@PathVariable String orderNo, RedirectAttributes flash) { return transition(orderNo, "start", flash); }

    @PostMapping("/subscriptions/{orderNo}/resume")
    public String resume(@PathVariable String orderNo, RedirectAttributes flash) { return transition(orderNo, "resume", flash); }

    @PostMapping("/subscriptions/{orderNo}/cancel")
    public String cancel(@PathVariable String orderNo, RedirectAttributes flash) { return transition(orderNo, "cancel", flash); }

    @PostMapping("/subscriptions/{orderNo}/metadata")
    public String setMetadata(@PathVariable String orderNo,
                              @RequestParam String key,
                              @RequestParam String value,
                              RedirectAttributes flash) {
        Order o = mustSub(orderNo, flash);
        if (o == null) return "redirect:/subscriptions";
        try {
            SubscriptionUpdateReq req = new SubscriptionUpdateReq();
            req.putMetadataItem(key, value);
            // --- elepay SDK ---
            SubscriptionDto fresh = subscriptionApi.updateSubscription(o.getElepayResourceId(), req);
            orders.applyRefresh(orderNo, String.valueOf(fresh.getStatus()), "action", orders.toJson(fresh));
            events.record(EventLog.Entry.action("subscription." + orderNo,
                    "updateSubscription metadata[" + key + "]=" + value, orders.toJson(fresh)));
            flash.addFlashAttribute("info", "updated metadata for " + orderNo);
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "updateSubscription HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        return "redirect:/orders/" + orderNo;
    }

    @GetMapping("/subscriptions/{orderNo}/periods")
    public String listPeriods(@PathVariable String orderNo, Model model) {
        Order o = orders.getByOrderNo(orderNo);
        if (o == null || o.getType() != OrderType.SUBSCRIPTION) {
            model.addAttribute("error", "no subscription order: " + orderNo);
            return "subscription_periods";
        }
        model.addAttribute("order", o);
        try {
            // --- elepay SDK ---
            SubscriptionPeriodsResponse resp = subscriptionApi.listSubscriptionPeriods(
                    o.getElepayResourceId(), 20, 0);
            model.addAttribute("periods", resp.getPeriods());
            model.addAttribute("total",   resp.getTotal());
        } catch (ApiException e) {
            model.addAttribute("error", "HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        return "subscription_periods";
    }

    private String transition(String orderNo, String which, RedirectAttributes flash) {
        Order o = mustSub(orderNo, flash);
        if (o == null) return "redirect:/subscriptions";
        try {
            SubscriptionDto fresh;
            switch (which) {
                case "start":  // --- elepay SDK ---
                    fresh = subscriptionApi.startSubscription(o.getElepayResourceId()); break;
                case "resume": // --- elepay SDK ---
                    fresh = subscriptionApi.resumeSubscription(o.getElepayResourceId()); break;
                case "cancel": // --- elepay SDK ---
                    fresh = subscriptionApi.cancelSubscription(o.getElepayResourceId()); break;
                default: throw new IllegalStateException("unreachable");
            }
            orders.applyRefresh(orderNo, String.valueOf(fresh.getStatus()), "action", orders.toJson(fresh));
            events.record(EventLog.Entry.action("subscription." + orderNo,
                    which + "Subscription: status=" + fresh.getStatus(), orders.toJson(fresh)));
            flash.addFlashAttribute("info", which + " → status=" + fresh.getStatus());
        } catch (ApiException e) {
            flash.addFlashAttribute("error", which + "Subscription HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        return "redirect:/orders/" + orderNo;
    }

    private Order mustSub(String orderNo, RedirectAttributes flash) {
        Order o = orders.getByOrderNo(orderNo);
        if (o == null || o.getType() != OrderType.SUBSCRIPTION) {
            flash.addFlashAttribute("error", "no subscription order: " + orderNo);
            return null;
        }
        return o;
    }

    private java.util.List<java.util.Map<String, String>> remoteCustomers() {
        try {
            // --- elepay SDK ---
            var resp = customerApi.listCustomers(null, 100, 0);
            return resp.getCustomers().stream()
                    .map(c -> java.util.Map.of(
                            "id", c.getId() == null ? "" : c.getId(),
                            "label", (c.getId() == null ? "" : c.getId())
                                    + " · " + (c.getName() == null ? "" : c.getName())))
                    .toList();
        } catch (ApiException e) {
            return customers.all().stream()
                    .map(c -> java.util.Map.of("id", c.getId(), "label", c.getId() + " · " + c.getName()))
                    .toList();
        }
    }
}
