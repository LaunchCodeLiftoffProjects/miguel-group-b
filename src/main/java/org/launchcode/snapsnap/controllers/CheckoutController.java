package org.launchcode.snapsnap.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {

    @Value("${stripe.public.key}")
    private String stripePublicKey;

    @GetMapping("checkout")
    public String checkout(Model model){
        model.addAttribute("stripePublicKey", stripePublicKey);
        return "checkout";
    }
}
