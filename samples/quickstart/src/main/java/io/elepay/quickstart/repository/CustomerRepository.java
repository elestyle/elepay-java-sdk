package io.elepay.quickstart.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.elepay.quickstart.domain.Customer;
import org.springframework.stereotype.Repository;

/**
 * In-memory index of merchant {@link Customer} records keyed by the elepay
 * customer id. A real deployment would back this with Spring Data JPA or
 * similar; the interface would remain the same.
 */
@Repository
public class CustomerRepository {

    private final Map<String, Customer> byId = Collections.synchronizedMap(new LinkedHashMap<>());

    public void register(Customer customer) {
        if (customer != null && customer.getId() != null) {
            byId.put(customer.getId(), customer);
        }
    }

    public void remove(String id) { byId.remove(id); }

    public Customer get(String id) { return byId.get(id); }

    public List<Customer> all() {
        synchronized (byId) {
            List<Customer> list = new ArrayList<>(byId.values());
            Collections.reverse(list);
            return list;
        }
    }

    public int size() { return byId.size(); }
}
