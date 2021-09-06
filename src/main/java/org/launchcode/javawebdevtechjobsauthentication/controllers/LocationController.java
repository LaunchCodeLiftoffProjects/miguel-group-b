//package org.launchcode.javawebdevtechjobsauthentication.controllers;
//
//import org.launchcode.javawebdevtechjobsauthentication.models.Location;
//import org.launchcode.javawebdevtechjobsauthentication.models.data.LocationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;
//import java.util.Optional;
//
//
//@Controller
//@RequestMapping("locations")
//public class LocationController {
//
//        @Autowired
//        private LocationRepository locationRepository;
//
//        @RequestMapping("")
//        public String index(Model model){
//            model.addAttribute("title","All Locations");
//            model.addAttribute("locations", locationRepository.findAll());
//
//            return "locations/index";
//        }
//
//
//        @GetMapping("add")
//        public String  displayAddLocationForm(Model model) {
//            model.addAttribute(new Location());
//
//            return "locations/add";
//        }
//
//        @PostMapping("add")
//        public String processAddEmployerForm(@ModelAttribute @Valid Location newLocation,
//                                             Errors errors, Model model) {
//
//            if (errors.hasErrors()) {
//                model.addAttribute("title","Add Location");
//                return "locations/add";
//            }
//            locationRepository.save(newLocation);
//
//            return "redirect:";
//        }
//
//        @GetMapping("view/{locationId}")
//        public String displayViewLocation(Model model, @PathVariable int locationId) {
//            Optional optLocation = locationRepository.findById(locationId);
//            if(optLocation.isPresent()){
//                Location location =  (Location) optLocation.get();
//                model.addAttribute("location", location);
//                return "locations/view";
//            }else {
//                return "redirect:../";
//            }
//        }
//
//}
