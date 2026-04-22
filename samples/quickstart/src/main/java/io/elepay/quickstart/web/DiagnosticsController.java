package io.elepay.quickstart.web;

import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.api.CodeSettingApi;
import io.elepay.client.charge.api.DisputeApi;
import io.elepay.client.charge.api.PaymentMethodApi;
import io.elepay.client.charge.api.TerminalApi;
import io.elepay.client.charge.pojo.CodePaymentMethodResponse;
import io.elepay.client.charge.pojo.DisputesResponse;
import io.elepay.client.charge.pojo.LocationsResponse;
import io.elepay.client.charge.pojo.PaymentMethodResponse;
import io.elepay.client.charge.pojo.TerminalReadersResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Read-only panels for APIs that are either configuration (PaymentMethod,
 * CodeSetting), rare-in-sandbox (Dispute), or hardware-dependent (Terminal).
 * All four rendered on one page so operators can eyeball the account state
 * without digging through controllers.
 */
@Controller
public class DiagnosticsController {

    private final PaymentMethodApi paymentMethodApi;
    private final CodeSettingApi codeSettingApi;
    private final DisputeApi disputeApi;
    private final TerminalApi terminalApi;

    public DiagnosticsController(PaymentMethodApi paymentMethodApi, CodeSettingApi codeSettingApi,
                                 DisputeApi disputeApi, TerminalApi terminalApi) {
        this.paymentMethodApi = paymentMethodApi;
        this.codeSettingApi   = codeSettingApi;
        this.disputeApi       = disputeApi;
        this.terminalApi      = terminalApi;
    }

    @GetMapping("/diagnostics")
    public String page(@RequestParam(required = false) String disputeChargeId, Model model) {
        try {
            // --- elepay SDK ---
            PaymentMethodResponse pm = paymentMethodApi.listPaymentMethods();
            model.addAttribute("pm", pm.getPaymentMethods());
        } catch (ApiException e) {
            model.addAttribute("pmError", httpErr(e));
        }
        try {
            // --- elepay SDK ---
            CodePaymentMethodResponse cpm = codeSettingApi.listCodePaymentMethods();
            model.addAttribute("cpm", cpm.getPaymentMethods());
        } catch (ApiException e) {
            model.addAttribute("cpmError", httpErr(e));
        }
        try {
            // --- elepay SDK ---
            DisputesResponse dr = disputeApi.listDisputes(
                    disputeChargeId == null || disputeChargeId.isEmpty() ? null : disputeChargeId,
                    null, null, null, null, 20, 0, null, null);
            model.addAttribute("disputes",     dr.getDisputes());
            model.addAttribute("disputeTotal", dr.getTotal());
        } catch (ApiException e) {
            model.addAttribute("disputeError", httpErr(e));
        }
        try {
            // --- elepay SDK ---
            TerminalReadersResponse rr = terminalApi.listReaders(20, 0);
            model.addAttribute("readers",     rr.getReaders());
            model.addAttribute("readerTotal", rr.getTotal());
        } catch (ApiException e) {
            model.addAttribute("readerError", httpErr(e));
        }
        try {
            // --- elepay SDK ---
            LocationsResponse lr = terminalApi.listLocations();
            model.addAttribute("terminalLocations", lr.getLocations());
        } catch (ApiException e) {
            model.addAttribute("terminalLocationError", httpErr(e));
        }
        model.addAttribute("disputeChargeId", disputeChargeId);
        return "diagnostics";
    }

    private static String httpErr(ApiException e) {
        return "HTTP " + e.getCode() + ": " + e.getResponseBody();
    }
}
