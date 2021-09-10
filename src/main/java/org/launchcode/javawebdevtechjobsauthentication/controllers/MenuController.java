package org.launchcode.javawebdevtechjobsauthentication.controllers;


import org.launchcode.javawebdevtechjobsauthentication.models.data.MenuRepository;
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
    private MenuRepository menuRepository;


    @GetMapping("addMenu")
    public String displayAddMenuForm( Model model) {
        model.addAttribute(new Menu());
        return "addMenu";
    }


    @PostMapping("addMenu")
    public String processAddMenuForm(@ModelAttribute @Valid Menu newMenu,
                                         Errors errors) {

        if (errors.hasErrors()) {
            return "addMenu";
        }

        menuRepository.save(newMenu);
        return "redirect:";
    }

    @GetMapping("viewMenu/{menuId}")
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
