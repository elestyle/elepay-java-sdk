package io.elepay.quickstart.web;

import java.util.HashMap;
import java.util.Map;

import io.elepay.quickstart.config.ElepayProperties;
import io.elepay.quickstart.domain.Order;
import io.elepay.quickstart.domain.OrderType;
import io.elepay.quickstart.repository.CustomerRepository;
import io.elepay.quickstart.repository.EventLog;
import io.elepay.quickstart.repository.OrderRepository;

import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.api.CodeApi;
import io.elepay.client.charge.api.CustomerApi;
import io.elepay.client.charge.pojo.CodeDto;
import io.elepay.client.charge.pojo.CodeReq;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Demonstrates {@link CodeApi}: dynamic QR / EasyCheckout codes. The merchant
 * can optionally bind the code to a customer + stored source so payment
 * reuses saved credentials, and can set {@code shouldCreateSource} so the
 * completed payment leaves behind a reusable source.
 *
 * <p>On create, the returned {@link CodeDto} id is handed to the browser so
 * {@code elepay.js}'s {@code checkout(codeId)} can open the hosted
 * EasyCheckout UI.
 */
@Controller
public class CodeController {

    private final CodeApi codeApi;
    private final CustomerApi customerApi;
    private final OrderRepository orders;
    private final CustomerRepository customers;
    private final EventLog events;
    private final ElepayProperties props;

    public CodeController(CodeApi codeApi, CustomerApi customerApi,
                          OrderRepository orders, CustomerRepository customers,
                          EventLog events, ElepayProperties props) {
        this.codeApi     = codeApi;
        this.customerApi = customerApi;
        this.orders      = orders;
        this.customers   = customers;
        this.events      = events;
        this.props       = props;
    }

    @GetMapping("/codes")
    public String page(Model model) {
        model.addAttribute("orders", orders.recent().stream()
                .filter(o -> o.getType() == OrderType.CODE).toList());
        model.addAttribute("customers", remoteCustomers());
        return "codes";
    }

    @PostMapping("/codes/new")
    public String create(@RequestParam int amount,
                         @RequestParam(defaultValue = "JPY") String currency,
                         @RequestParam(required = false) String customerId,
                         @RequestParam(required = false) String sourceId,
                         @RequestParam(defaultValue = "false") boolean shouldCreateSource,
                         @RequestParam(required = false) Integer expiryDuration,
                         HttpServletRequest request,
                         RedirectAttributes flash) {
        try {
            String orderNo = "code-" + System.currentTimeMillis();
            Map<String, String> extra = new HashMap<>();
            extra.put("userAgent", orElse(request.getHeader("User-Agent"), "demo/unknown"));
            CodeReq req = new CodeReq()
                    .amount(amount)
                    .currency(currency)
                    .orderNo(orderNo)
                    .description("elepay-java-sdk quickstart code")
                    .extra(extra)
                    .frontUrl(baseUrl(request) + "/orders/" + orderNo);
            if (expiryDuration != null) req.setExpiryDuration(expiryDuration);
            if (customerId != null && !customerId.isEmpty()) req.setCustomerId(customerId);
            if (sourceId   != null && !sourceId.isEmpty())   req.setSourceId(sourceId);
            if (shouldCreateSource) req.setShouldCreateSource(true);

            // --- elepay SDK ---
            CodeDto code = codeApi.createCode(req);

            Order o = orders.registerCode(orderNo, code, emptyToNull(customerId));
            flash.addFlashAttribute("info", "code " + code.getId()
                    + " · handing off to elepay.checkout(codeId)");
            flash.addFlashAttribute("codeJson", orders.toJson(code));
            flash.addFlashAttribute("codeId",   code.getId());
            flash.addFlashAttribute("codeUrl",  code.getCodeUrl());
            flash.addFlashAttribute("publishableKey", props.getPublishableKey());
            flash.addFlashAttribute("hasPublishableKey", !props.getPublishableKey().isEmpty()
                    && !props.getPublishableKey().startsWith("pk_test_your_"));
            return "redirect:/orders/" + o.getOrderNo();
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "createCode HTTP " + e.getCode() + ": " + e.getResponseBody());
            return "redirect:/codes";
        }
    }

    @PostMapping("/codes/{orderNo}/refresh")
    public String refresh(@PathVariable String orderNo, RedirectAttributes flash) {
        Order o = mustCode(orderNo, flash);
        if (o == null) return "redirect:/codes";
        try {
            // --- elepay SDK ---
            CodeDto fresh = codeApi.retrieveCode(o.getElepayResourceId());
            orders.applyRefresh(orderNo, fresh.getStatus(), "refresh", orders.toJson(fresh));
            flash.addFlashAttribute("info", "refreshed code status=" + fresh.getStatus());
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "retrieveCode HTTP " + e.getCode());
        }
        return "redirect:/orders/" + orderNo;
    }

    @PostMapping("/codes/{orderNo}/close")
    public String close(@PathVariable String orderNo, RedirectAttributes flash) {
        Order o = mustCode(orderNo, flash);
        if (o == null) return "redirect:/codes";
        try {
            // --- elepay SDK ---
            codeApi.closeCode(o.getElepayResourceId());
            // --- elepay SDK ---
            CodeDto after = codeApi.retrieveCode(o.getElepayResourceId());
            orders.applyRefresh(orderNo, after.getStatus(), "action", orders.toJson(after));
            events.record(EventLog.Entry.action("code." + orderNo,
                    "closeCode: " + o.getElepayResourceId(), orders.toJson(after)));
            flash.addFlashAttribute("info", "closed code; status=" + after.getStatus());
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "closeCode HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        return "redirect:/orders/" + orderNo;
    }

    private Order mustCode(String orderNo, RedirectAttributes flash) {
        Order o = orders.getByOrderNo(orderNo);
        if (o == null || o.getType() != OrderType.CODE) {
            flash.addFlashAttribute("error", "no code order: " + orderNo);
            return null;
        }
        return o;
    }

    /**
     * Best-effort fetch of remote customers for the "attach to user" selector.
     * Falls back to the local {@link CustomerRepository} snapshot if the API
     * is unreachable. Returns a list of {@code {id, label}} pairs rendered by
     * Thymeleaf.
     */
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

    private static String emptyToNull(String s) { return s == null || s.isEmpty() ? null : s; }
    private static String orElse(String v, String fallback) { return v == null || v.isEmpty() ? fallback : v; }
    private static String baseUrl(HttpServletRequest r) {
        StringBuffer url = r.getRequestURL();
        int schemeEnd = url.indexOf("://");
        int hostEnd = url.indexOf("/", schemeEnd + 3);
        return hostEnd > 0 ? url.substring(0, hostEnd) : url.toString();
    }
}
