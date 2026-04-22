/**
 * Configuration: binds {@code elepay.*} properties from {@code application.yaml}
 * and publishes every SDK API client as a Spring bean.
 *
 * <p>A real merchant service usually only needs a subset of these beans; keep
 * only the ones you call. All of them share a single {@link io.elepay.client.charge.ApiClient}
 * configured with the secret key from {@link io.elepay.quickstart.config.ElepayProperties}.
 */
package io.elepay.quickstart.config;
