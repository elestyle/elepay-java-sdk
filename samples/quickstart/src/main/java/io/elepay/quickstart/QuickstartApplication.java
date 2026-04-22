package io.elepay.quickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * Entry point for the elepay-java-sdk quickstart.
 *
 * <p>The application is deliberately layered in four packages so an SDK user
 * can open this project cold and map each SDK surface to a small number of
 * files:
 * <ul>
 *   <li>{@code config/}     — {@link io.elepay.quickstart.config.ElepayProperties}
 *       plus the single {@code @Configuration} that wires every SDK API bean.</li>
 *   <li>{@code domain/}     — merchant-side aggregates
 *       ({@code Customer}, {@code Order}) that wrap elepay DTOs.</li>
 *   <li>{@code repository/} — in-memory stores behind the aggregates
 *       ({@code CustomerRepository}, {@code OrderRepository}, {@code EventLog}).</li>
 *   <li>{@code web/}        — Spring MVC controllers. Each controller
 *       demonstrates exactly one SDK API class.</li>
 * </ul>
 */
@SpringBootApplication
@ConfigurationPropertiesScan
public class QuickstartApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuickstartApplication.class, args);
    }
}
