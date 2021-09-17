package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.data.VendorRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;



@Controller
public class HomeController {
//TODO: VENDOR INFO NEEDS TO HAVE SEPARATE CONTROLLER
    @Autowired
    private VendorRepository vendorRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("vendors", vendorRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddvendorForm( Model model) {
        model.addAttribute(new Vendor());
        return "add";
    }



    @PostMapping("add")
    public String processAddvendorForm(@ModelAttribute @Valid Vendor newvendor,
                                       Errors errors) {

        if (errors.hasErrors()) {
            return "add";
        }

        vendorRepository.save(newvendor);
        return "redirect:";
    }

    @GetMapping("view/{vendorId}")
    public String displayViewvendor(Model model, @PathVariable int vendorId) {

        Optional optvendor = vendorRepository.findById(vendorId);
        if (!optvendor.isEmpty()) {
            Vendor vendor = (Vendor) optvendor.get();
            model.addAttribute("vendor", vendor);
            return "view";
        } else {
            return "redirect:/";
        }
    }
    @GetMapping("403")
    public String error403() {
        return "403";
    }


}
