package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.UserPayment;
import org.launchcode.javawebdevtechjobsauthentication.models.data.paymentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/userPayment")
public class UserPaymentController {


    @GetMapping("add")
    public String index(Model model) {
        return "userPayment";
    }

//    @RequestMapping(value = "add", method = RequestMethod.POST)
//    public String paymentProcessed(Model model) {
//        model.addAttribute("userPayment", paymentRepository.findAll());
//        return "something";
//    }

    @PostMapping("add")
    public String processUserPaymentForm(@ModelAttribute @Valid UserPayment newUserPayment, Errors errors) {
        if (errors.hasErrors()) {
            return "add";
        }

//        paymentRepository.save(newUserPayment);
        return "redirect:";
    }
    }
