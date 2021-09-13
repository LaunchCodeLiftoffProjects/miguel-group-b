package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Location;
import org.launchcode.javawebdevtechjobsauthentication.models.Vendor;
import org.launchcode.javawebdevtechjobsauthentication.models.data.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;
@Controller
public class LocationController {

        @Autowired
        private LocationRepository locationRepository;

        @RequestMapping("/locations")
        public String index(Model model) {
            model.addAttribute("locations", locationRepository.findAll());
            return "locations/index";
        }

        @GetMapping("add")
        public String displayAddVendorForm( Model model) {
            model.addAttribute(new Location());
            return "add";
        }

        @PostMapping("add")
        public String processAddVendorForm(@ModelAttribute @Valid Location newLocation,
                                           Errors errors) {

            if (errors.hasErrors()) {
                return "add";
            }

            locationRepository.save(newLocation);
            return "redirect:";
        }

        @GetMapping("view/{LocationId}")
        public String displayViewVendor(Model model, @PathVariable int vendorId) {

            Optional optVendor = locationRepository.findById(vendorId);
            if (!optVendor.isEmpty()) {
                Vendor vendor = (Vendor) optVendor.get();
                model.addAttribute("vendor", vendor);
                return "view";
            } else {
                return "redirect:/";
            }
        }


    }


