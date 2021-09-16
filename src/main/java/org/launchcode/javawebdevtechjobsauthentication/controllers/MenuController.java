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

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private MenuRepository menuRepository;



    @RequestMapping(value="menuIndex")
    public String menuIndex(Model model) {
        model.addAttribute("locations",locationRepository.findAll());
        model.addAttribute("menus", menuRepository.findAll());

        return "menuIndex";
    }

    @GetMapping("addMenu")
    public String displayAddMenuForm( Model model) {
        model.addAttribute(new Location());
        model.addAttribute(new Menu());
        return "addMenu";
    }



    @PostMapping("addMenu")
    public String processAddMenuForm(@ModelAttribute @Valid Location location, Menu newMenu,
                                         Errors errors) {

        if (errors.hasErrors()) {
            return "addMenu";
        }

        menuRepository.save(newMenu);
        return "redirect:";
    }

    @GetMapping("view/{menuId}")
    public String displayViewMenu(Model model, @PathVariable int menuId) {

        Optional optMenu = menuRepository.findById(menuId);
        if (!optMenu.isEmpty()) {
            Menu menu = (Menu) optMenu.get();
            model.addAttribute("menu", menu);
            return "viewMenu";
        } else {
            return "redirect:/";
        }
    }

}
