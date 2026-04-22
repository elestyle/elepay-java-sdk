package io.elepay.quickstart.web;

import java.util.List;

import io.elepay.quickstart.domain.Order;
import io.elepay.quickstart.domain.OrderType;
import io.elepay.quickstart.repository.EventLog;
import io.elepay.quickstart.repository.OrderRepository;

import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.api.ChargeApi;
import io.elepay.client.charge.api.RefundApi;
import io.elepay.client.charge.pojo.ChargeDto;
import io.elepay.client.charge.pojo.RefundDto;
import io.elepay.client.charge.pojo.RefundReq;
import io.elepay.client.charge.pojo.RefundsResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Demonstrates {@link RefundApi}. Refunds always belong to a charge order —
 * other order types (code / subscription) map to their own refund-like
 * flows via their APIs.
 */
@Controller
public class RefundController {

    private final RefundApi refundApi;
    private final ChargeApi chargeApi;
    private final OrderRepository orders;
    private final EventLog events;

    public RefundController(RefundApi refundApi, ChargeApi chargeApi,
                            OrderRepository orders, EventLog events) {
        this.refundApi = refundApi;
        this.chargeApi = chargeApi;
        this.orders    = orders;
        this.events    = events;
    }

    @PostMapping("/refunds/create")
    public String create(@RequestParam String orderNo,
                         @RequestParam(required = false) Integer amount,
                         @RequestParam(required = false) String reason,
                         RedirectAttributes flash) {
        Order o = mustCharge(orderNo, flash);
        if (o == null) return "redirect:/orders";
        try {
            RefundReq req = new RefundReq();
            if (amount != null) req.setAmount(amount);
            if (reason != null && !reason.isEmpty()) req.setReason(reason);
            // --- elepay SDK ---
            RefundDto refund = refundApi.createRefund(o.getElepayResourceId(), req);
            o.recordRefund(refund);
            // A refund mutates the charge status — fetch the fresh charge.
            // --- elepay SDK ---
            ChargeDto fresh = chargeApi.retrieveCharge(o.getElepayResourceId());
            orders.applyRefresh(orderNo, fresh.getStatus(), "action", orders.toJson(fresh));
            events.record(EventLog.Entry.action("charge." + orderNo,
                    "createRefund: " + refund.getId() + " amount=" + refund.getAmount(),
                    orders.toJson(refund)));
            flash.addFlashAttribute("info",
                    "refund " + refund.getId() + " created (status=" + refund.getStatus() + ")");
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "createRefund HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        return "redirect:/orders/" + orderNo;
    }

    /** Re-pull the charge's refund list and replace the local copy. */
    @PostMapping("/refunds/sync")
    public String sync(@RequestParam String orderNo, RedirectAttributes flash) {
        Order o = mustCharge(orderNo, flash);
        if (o == null) return "redirect:/orders";
        try {
            // --- elepay SDK ---
            RefundsResponse resp = refundApi.listChargesRefunds(o.getElepayResourceId());
            List<RefundDto> list = resp.getRefunds();
            o.replaceRefunds(list);
            events.record(EventLog.Entry.refresh("charge." + orderNo,
                    "listChargesRefunds: " + (list == null ? 0 : list.size()) + " rows",
                    orders.toJson(resp)));
            flash.addFlashAttribute("info",
                    "synced " + (list == null ? 0 : list.size()) + " refunds");
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "listChargesRefunds HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        return "redirect:/orders/" + orderNo;
    }

    private Order mustCharge(String orderNo, RedirectAttributes flash) {
        Order o = orders.getByOrderNo(orderNo);
        if (o == null || o.getType() != OrderType.CHARGE) {
            flash.addFlashAttribute("error", "refunds only apply to charge orders: " + orderNo);
            return null;
        }
        return o;
    }
}
