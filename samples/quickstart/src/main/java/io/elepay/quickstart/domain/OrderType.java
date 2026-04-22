package io.elepay.quickstart.domain;

/**
 * Which elepay primitive backs a given merchant-side {@link Order}.
 *
 * <p>The quickstart treats all four as interchangeable business units — they
 * all move an Order from {@code PENDING} to a terminal status. What differs
 * is which SDK API drives the lifecycle and which webhook event family feeds
 * status updates back.
 */
public enum OrderType {
    /** Single-shot payment via {@link io.elepay.client.charge.api.ChargeApi#createCharge}. */
    CHARGE,
    /** Dynamic QR / EasyCheckout via {@link io.elepay.client.charge.api.CodeApi#createCode}. */
    CODE,
    /** Recurring billing via {@link io.elepay.client.charge.api.SubscriptionApi#createSubscription}. */
    SUBSCRIPTION
}
