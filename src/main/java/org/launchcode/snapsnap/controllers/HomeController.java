package org.launchcode.snapsnap.controllers;

import org.launchcode.snapsnap.models.data.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private MenuRepository menuRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("menus", menuRepository.findAll());
        return "/index";
    }
    @RequestMapping("index")
    public String indexHome(Model model) {
        model.addAttribute("menus", menuRepository.findAll());
        return "/index";
    }
}
