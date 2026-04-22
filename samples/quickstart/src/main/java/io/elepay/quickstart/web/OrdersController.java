package io.elepay.quickstart.web;

import io.elepay.quickstart.domain.Order;
import io.elepay.quickstart.repository.EventLog;
import io.elepay.quickstart.repository.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Read-only views of the merchant {@link OrderRepository}. Contains no SDK
 * calls — all state is local. Each action that mutates an order lives on
 * the controller for that order's underlying SDK API (Charge / Code /
 * Subscription / Invoice).
 */
@Controller
public class OrdersController {

    private final OrderRepository orders;
    private final EventLog events;

    public OrdersController(OrderRepository orders, EventLog events) {
        this.orders = orders;
        this.events = events;
    }

    @GetMapping("/orders")
    public String list(Model model) {
        model.addAttribute("orders", orders.recent());
        return "orders";
    }

    @GetMapping("/orders/{orderNo}")
    public String detail(@PathVariable String orderNo, Model model) {
        Order o = orders.getByOrderNo(orderNo);
        if (o == null) {
            model.addAttribute("notFound", orderNo);
            return "order_detail";
        }
        model.addAttribute("order", o);
        model.addAttribute("events",
                events.byTag(o.getType().name().toLowerCase() + "." + orderNo));
        return "order_detail";
    }
}
