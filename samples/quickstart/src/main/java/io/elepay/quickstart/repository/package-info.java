/**
 * In-memory stores for the {@link io.elepay.quickstart.domain domain} aggregates.
 *
 * <p>All three are trivial {@code ConcurrentHashMap} / {@code ArrayDeque}
 * wrappers — state evaporates when the JVM exits. Swap them for Spring Data
 * repositories backed by a real database for production.
 *
 * <ul>
 *   <li>{@link io.elepay.quickstart.repository.CustomerRepository} — merchant
 *       customers, keyed by elepay customer id.</li>
 *   <li>{@link io.elepay.quickstart.repository.OrderRepository} — merchant
 *       orders keyed by orderNo, with a secondary index by elepay resource id
 *       so inbound webhooks can locate the right order in O(1).</li>
 *   <li>{@link io.elepay.quickstart.repository.EventLog} — a bounded ring buffer
 *       of notable events (create / webhook / action / refresh / reject) for
 *       the {@code /events} timeline.</li>
 * </ul>
 */
package io.elepay.quickstart.repository;
