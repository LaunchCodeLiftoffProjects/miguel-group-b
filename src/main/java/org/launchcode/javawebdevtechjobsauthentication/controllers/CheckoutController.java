package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CheckoutController {

    @Autowired
    private CartService cartService;

    @PostMapping("/processPayment")
    public String processUserPayment(HttpServletRequest request, Model model, @RequestParam Cart newCart){
        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
        Cart cart = cartService.findBySessionToken(sessionToken);
        cart.getTotalCost();

        return "redirect:/cart";
    }

    public String payCartTotal(@RequestParam Cart newCart ,String sessionToken){
        Cart cart = cartService.findBySessionToken(sessionToken);
        cart.getTotalCost();
        return "cart";
    }
}
