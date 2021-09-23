package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.services.CartService;
import org.launchcode.javawebdevtechjobsauthentication.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @PostMapping("/addToCart")
    public String addToCart(HttpServletRequest request, Model model, Integer userId, @RequestParam("id")int id, @RequestParam("quantity") int quantity){

        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");

        if(sessionToken == null){
            sessionToken = UUID.randomUUID().toString();
            request.getSession().setAttribute("sessionToken", sessionToken);
            cartService.addFirstCart(id, sessionToken, quantity, userId);
        } else {
            cartService.findBySessionToken(sessionToken);
            cartService.addToExistingCart(id,sessionToken, quantity, userId);
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(HttpServletRequest request,  Model model){
        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
        if(sessionToken == null){
            return "redirect:";
        } else {
            Cart cart = cartService.findBySessionToken(sessionToken);
            model.addAttribute("cart", cart);
//        }
            return "cart";
        }
    }

//    @GetMapping("/cart")
//    public String viewCart(HttpServletRequest request,  Model model){
//        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
//        Cart cart = cartService.findBySessionToken(sessionToken);
//        model.addAttribute("cart", cart);
//        return "cart";
//    }

//    @GetMapping("/cart")
//    public String viewCart(String sessionToken,  Model model){
//        Cart cart = cartService.findBySessionToken(sessionToken);
//        model.addAttribute("cart", cart);
//        return "cart";
//    }

    @PostMapping("/editCart")
    public String editCart(@RequestParam("product_id") int id, @RequestParam("quantity") int quantity){
        cartService.editProductInCart(id, quantity);
        return"redirect:cart";
    }

    @GetMapping("/deleteCartItem/{id}")
    public String deleteCartItem(@PathVariable("id") int productId, HttpServletRequest request){
        String sessionToken = (String) request.getSession(false).getAttribute("sessionToken");
        cartService.deleteProductsFromCart(sessionToken, productId);
        return"redirect:/cart";
    }

}
