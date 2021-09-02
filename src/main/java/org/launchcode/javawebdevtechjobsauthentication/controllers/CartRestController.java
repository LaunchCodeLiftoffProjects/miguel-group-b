package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.User;
import org.launchcode.javawebdevtechjobsauthentication.services.CartService;
import org.launchcode.javawebdevtechjobsauthentication.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
public class CartRestController {

    @Autowired
    private CartService cartService;

    public CartRestController(CartService cartService) {
        this.cartService = cartService;
    }

//    add product to cart
//    @PostMapping("/add/{productId}/{quantity}")
//    public String addItemToCart(@PathVariable("productId") int productId, @PathVariable("quantity") int quantity){
//        Integer addedQuantity = cartService.addProduct(productId, quantity);
//
//    }

//    remove product from cart

//    update quantity

}