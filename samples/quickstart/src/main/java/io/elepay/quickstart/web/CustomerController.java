package io.elepay.quickstart.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.elepay.quickstart.config.ElepayProperties;
import io.elepay.quickstart.domain.Customer;
import io.elepay.quickstart.repository.CustomerRepository;
import io.elepay.quickstart.repository.EventLog;
import io.elepay.quickstart.repository.OrderRepository;

import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.api.CustomerApi;
import io.elepay.client.charge.pojo.CustomerDto;
import io.elepay.client.charge.pojo.CustomerReq;
import io.elepay.client.charge.pojo.CustomerResponse;
import io.elepay.client.charge.pojo.CustomerUpdateReq;
import io.elepay.client.charge.pojo.PaymentMethodType;
import io.elepay.client.charge.pojo.ResourceType;
import io.elepay.client.charge.pojo.SourceDto;
import io.elepay.client.charge.pojo.SourceReq;
import io.elepay.client.charge.pojo.SourceResponse;
import io.elepay.client.charge.pojo.SourceStatusDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Demonstrates {@link CustomerApi} — including the Source sub-API (sources
 * hang off the customer endpoint in this SDK rather than living in a
 * separate API class).
 *
 * <p>Each elepay {@link CustomerDto} is mirrored locally as a
 * {@link Customer} so we can group orders and stored sources by customer
 * without re-paging the API on every render.
 *
 * <p>On create, the returned {@link SourceDto} is handed to the browser so
 * {@code elepay.js}'s {@code handleSource(sourceDto)} can drive the
 * activation flow (3DS, redirect, wallet confirmation, …).
 */
@Controller
public class CustomerController {

    private final CustomerApi customerApi;
    private final CustomerRepository customers;
    private final OrderRepository orders;
    private final EventLog events;
    private final ElepayProperties props;

    public CustomerController(CustomerApi customerApi, CustomerRepository customers,
                              OrderRepository orders, EventLog events, ElepayProperties props) {
        this.customerApi = customerApi;
        this.customers   = customers;
        this.orders      = orders;
        this.events      = events;
        this.props       = props;
    }

