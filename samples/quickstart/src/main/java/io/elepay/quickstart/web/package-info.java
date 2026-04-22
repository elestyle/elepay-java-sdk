/**
 * Spring MVC controllers. One controller per SDK API class so there is a 1:1
 * mapping an SDK user can follow:
 *
 * <ul>
 *   <li>{@link io.elepay.quickstart.web.CheckoutController}     — {@code ChargeApi}</li>
 *   <li>{@link io.elepay.quickstart.web.RefundController}       — {@code RefundApi}</li>
 *   <li>{@link io.elepay.quickstart.web.CustomerController}     — {@code CustomerApi} (customers + their sources)</li>
 *   <li>{@link io.elepay.quickstart.web.CodeController}         — {@code CodeApi} (EasyQR / EasyCheckout)</li>
 *   <li>{@link io.elepay.quickstart.web.SubscriptionController} — {@code SubscriptionApi}</li>
 *   <li>{@link io.elepay.quickstart.web.InvoiceController}      — {@code InvoiceApi}</li>
 *   <li>{@link io.elepay.quickstart.web.LocationController}     — {@code LocationApi}</li>
 *   <li>{@link io.elepay.quickstart.web.DiagnosticsController}  — {@code PaymentMethodApi}, {@code CodeSettingApi}, {@code DisputeApi}, {@code TerminalApi} (read-only)</li>
 *   <li>{@link io.elepay.quickstart.web.WebhookController}      — {@code Webhook.verifyHeader} and event routing to {@link io.elepay.quickstart.repository.OrderRepository}</li>
 *   <li>{@link io.elepay.quickstart.web.OrdersController}       — read-only list and detail views over merchant orders</li>
 *   <li>{@link io.elepay.quickstart.web.ApiExceptionAdvice}     — fallback handler for uncaught {@link io.elepay.client.charge.ApiException}</li>
 * </ul>
 *
 * <p>Each SDK call site in this package is prefixed with a
 * {@code // --- elepay SDK ---} marker to help readers scan.
 */
package io.elepay.quickstart.web;
