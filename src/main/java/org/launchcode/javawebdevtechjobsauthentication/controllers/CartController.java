package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.DTO.AddToCartDTO;
import org.launchcode.javawebdevtechjobsauthentication.models.DTO.CartDTO;
import org.launchcode.javawebdevtechjobsauthentication.models.DTO.CartItemDTO;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.User;
import org.launchcode.javawebdevtechjobsauthentication.models.data.UserRepository;
import org.launchcode.javawebdevtechjobsauthentication.services.CartService;
import org.launchcode.javawebdevtechjobsauthentication.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired UserRepository userRepository;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

//    @GetMapping("/add")
//    public String addToCart(Model model){
//        model.addAttribute(new Cart());
//        return "cart/add";
//    }

//    @PostMapping("/add")
//    public ResponseEntity<CartDTO> addToCart(AddToCartDTO addToCartDTO, @ModelAttribute Cart cart){
//        Product product = productService.findProductById(addToCartDTO.getProductId());
//    }

//    @PostMapping("/add")
//    public String addToCart(@ModelAttribute Cart newCart, Model model){
//        model.addAttribute("cart", cartService.viewCart(newCart.getUser()));
//        return "redirect:";
//    }

}
