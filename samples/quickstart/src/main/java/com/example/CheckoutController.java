package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.ClientVersion;
import io.elepay.client.charge.api.ChargeApi;
import io.elepay.client.charge.pojo.ChargeDto;
import io.elepay.client.charge.pojo.ChargeReq;
import io.elepay.client.charge.pojo.PaymentMethodType;
import io.elepay.client.charge.pojo.ResourceType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    private final ChargeTracker tracker;
    private final ObjectMapper mapper = new ObjectMapper();

    public CheckoutController(ChargeApi chargeApi, ElepayProperties props, ChargeTracker tracker) {
        this.chargeApi = chargeApi;
        this.props = props;
        this.tracker = tracker;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("paymentMethods", METHODS);
        model.addAttribute("sdkVersion", ClientVersion.VERSION);
        model.addAttribute("userAgent", ClientVersion.userAgent());
        model.addAttribute("maskedKey", mask(props.getSecretKey()));
        model.addAttribute("publishableKey", props.getPublishableKey());
        model.addAttribute("hasPublishableKey", !props.getPublishableKey().isEmpty()
                && !props.getPublishableKey().startsWith("pk_test_your_"));
        model.addAttribute("hasWebhookSecret", !props.getWebhookSigningSecret().isEmpty());
        model.addAttribute("trackedCharges", tracker.recent());
        return "index";
    }

    @PostMapping("/checkout")
    public String checkout(@RequestParam int amount,
                           @RequestParam(defaultValue = "JPY") String currency,
                           @RequestParam String paymentMethod,
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
            // web-resource charges require the end user's browser UA for device fingerprinting.
            String ua = request.getHeader("User-Agent");
            extra.put("userAgent", ua == null ? "demo/unknown" : ua);
            // After the buyer completes payment at a redirect-based method (alipay,
            // paypal, hosted checkout…), elepay sends them back here. We carry our
            // orderNo in the query string so /return can reconcile without guessing.
            extra.put("frontUrl", baseUrl(request) + "/return?orderNo=" + orderNo);

            ChargeReq req = new ChargeReq()
                    .amount(amount)
                    .currency(currency)
                    .paymentMethod(method)
                    .resource(ResourceType.WEB)
                    .orderNo(orderNo)
                    .description("elepay-java-sdk quickstart demo")
                    .extra(extra)
                    .clientIp(clientIp(request));
            ChargeDto charge = chargeApi.createCharge(req);
            tracker.track(charge);
            flash.addFlashAttribute("charge", charge);
            // Serialized form is handed to the browser; elepay.js consumes the same
            // JSON shape the REST API produced.
            flash.addFlashAttribute("chargeJson", mapper.writeValueAsString(charge));
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "HTTP " + e.getCode() + ": " + e.getResponseBody());
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getClass().getSimpleName() + ": " + e.getMessage());
        }
        return "redirect:/";
    }

    /**
     * On-demand reconciliation: button on each row in the index page.
     * Hits {@code retrieveCharge} once, updates the tracker record, redirects back.
     */
    @PostMapping("/refresh/{id}")
    public String refresh(@PathVariable String id, RedirectAttributes flash) {
        try {
            ChargeTracker.Tracked updated = tracker.refresh(id);
            if (updated == null) {
                flash.addFlashAttribute("error", "unknown charge id: " + id);
            } else {
                flash.addFlashAttribute("info",
                        "refreshed " + id + " — status=" + updated.getStatus());
            }
        } catch (ApiException e) {
            flash.addFlashAttribute("error",
                    "refresh failed: HTTP " + e.getCode() + " " + e.getMessage());
        }
        return "redirect:/";
    }

    /**
     * Landing endpoint that elepay redirects the buyer back to after payment
     * (the {@code frontUrl} we set in {@code extra} at charge creation time).
     * We reconcile on arrival so the UI immediately shows the new status
     * instead of waiting on the webhook round-trip.
     *
     * <p>elepay appends its own query params on the redirect (notably
     * {@code chargeId} and {@code orderNo}). Since we also seed {@code orderNo}
     * into the URL ourselves, Spring sees it twice — take the first value.
     */
    @GetMapping("/return")
    public String onReturn(HttpServletRequest request, RedirectAttributes flash) {
        String chargeId = firstValue(request, "chargeId");
        String orderNo = firstValue(request, "orderNo");

        ChargeTracker.Tracked t = null;
        if (chargeId != null) t = tracker.get(chargeId);
        if (t == null && orderNo != null) t = tracker.findByOrderNo(orderNo);
        if (t == null) {
            flash.addFlashAttribute("error",
                    "/return hit but no local record (chargeId=" + chargeId + ", orderNo=" + orderNo + ")");
            return "redirect:/";
        }
        try {
            ChargeTracker.Tracked updated = tracker.refreshOnReturn(t.getId());
            flash.addFlashAttribute("info",
                    "back from payment — " + t.getId() + " status=" + updated.getStatus());
        } catch (ApiException e) {
            flash.addFlashAttribute("error",
                    "return reconcile failed: HTTP " + e.getCode() + " " + e.getMessage());
        }
        return "redirect:/";
    }

    private static String firstValue(HttpServletRequest r, String name) {
        String[] values = r.getParameterValues(name);
        if (values == null || values.length == 0) return null;
        String v = values[0];
        return (v == null || v.isEmpty()) ? null : v;
    }

    private static String baseUrl(HttpServletRequest r) {
        StringBuffer url = r.getRequestURL();
        // r.getRequestURL() includes the full /checkout path; trim to scheme://host[:port]
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
