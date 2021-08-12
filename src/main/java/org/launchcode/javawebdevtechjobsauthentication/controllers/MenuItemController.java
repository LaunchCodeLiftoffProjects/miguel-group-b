package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.MenuItem;
import org.launchcode.javawebdevtechjobsauthentication.models.data.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("menuitems")
public class MenuItemController {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("title", "All Items");
        model.addAttribute("item", menuItemRepository.findAll());
        return "menuitems/index";
    }

    @GetMapping("add")
    public String addMenuItem(Model model){
        model.addAttribute(new MenuItem());
        return "menuitems/add";
    }

    @PostMapping("add")
    public String processAddMenuItem(@ModelAttribute @Valid MenuItem newMenuItem, Errors errors, Model model){
        if(errors.hasErrors()){
            return "menuitems/add";
        }
        menuItemRepository.save(newMenuItem);
        return "redirect:";
    }

    @GetMapping("delete")
    public String renderDeleteMenuItem(Model model){
        model.addAttribute("title", "Delete Item");
        model.addAttribute("items", menuItemRepository.findAll());
        return "menuitems/delete";
    }

//    @PostMapping("delete")
//    public String processDeleteMenuItem(@RequestParam(required = false) int[] menuItemIds) {
//        if (menuItemIds != null) {
//            for(int id : menuItemIds) {
//                menuItemRepository.delete(menuItemIds);
//            }
//        }
//    return "redirect:";
//    }
}
