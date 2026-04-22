package io.elepay.quickstart.domain;

/**
 * Merchant-side rollup of an {@link Order}'s state, decoupled from the raw
 * elepay status string returned by whichever API backs the order.
 *
 * <p>The raw elepay status is kept on {@link Order#getRawStatus()} for
 * debugging; this enum is what the UI groups by and what downstream business
 * code (fulfilment, accounting) should switch on.
 */
public enum OrderStatus {
    PENDING,
    AUTHORIZED,
    PAID,
    PARTIALLY_REFUNDED,
    REFUNDED,
    CANCELED,
    FAILED,
    UNKNOWN;

    /** Map a raw elepay status string to this rollup, interpreted per order type. */
    public static OrderStatus from(OrderType type, String elepayStatus) {
        if (elepayStatus == null) return UNKNOWN;
        switch (type) {
            case CHARGE:       return fromCharge(elepayStatus);
            case CODE:         return fromCode(elepayStatus);
            case SUBSCRIPTION: return fromSubscription(elepayStatus);
            default:           return UNKNOWN;
        }
    }

    private static OrderStatus fromCharge(String s) {
        switch (s) {
            case "pending":
            case "waiting":
            case "notified":           return PENDING;
            case "uncaptured":         return AUTHORIZED;
            case "captured":           return PAID;
            case "partially_refunded": return PARTIALLY_REFUNDED;
            case "refunded":           return REFUNDED;
            case "revoked":            return CANCELED;
            case "failed":
            case "amount_mismatch":    return FAILED;
            default:                   return UNKNOWN;
        }
    }

    private static OrderStatus fromCode(String s) {
        switch (s) {
            case "pending":            return PENDING;
            case "captured":
            case "completed":          return PAID;
            case "closed":             return CANCELED;
            default:                   return UNKNOWN;
        }
    }

    private static OrderStatus fromSubscription(String s) {
        switch (s) {
            case "new":                return PENDING;
            case "active":             return PAID;
            case "past_due":           return FAILED;
            case "canceled":           return CANCELED;
            default:                   return UNKNOWN;
        }
    }
}
