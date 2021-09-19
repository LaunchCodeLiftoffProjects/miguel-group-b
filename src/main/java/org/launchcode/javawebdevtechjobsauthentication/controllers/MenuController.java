package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.data.LocationRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.MenuRepository;
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
public class MenuController {

//    @Autowired
//    private LocationRepository locationRepository;

    @Autowired
    private MenuRepository menuRepository;



    @RequestMapping("menus")
    public String index(Model model) {
//        model.addAttribute("locations",locationRepository.findAll());
        model.addAttribute("menu", menuRepository.findAll());

        return "menus/index";
    }

    @GetMapping("add")
    public String displayAddMenuForm( Model model) {
//        model.addAttribute(new Location());
        model.addAttribute(new Menu());
        return "menus/add";
    }



    @PostMapping("add")
    public String processAddMenuForm(@ModelAttribute @Valid Location newLocation, Menu newMenu, Errors errors,Model model) {

        if (errors.hasErrors()) {
//            model.addAttribute("title","Add Location");
            model.addAttribute("title","Add Menu");
            return "menus/add";
        }
//        locationRepository.save(newLocation);
        menuRepository.save(newMenu);

        return "redirect:../";
    }

    @GetMapping("/menus/view/{menuId}")
    public String displayViewMenu(Model model, @PathVariable int menuId) {
//        model.addAttribute("title","Add Menu");
//        model.addAttribute("menus",menuRepository.findById(menuId));
        Optional optMenu = menuRepository.findById(menuId);
        if (!optMenu.isEmpty()) {
            Menu menu = (Menu) optMenu.get();
            model.addAttribute("menus", menu);
            return "menus/view";
        } else {
            return "redirect:../";
        }
    }

}



