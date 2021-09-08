package org.launchcode.javawebdevtechjobsauthentication.controllers;


import org.launchcode.javawebdevtechjobsauthentication.models.Location;
import org.launchcode.javawebdevtechjobsauthentication.models.Rating;
import org.launchcode.javawebdevtechjobsauthentication.models.Restaurant;
import org.launchcode.javawebdevtechjobsauthentication.models.data.LocationRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.RatingRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private RestaurantRepository restaurantRepository;
//    @Autowired
//    private LocationRepository locationRepository;
//    @Autowired
//    private RatingRepository ratingRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("restaurants", restaurantRepository.findAll());
//        model.addAttribute("locations",locationRepository.findAll());
//        model.addAttribute("ratings",ratingRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddRestaurantForm(Model model) {
        model.addAttribute("title","Add Restaurant");
        model.addAttribute("title", "Add Location");
        model.addAttribute("title","Add Rating");
        model.addAttribute(new Restaurant());
        model.addAttribute(new Location());
        model.addAttribute(new Rating());
        return "add";
    }

    @PostMapping("add")
    public String processAddRestaurantForm(@ModelAttribute @Valid Restaurant newRestaurant,
                                       Errors errors) {

        if (errors.hasErrors()) {
            return "add";
        }

        restaurantRepository.save(newRestaurant);
//        locationRepository.save(newLocation);
//        ratingRepository.save(newRating);

        return "redirect:";
    }

    @GetMapping("view/{restaurantId}")
    public String displayViewRestaurant(Model model, @PathVariable int restaurantId) {

        Optional optRestaurant = restaurantRepository.findById(restaurantId);
        if (!optRestaurant.isEmpty()) {
            Restaurant restaurant = (Restaurant) optRestaurant.get();
            model.addAttribute("restaurant", restaurant);
            return "view";
        } else {
            return "redirect:/";
        }
    }


}
