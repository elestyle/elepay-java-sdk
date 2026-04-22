package io.elepay.quickstart.web;

import io.elepay.quickstart.repository.EventLog;
import io.elepay.quickstart.repository.OrderRepository;

import io.elepay.client.charge.ApiException;
import io.elepay.client.charge.api.LocationApi;
import io.elepay.client.charge.pojo.AddressDto;
import io.elepay.client.charge.pojo.AddressTransliterationDto;
import io.elepay.client.charge.pojo.ChargeLocationDto;
import io.elepay.client.charge.pojo.ChargeLocationReq;
import io.elepay.client.charge.pojo.ChargeLocationUpdateReq;
import io.elepay.client.charge.pojo.ChargeLocationsResponse;
import io.elepay.client.charge.pojo.StringTransliterationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Demonstrates {@link LocationApi} — charge-location CRUD. Name and address
 * are transliteration DTOs (kanji/kana/romaji); the form only exposes the
 * kanji slot for brevity.
 */
@Controller
public class LocationController {

    private final LocationApi locationApi;
    private final OrderRepository orders;
    private final EventLog events;

    public LocationController(LocationApi locationApi, OrderRepository orders, EventLog events) {
        this.locationApi = locationApi;
        this.orders      = orders;
        this.events      = events;
    }

    @GetMapping("/locations")
    public String page(Model model) {
        try {
            // --- elepay SDK ---
            ChargeLocationsResponse resp = locationApi.listChargeLocations(50, 0);
            model.addAttribute("locations", resp.getLocations());
            model.addAttribute("total",     resp.getTotal());
        } catch (ApiException e) {
            model.addAttribute("error", "listChargeLocations HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        return "locations";
    }

    @PostMapping("/locations/new")
    public String create(@RequestParam String name,
                         @RequestParam(required = false) String tel,
                         @RequestParam(required = false) String zip,
                         @RequestParam(required = false) String address,
                         @RequestParam(required = false) String note,
                         RedirectAttributes flash) {
        try {
            ChargeLocationReq req = new ChargeLocationReq()
                    .name(transliterate(name))
                    .tel(tel).zip(zip)
                    .address(addr(address))
                    .note(note);
            // --- elepay SDK ---
            ChargeLocationDto loc = locationApi.createChargeLocation(req);
            events.record(EventLog.Entry.create("location." + loc.getId(),
                    "createChargeLocation: " + loc.getId(), orders.toJson(loc)));
            flash.addFlashAttribute("info", "created location " + loc.getId());
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "createChargeLocation HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        return "redirect:/locations";
    }

    @PostMapping("/locations/{id}/update")
    public String update(@PathVariable String id,
                         @RequestParam String name,
                         @RequestParam(required = false) String tel,
                         @RequestParam(required = false) String zip,
                         @RequestParam(required = false) String address,
                         @RequestParam(required = false) String note,
                         RedirectAttributes flash) {
        try {
            ChargeLocationUpdateReq req = new ChargeLocationUpdateReq()
                    .name(transliterate(name))
                    .tel(tel).zip(zip)
                    .address(addr(address))
                    .note(note);
            // --- elepay SDK ---
            ChargeLocationDto loc = locationApi.updateChargeLocation(id, req);
            events.record(EventLog.Entry.action("location." + id,
                    "updateChargeLocation", orders.toJson(loc)));
            flash.addFlashAttribute("info", "updated location " + id);
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "updateChargeLocation HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        return "redirect:/locations";
    }

    @PostMapping("/locations/{id}/delete")
    public String delete(@PathVariable String id, RedirectAttributes flash) {
        try {
            // --- elepay SDK ---
            locationApi.deleteChargeLocation(id);
            events.record(EventLog.Entry.action("location." + id, "deleteChargeLocation: " + id, ""));
            flash.addFlashAttribute("info", "deleted location " + id);
        } catch (ApiException e) {
            flash.addFlashAttribute("error", "deleteChargeLocation HTTP " + e.getCode() + ": " + e.getResponseBody());
        }
        return "redirect:/locations";
    }

    private static StringTransliterationDto transliterate(String s) {
        if (s == null || s.isEmpty()) return null;
        return new StringTransliterationDto().kanji(s);
    }

    private static AddressTransliterationDto addr(String line) {
        if (line == null || line.isEmpty()) return null;
        AddressDto a = new AddressDto().address1(line);
        return new AddressTransliterationDto().kanji(a);
    }
}
