/**
 * Merchant-side aggregates that wrap elepay SDK DTOs.
 *
 * <p>The SDK is stateless — every {@code *Dto} is just the last response from
 * the API. A merchant backend needs longer-lived records that track business
 * identity and lifecycle. This package shows the minimum set:
 * <ul>
 *   <li>{@link io.elepay.quickstart.domain.Customer} — 1:1 with elepay
 *       {@code CustomerDto}; also tracks attached source ids and owned orders.</li>
 *   <li>{@link io.elepay.quickstart.domain.Order} — a business-level order that
 *       can be backed by any of Charge / Code / Subscription.</li>
 *   <li>{@link io.elepay.quickstart.domain.OrderType} / {@link io.elepay.quickstart.domain.OrderStatus}
 *       — the type tag and a rollup of the underlying elepay status strings.</li>
 * </ul>
 *
 * <p>Instances are plain POJOs with mutable state guarded by {@code synchronized}
 * collections; swap in JPA entities for a real deployment.
 */
package io.elepay.quickstart.domain;
