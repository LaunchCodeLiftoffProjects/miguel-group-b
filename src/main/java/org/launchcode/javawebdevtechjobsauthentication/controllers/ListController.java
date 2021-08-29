package org.launchcode.javawebdevtechjobsauthentication.controllers;


import org.launchcode.javawebdevtechjobsauthentication.models.data.LocationRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.RatingRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private RatingRepository ratingRepository;

    static HashMap<String,String> columnChoices = new HashMap<>();

    public ListController(){

        columnChoices.put("all","All");
        columnChoices.put("restaurant","Restaurant");
        columnChoices.put("location","Location");


    }

    @RequestMapping("")
    public String list(Model model){
        model.addAttribute("locations",locationRepository.findAll());
        model.addAttribute("ratings",ratingRepository.findAll());
        return "list";
    }




}
