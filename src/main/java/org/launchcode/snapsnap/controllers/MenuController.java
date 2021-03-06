package org.launchcode.snapsnap.controllers;

import org.launchcode.snapsnap.models.Product;
import org.launchcode.snapsnap.models.data.MenuRepository;
import org.launchcode.snapsnap.models.Menu;
import org.launchcode.snapsnap.models.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("addMenu")
    public String displayAddMenuForm(Model model) {
        model.addAttribute(new Menu());
        return "menu/addMenu";
    }


    @PostMapping("addMenu")
    public String processAddMenuForm(@ModelAttribute @Valid Menu newMenu,
                                     Errors errors) {

        if (errors.hasErrors()) {
            return "menu/addMenu";
        }

        menuRepository.save(newMenu);
        return "redirect:/index";
    }


    @GetMapping("view/{menuId}")
    public String displayViewMenu(Model model, @PathVariable int menuId) {
        Optional product = productRepository.findById(menuId);
        Optional optMenu = menuRepository.findById(menuId);

        if (!optMenu.isEmpty()) {
            Menu menu = (Menu) optMenu.get();
            model.addAttribute("menu", menu);
            model.addAttribute("product", product);
            return "menu/view";
        } else {
            return "redirect:/";
        }
    }
}



