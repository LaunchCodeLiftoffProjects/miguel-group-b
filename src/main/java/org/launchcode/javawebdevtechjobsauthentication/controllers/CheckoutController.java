package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckoutController {

    @Autowired
    private CartService cartService;

    public String payCartTotal(@RequestParam Cart newCart ,String sessionToken){
        Cart cart = cartService.findBySessionToken(sessionToken);
        cart.getTotalCost();
        return "cart";
    }
}
