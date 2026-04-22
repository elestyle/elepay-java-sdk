package io.elepay.quickstart.web;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

import io.elepay.quickstart.config.ElepayProperties;
import io.elepay.quickstart.domain.Order;
import io.elepay.quickstart.domain.OrderType;
import io.elepay.quickstart.repository.CustomerRepository;
import io.elepay.quickstart.repository.EventLog;
import io.elepay.quickstart.repository.OrderRepository;

import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.ClientVersion;
import io.elepay.client.charge.api.ChargeApi;
import io.elepay.client.charge.pojo.ChargeCaptureReq;
import io.elepay.client.charge.pojo.ChargeDto;
import io.elepay.client.charge.pojo.ChargeReq;
import io.elepay.client.charge.pojo.ChargeStatusType;
import io.elepay.client.charge.pojo.ChargesResponse;
import io.elepay.client.charge.pojo.PaymentMethodType;
import io.elepay.client.charge.pojo.ResourceType;
import io.elepay.client.charge.pojo.SortOrderType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Demonstrates {@link ChargeApi}: create, retrieve, list, capture, revoke.
 *
 * <p>A "checkout" produces a merchant-side {@link Order} of type
 * {@link OrderType#CHARGE} — optionally linked to a
 * {@link io.elepay.quickstart.domain.Customer} and a stored source id so the
 * buyer can pay without re-entering credentials.
 *
 * <p>Demonstrates the authorize → capture split: set {@code capture=false}
 * at create time; call {@code captureCharge} later to settle, or
 * {@code revokeCharge} to void.
 */
@Controller
public class CheckoutController {

    private static final List<PaymentMethodType> METHODS = Arrays.asList(
            PaymentMethodType.ALIPAY,
            PaymentMethodType.WECHATPAY,
            PaymentMethodType.PAYPAY,
            PaymentMethodType.LINEPAY,
            PaymentMethodType.UNIONPAY,
            PaymentMethodType.CREDITCARD);

    private final ChargeApi chargeApi;
    private final ElepayProperties props;
    private final OrderRepository orders;
    private final CustomerRepository customers;
    private final EventLog events;
    private final ObjectMapper mapper = new ObjectMapper();

    public CheckoutController(ChargeApi chargeApi, ElepayProperties props,
                              OrderRepository orders, CustomerRepository customers, EventLog events) {
        this.chargeApi = chargeApi;
        this.props     = props;
        this.orders    = orders;
        this.customers = customers;
        this.events    = events;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("paymentMethods",  METHODS);
        model.addAttribute("sdkVersion",      ClientVersion.VERSION);
        model.addAttribute("userAgent",       ClientVersion.userAgent());
        model.addAttribute("maskedKey",       mask(props.getSecretKey()));
        model.addAttribute("publishableKey",  props.getPublishableKey());
        model.addAttribute("hasPublishableKey", !props.getPublishableKey().isEmpty()
                && !props.getPublishableKey().startsWith("pk_test_your_"));
        model.addAttribute("hasWebhookSecret", !props.getWebhookSigningSecret().isEmpty());
        model.addAttribute("recentOrders", orders.recent());
        return "index";
    }

    /**
     * Create a charge and, when applicable, hand the result to the browser so
     * {@code elepay.js}'s {@code handleCharge(chargeDto)} can drive the
     * hosted payment UI.
     */
    @PostMapping("/checkout")
    public String checkout(@RequestParam int amount,
                           @RequestParam(defaultValue = "JPY") String currency,
                           @RequestParam String paymentMethod,
                           @RequestParam(required = false) String customerId,
                           @RequestParam(required = false) String sourceId,
                           @RequestParam(defaultValue = "true") boolean capture,
                           HttpServletRequest request,
                           RedirectAttributes flash) {
        try {
            PaymentMethodType method = PaymentMethodType.fromValue(paymentMethod);
            if (method == null) {
                flash.addFlashAttribute("error", "unsupported payment method: " + paymentMethod);
                return "redirect:/";
            }

            String orderNo = "demo-" + System.currentTimeMillis();

            Map<String, String> extra = new HashMap<>();
            extra.put("userAgent", orElse(request.getHeader("User-Agent"), "demo/unknown"));
            extra.put("frontUrl",  baseUrl(request) + "/return?orderNo=" + orderNo);

            ChargeReq req = new ChargeReq()
                    .amount(amount)
                    .currency(currency)
                    .paymentMethod(method)
                    .resource(ResourceType.WEB)
                    .capture(capture)
                    .orderNo(orderNo)
                    .description("elepay-java-sdk quickstart demo")
                    .extra(extra)
                    .clientIp(clientIp(request));
            String effectiveCustomerId = emptyToNull(customerId);
            if (effectiveCustomerId != null) req.setCustomerId(effectiveCustomerId);
            String effectiveSourceId = emptyToNull(sourceId);
            if (effectiveSourceId != null) req.setSourceId(effectiveSourceId);

            // --- elepay SDK ---
            ChargeDto charge = chargeApi.createCharge(req);

            Order order = orders.registerCharge(orderNo, charge, effectiveCustomerId);
            if (effectiveCustomerId != null) {
                var c = customers.get(effectiveCustomerId);
                if (c != null) c.addOrder(orderNo);
            }
            flash.addFlashAttribute("charge", charge);
            flash.addFlashAttribute("chargeJson", mapper.writeValueAsString(charge));
            flash.addFlashAttribute("info", "created " + order.getOrderNo()
                    + " (charge=" + charge.getId() + ", status=" + charge.getStatus() + ")");
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "HTTP " + e.getCode() + ": " + e.getResponseBody());
        } catch (JsonProcessingException e) {
            flash.addFlashAttribute("error", "JSON: " + e.getMessage());
        }
        return "redirect:/";
    }

    /** Per-charge reconciliation — calls {@code retrieveCharge} and updates the order. */
    @PostMapping("/charges/{orderNo}/refresh")
    public String refresh(@PathVariable String orderNo, RedirectAttributes flash) {
        Order o = mustCharge(orderNo, flash);
        if (o == null) return "redirect:/orders";
        try {
            // --- elepay SDK ---
            ChargeDto fresh = chargeApi.retrieveCharge(o.getElepayResourceId());
            orders.applyRefresh(orderNo, fresh.getStatus(), "refresh", orders.toJson(fresh));
            flash.addFlashAttribute("info", "refreshed " + orderNo + " status=" + fresh.getStatus());
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "refresh failed: HTTP " + e.getCode());
        }
        return "redirect:/orders/" + orderNo;
    }

    /** Capture an authorize-only charge. */
    @PostMapping("/charges/{orderNo}/capture")
    public String capture(@PathVariable String orderNo,
                          @RequestParam(required = false) Integer amount,
                          RedirectAttributes flash) {
        Order o = mustCharge(orderNo, flash);
        if (o == null) return "redirect:/orders";
        try {
            ChargeCaptureReq req = new ChargeCaptureReq();
            if (amount != null) req.setAmount(amount);
            // --- elepay SDK ---
            ChargeDto fresh = chargeApi.captureCharge(o.getElepayResourceId(), req);
            orders.applyRefresh(orderNo, fresh.getStatus(), "action", orders.toJson(fresh));
            events.record(EventLog.Entry.action("charge." + orderNo,
                    "captured: " + o.getElepayResourceId() + " status=" + fresh.getStatus(),
                    orders.toJson(fresh)));
            flash.addFlashAttribute("info", "captured " + orderNo);
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "capture failed: HTTP " + e.getCode() + " " + e.getResponseBody());
        }
        return "redirect:/orders/" + orderNo;
    }

    /** Revoke a pending or un-captured charge. */
    @PostMapping("/charges/{orderNo}/revoke")
    public String revoke(@PathVariable String orderNo, RedirectAttributes flash) {
        Order o = mustCharge(orderNo, flash);
        if (o == null) return "redirect:/orders";
        try {
            // --- elepay SDK ---
            ChargeDto fresh = chargeApi.revokeCharge(o.getElepayResourceId());
            orders.applyRefresh(orderNo, fresh.getStatus(), "action", orders.toJson(fresh));
            events.record(EventLog.Entry.action("charge." + orderNo,
                    "revoked: " + o.getElepayResourceId() + " status=" + fresh.getStatus(),
                    orders.toJson(fresh)));
            flash.addFlashAttribute("info", "revoked " + orderNo);
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "revoke failed: HTTP " + e.getCode() + " " + e.getResponseBody());
        }
        return "redirect:/orders/" + orderNo;
    }

    /** Remote list via {@code listCharges}, rendered independently of local state. */
    @GetMapping("/charges")
    public String listCharges(@RequestParam(required = false) String status,
                              @RequestParam(required = false) String method,
                              @RequestParam(defaultValue = "20") int limit,
                              Model model) {
        try {
            ChargeStatusType st = status == null || status.isEmpty() ? null : ChargeStatusType.fromValue(status);
            List<PaymentMethodType> pm = null;
            if (method != null && !method.isEmpty()) {
                PaymentMethodType p = PaymentMethodType.fromValue(method);
                if (p != null) pm = Arrays.asList(p);
            }
            // --- elepay SDK ---
            ChargesResponse resp = chargeApi.listCharges(pm, null, null, null, st, limit, 0, null, SortOrderType.DESC);
            model.addAttribute("total",   resp.getTotal());
            model.addAttribute("charges", resp.getCharges());
        } catch (ApiException e) {
            model.addAttribute("error", "HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        model.addAttribute("statuses", ChargeStatusType.values());
        model.addAttribute("methods",  METHODS);
        model.addAttribute("status",   status);
        model.addAttribute("method",   method);
        model.addAttribute("limit",    limit);
        return "charges";
    }

    /**
     * Landing point after a redirect-based payment (we seeded
     * {@code frontUrl=/return?orderNo=…} in the charge's extras). Reconciles
     * on arrival so the UI reflects the new status immediately, without
     * waiting on the webhook round-trip.
     */
    @GetMapping("/return")
    public String onReturn(HttpServletRequest request, RedirectAttributes flash) {
        String chargeId = firstValue(request, "chargeId");
        String orderNo  = firstValue(request, "orderNo");
        Order o = null;
        if (chargeId != null) o = orders.getByResourceId(chargeId);
        if (o == null && orderNo != null) o = orders.getByOrderNo(orderNo);
        if (o == null) {
            flash.addFlashAttribute("error",
                    "/return hit but no local record (chargeId=" + chargeId + ", orderNo=" + orderNo + ")");
            return "redirect:/";
        }
        try {
            if (o.getType() == OrderType.CHARGE) {
                // --- elepay SDK ---
                ChargeDto fresh = chargeApi.retrieveCharge(o.getElepayResourceId());
                orders.applyRefresh(o.getOrderNo(), fresh.getStatus(), "return", orders.toJson(fresh));
                flash.addFlashAttribute("info",
                        "back from payment — " + o.getOrderNo() + " status=" + fresh.getStatus());
            }
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "return reconcile failed: HTTP " + e.getCode());
        }
        return "redirect:/orders/" + o.getOrderNo();
    }

    private Order mustCharge(String orderNo, RedirectAttributes flash) {
        Order o = orders.getByOrderNo(orderNo);
        if (o == null || o.getType() != OrderType.CHARGE) {
            flash.addFlashAttribute("error", "no charge order: " + orderNo);
            return null;
        }
        return o;
    }

    private static String firstValue(HttpServletRequest r, String name) {
        String[] values = r.getParameterValues(name);
        if (values == null || values.length == 0) return null;
        String v = values[0];
        return (v == null || v.isEmpty()) ? null : v;
    }

    private static String emptyToNull(String s) { return s == null || s.isEmpty() ? null : s; }
    private static String orElse(String v, String fallback) { return v == null || v.isEmpty() ? fallback : v; }

    private static String baseUrl(HttpServletRequest r) {
        StringBuffer url = r.getRequestURL();
        int schemeEnd = url.indexOf("://");
        int hostEnd = url.indexOf("/", schemeEnd + 3);
        return hostEnd > 0 ? url.substring(0, hostEnd) : url.toString();
    }

    private static String clientIp(HttpServletRequest request) {
        String forwarded = request.getHeader("X-Forwarded-For");
        if (forwarded != null && !forwarded.isEmpty()) {
            int comma = forwarded.indexOf(',');
            return (comma > 0 ? forwarded.substring(0, comma) : forwarded).trim();
        }
        return request.getRemoteAddr();
    }

    private static String mask(String token) {
        if (token == null || token.isEmpty()) return "(not set)";
        if (token.length() < 12) return "***";
        int underscore = token.indexOf('_', 3);
        String prefix = (underscore > 0 ? token.substring(0, underscore + 1) : token.substring(0, 8));
        return prefix + "…" + token.substring(token.length() - 4);
    }
}
