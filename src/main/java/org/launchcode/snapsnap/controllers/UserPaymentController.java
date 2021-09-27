package org.launchcode.snapsnap.controllers;

import org.launchcode.snapsnap.models.UserPayment;
import org.launchcode.snapsnap.models.data.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/userPayment")
public class UserPaymentController {


    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("add")
    public String index(Model model) {
        model.addAttribute("title", "userPayment");
        model.addAttribute(new UserPayment());
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
        paymentRepository.save(newUserPayment);
//        EmailController.sendEmail();

        return "/sendEmail";
    }
    }
