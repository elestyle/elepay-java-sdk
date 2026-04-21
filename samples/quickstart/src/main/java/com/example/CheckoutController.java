package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

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
            Map<String, String> extra = new HashMap<>();
            // web-resource charges require the end user's browser UA for device fingerprinting.
            String ua = request.getHeader("User-Agent");
            extra.put("userAgent", ua == null ? "demo/unknown" : ua);

            ChargeReq req = new ChargeReq()
                    .amount(amount)
                    .currency(currency)
                    .paymentMethod(PaymentMethodType.fromValue(paymentMethod))
                    .resource(ResourceType.WEB)
                    .orderNo("demo-" + System.currentTimeMillis())
                    .description("elepay-java-sdk quickstart demo")
                    .extra(extra)
                    .clientIp(clientIp(request));
            ChargeDto charge = chargeApi.createCharge(req);
            tracker.track(charge);
            flash.addFlashAttribute("charge", charge);
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "HTTP " + e.getCode() + ": " + e.getResponseBody());
        } catch (Exception e) {
            flash.addFlashAttribute("error", e.getClass().getSimpleName() + ": " + e.getMessage());
        }
        return "redirect:/";
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
