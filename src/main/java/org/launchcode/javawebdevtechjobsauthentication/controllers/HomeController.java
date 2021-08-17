package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Vendor;
import org.launchcode.javawebdevtechjobsauthentication.models.data.VendorRepository;
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
    private VendorRepository vendorRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("vendors", vendorRepository.findAll());
        model.addAttribute("title", "test stuff");
        return "index";
    }

    @GetMapping("addVendor")
    public String displayAddJobForm(Model model) {
        model.addAttribute(new Vendor());
        return "addVendor";
    }

    @PostMapping("addVendor")
    public String processAddVendorForm(@ModelAttribute @Valid Vendor newVendor,
                                       Errors errors) {

        if (errors.hasErrors()) {
            return "addVendor";
        }

        vendorRepository.save(newVendor);
        return "redirect:";
    }

    @GetMapping("view/{vendorId}")
    public String displayViewVendor(Model model, @PathVariable int jobId) {

        Optional optJob = vendorRepository.findById(jobId);
        if (!optJob.isEmpty()) {
            Vendor vendor = (Vendor) optJob.get();
            model.addAttribute("vendor", vendor);
            return "view";
        } else {
            return "redirect:/";
        }
    }


}
