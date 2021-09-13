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

    @Autowired
    private VendorRepository vendorRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("vendors", vendorRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddVendorForm( Model model) {
        model.addAttribute(new Vendor());
        return "add";
    }



    @PostMapping("add")
    public String processAddVendorForm(@ModelAttribute @Valid Vendor newvendor,
                                       Errors errors) {

        if (errors.hasErrors()) {
            return "add";
        }

        vendorRepository.save(newvendor);
        return "redirect:";
    }

    @GetMapping("view/{vendorId}")
    public String displayViewVendor(Model model, @PathVariable int vendorId) {

        Optional optVendor = vendorRepository.findById(vendorId);
        if (!optVendor.isEmpty()) {
            Vendor vendor = (Vendor) optVendor.get();
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
