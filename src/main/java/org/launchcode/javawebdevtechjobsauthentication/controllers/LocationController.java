package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.data.LocationRepository;
import org.launchcode.javawebdevtechjobsauthentication.vendors.Location;
import org.launchcode.javawebdevtechjobsauthentication.vendors.Menu;
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

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("location", locationRepository.findAll());
        return "index";
    }

    @GetMapping("/addLocation")
    public String displayAddLocationForm( Model model) {
        model.addAttribute(new Location());
        return "addLocation";
    }



    @PostMapping("/addLocation")
    public String processAddLocationForm(@ModelAttribute @Valid Location newLocation,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "addLocation";
        }

        locationRepository.save(newLocation);
        model.addAttribute(new Menu() );
        return "redirect:/";
    }

    @GetMapping("/view/{locationId}")
    public String displayViewLocation(Model model, @PathVariable int locationId) {

        Optional optLocation = locationRepository.findById(locationId);
        if (!optLocation.isEmpty()) {
            Location location = (Location) optLocation.get();
            model.addAttribute("location", location);
            return "view";
        } else {
            return "redirect:/";
        }
    }



}