    @GetMapping("/customers")
    public String list(@RequestParam(required = false) String keyword,
                       @RequestParam(defaultValue = "20") int limit,
                       Model model) {
        model.addAttribute("localCustomers", customers.all());
        try {
            // --- elepay SDK ---
            CustomerResponse remote = customerApi.listCustomers(
                    keyword == null || keyword.isEmpty() ? null : keyword, limit, 0);
            model.addAttribute("remoteTotal", remote.getTotal());
            model.addAttribute("remoteCustomers", remote.getCustomers());
        } catch (ApiException e) {
            model.addAttribute("error", "listCustomers HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        model.addAttribute("keyword", keyword);
        model.addAttribute("limit",   limit);
        return "customers";
    }

    @PostMapping("/customers/new")
    public String create(@RequestParam String name,
                         @RequestParam(required = false) String email,
                         @RequestParam(required = false) String phone,
                         @RequestParam(required = false) String description,
                         RedirectAttributes flash) {
        try {
            CustomerReq req = new CustomerReq()
                    .name(name).email(email).phone(phone).description(description);
            // --- elepay SDK ---
            CustomerDto created = customerApi.createCustomer(req);
            customers.register(new Customer(created.getId(), created.getName(), created.getEmail()));
            events.record(EventLog.Entry.create("customer." + created.getId(),
                    "createCustomer: " + created.getId(),
                    orders.toJson(created)));
            flash.addFlashAttribute("info", "created customer " + created.getId());
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "createCustomer HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        return "redirect:/customers";
    }

    @GetMapping("/customers/{id}")
    public String detail(@PathVariable String id, Model model) {
        model.addAttribute("localCustomer", customers.get(id));
        try {
            // --- elepay SDK ---
            CustomerDto remote = customerApi.retrieveCustomer(id);
            model.addAttribute("remote", remote);
            model.addAttribute("remoteJson", orders.toJson(remote));
            // --- elepay SDK ---
            SourceResponse sources = customerApi.listSources(id, null);
            model.addAttribute("sources", sources.getSources());
        } catch (ApiException e) {
            model.addAttribute("error", "HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        model.addAttribute("orders", orders.byCustomer(id));
        model.addAttribute("paymentMethods", List.of(
                PaymentMethodType.ALIPAY, PaymentMethodType.WECHATPAY,
                PaymentMethodType.PAYPAY, PaymentMethodType.LINEPAY,
                PaymentMethodType.CREDITCARD));
        return "customer_detail";
    }

    @PostMapping("/customers/{id}/update")
    public String update(@PathVariable String id,
                         @RequestParam(required = false) String name,
                         @RequestParam(required = false) String email,
                         @RequestParam(required = false) String phone,
                         @RequestParam(required = false) String description,
                         @RequestParam(required = false) String defaultSource,
                         RedirectAttributes flash) {
        try {
            CustomerUpdateReq req = new CustomerUpdateReq()
                    .name(name).email(email).phone(phone).description(description);
            if (defaultSource != null && !defaultSource.isEmpty()) req.setDefaultSource(defaultSource);
            // --- elepay SDK ---
            CustomerDto updated = customerApi.updateCustomer(id, req);
            events.record(EventLog.Entry.action("customer." + id,
                    "updateCustomer: " + id, orders.toJson(updated)));
            flash.addFlashAttribute("info", "updated customer " + id);
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "updateCustomer HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        return "redirect:/customers/" + id;
    }

    @PostMapping("/customers/{id}/delete")
    public String delete(@PathVariable String id, RedirectAttributes flash) {
        try {
            // --- elepay SDK ---
            customerApi.deleteCustomer(id);
            customers.remove(id);
            events.record(EventLog.Entry.action("customer." + id, "deleteCustomer: " + id, ""));
            flash.addFlashAttribute("info", "deleted customer " + id);
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "deleteCustomer HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        return "redirect:/customers";
    }

    @PostMapping("/customers/{id}/sources/new")
    public String createSource(@PathVariable String id,
                               @RequestParam String paymentMethod,
                               @RequestParam(required = false) String description,
                               HttpServletRequest request,
                               RedirectAttributes flash) {
        try {
            PaymentMethodType method = PaymentMethodType.fromValue(paymentMethod);
            if (method == null) {
                flash.addFlashAttribute("error", "unsupported paymentMethod: " + paymentMethod);
                return "redirect:/customers/" + id;
            }
            Map<String, String> extra = new HashMap<>();
            extra.put("userAgent", orElse(request.getHeader("User-Agent"), "demo/unknown"));
            extra.put("frontUrl",  baseUrl(request) + "/customers/" + id + "/sources/returned");
            SourceReq req = new SourceReq()
                    .paymentMethod(method)
                    .resource(ResourceType.WEB)
                    .description(description)
                    .extra(extra);
            // --- elepay SDK ---
            SourceDto created = customerApi.createSource(id, req);

            Customer c = customers.get(id);
            if (c != null) c.addSource(created.getId());
            events.record(EventLog.Entry.action("customer." + id,
                    "createSource: " + created.getId() + " status=" + created.getStatus(),
                    orders.toJson(created)));
            flash.addFlashAttribute("info", "source " + created.getId()
                    + " created — status=" + created.getStatus()
                    + " · handing off to elepay.handleSource(...)");
            flash.addFlashAttribute("sourceJson", orders.toJson(created));
            flash.addFlashAttribute("publishableKey", props.getPublishableKey());
            flash.addFlashAttribute("hasPublishableKey", !props.getPublishableKey().isEmpty()
                    && !props.getPublishableKey().startsWith("pk_test_your_"));
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "createSource HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        return "redirect:/customers/" + id;
    }

    /**
     * Source detail page. This is where the "charge with this source" entry
     * lives — bundling the source state, its activation status, and the
     * settle-now form into one place keeps the UX unambiguous (a plain
     * "optional customer" selector on the anonymous checkout form was
     * misleading — not selecting ≠ anonymous).
     */
    @GetMapping("/customers/{id}/sources/{sid}")
    public String sourceDetail(@PathVariable String id, @PathVariable String sid, Model model) {
        try {
            // --- elepay SDK ---
            SourceDto src = customerApi.retrieveSource(id, sid);
            model.addAttribute("source", src);
            model.addAttribute("sourceJsonView", orders.toJson(src));
        } catch (ApiException e) {
            model.addAttribute("error", "retrieveSource HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        try {
            // --- elepay SDK ---
            SourceStatusDto st = customerApi.retrieveSourceStatus(sid);
            model.addAttribute("sourceStatus", st);
        } catch (ApiException e) {
            model.addAttribute("statusError", "retrieveSourceStatus HTTP " + e.getCode());
        }
        model.addAttribute("customerId", id);
        model.addAttribute("sourceId",   sid);
        return "source_detail";
    }

    @PostMapping("/customers/{id}/sources/{sid}/refresh")
    public String refreshSourceStatus(@PathVariable String id, @PathVariable String sid,
                                      RedirectAttributes flash) {
        try {
            // --- elepay SDK ---
            SourceStatusDto st = customerApi.retrieveSourceStatus(sid);
            events.record(EventLog.Entry.refresh("customer." + id,
                    "retrieveSourceStatus: " + sid + " -> " + st.getStatus(),
                    orders.toJson(st)));
            flash.addFlashAttribute("info", "source " + sid + " status=" + st.getStatus());
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        return "redirect:/customers/" + id + "/sources/" + sid;
    }

    @PostMapping("/customers/{id}/sources/{sid}/delete")
    public String deleteSource(@PathVariable String id, @PathVariable String sid,
                               RedirectAttributes flash) {
        try {
            // --- elepay SDK ---
            customerApi.deleteSource(id, sid);
            Customer c = customers.get(id);
            if (c != null) c.removeSource(sid);
            events.record(EventLog.Entry.action("customer." + id, "deleteSource: " + sid, ""));
            flash.addFlashAttribute("info", "deleted source " + sid);
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        return "redirect:/customers/" + id;
    }

    /** Landing endpoint the buyer is redirected to after source-activation
     *  (e.g. 3DS challenge). Does nothing beyond prompting the operator to
     *  call {@code retrieveSourceStatus} to reconcile. */
    @GetMapping("/customers/{id}/sources/returned")
    public String onSourceReturn(@PathVariable String id, RedirectAttributes flash) {
        flash.addFlashAttribute("info",
                "back from source activation — click retrieveSourceStatus on the row to reconcile");
        return "redirect:/customers/" + id;
    }

    private static String orElse(String v, String fallback) {
        return v == null || v.isEmpty() ? fallback : v;
    }

    private static String baseUrl(HttpServletRequest r) {
        StringBuffer url = r.getRequestURL();
        int schemeEnd = url.indexOf("://");
        int hostEnd = url.indexOf("/", schemeEnd + 3);
        return hostEnd > 0 ? url.substring(0, hostEnd) : url.toString();
    }
}
