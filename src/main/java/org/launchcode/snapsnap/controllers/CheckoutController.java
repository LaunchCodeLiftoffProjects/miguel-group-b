package org.launchcode.snapsnap.controllers;

import org.launchcode.snapsnap.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {

    @Autowired
    private CartService cartService;

    @Value("${stripe.public.key}")
    private String stripePublicKey;

    @GetMapping("checkout")
    public String checkout(Model model){
        model.addAttribute("stripePublicKey", stripePublicKey);
        return "checkout";
    }
}
