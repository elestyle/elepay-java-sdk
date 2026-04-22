package io.elepay.quickstart.web;

import io.elepay.client.charge.ApiException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Fallback {@code @ControllerAdvice} for {@link ApiException} that escapes a
 * controller's local {@code try/catch}. Attaches the error as a flash message
 * and redirects back to the referring page — or to {@code /orders} if the
 * header is absent.
 *
 * <p>Most controllers still catch {@link ApiException} inline so they can
 * compose richer error messages ("refund failed:", "captureCharge HTTP …"),
 * which is what a real merchant service would do for user-facing flows. This
 * advice exists so less-critical list/read pages don't need boilerplate —
 * and so nothing reaches the default Spring error view.
 */
@ControllerAdvice
public class ApiExceptionAdvice {

    private static final Logger log = LoggerFactory.getLogger(ApiExceptionAdvice.class);

    @ExceptionHandler(ApiException.class)
    public String handle(ApiException e, HttpServletRequest req, RedirectAttributes flash) {
        String msg = "HTTP " + e.getCode() + ": " + e.getResponseBody();
        log.warn("[api] uncaught from {}: {}", req.getRequestURI(), msg);
        flash.addFlashAttribute("error", msg);
        String referer = req.getHeader("Referer");
        return "redirect:" + (referer != null && !referer.isEmpty() ? referer : "/orders");
    }
}
