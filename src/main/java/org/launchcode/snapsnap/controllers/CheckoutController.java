package org.launchcode.snapsnap.controllers;

import org.launchcode.snapsnap.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CheckoutController {

    @Value("${stripe.public.key}")
    private String stripePublicKey;

    @Autowired
    private CartService cartService;

//    @RequestMapping("/checkout")
//    public String checkoutForm(Model model){
//        model.addAttribute("amount", 50 * 100);
//        model.addAttribute("stripePublicKey", stripePublicKey);
//        return "checkout";
//    }

    @RequestMapping("/checkout")
    public String checkoutForm(HttpServletRequest request, Model model){
        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
        model.addAttribute("amount",cartService.findBySessionToken(sessionToken).getTotalCost());
        model.addAttribute("stripePublicKey", stripePublicKey);
        return "checkout";
    }
}
