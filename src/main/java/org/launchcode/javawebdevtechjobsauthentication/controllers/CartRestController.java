package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.services.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartRestController {

    @Autowired
    private CartServices cartServices;

    @PostMapping("/cart/add/{productId}/{quantity}")
    public String addProductToCart(@PathVariable int productId, @PathVariable int quantity){
        int addedQuantity = cartServices.addProductQuantity(productId, quantity);
        return addedQuantity + " item(s) added to cart.";
    }

}
