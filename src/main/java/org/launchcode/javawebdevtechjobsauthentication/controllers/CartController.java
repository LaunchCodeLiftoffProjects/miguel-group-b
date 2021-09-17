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
    public String addToCart(HttpServletRequest request, Model model, @RequestParam("id")int id, @RequestParam("quantity") int quantity){
//        The servlet container creates an HttpServletRequest object and passes it as an argument to
//        the servlet's service methods (doGet, doPost, etc).
//        Check for an existing session to
        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");

        if(sessionToken == null){
            sessionToken = UUID.randomUUID().toString();
            request.getSession().setAttribute("sessionToken", sessionToken);
            cartService.addFirstCart(id, sessionToken, quantity);
        } else {
//            cartService.findBySessionToken(sessionToken);
            cartService.addToExistingCart(id,sessionToken, quantity);
        }
        return "redirect:";
    }

//    @GetMapping("/cart")
//    public String viewCart(HttpServletRequest request,  Model model){
//        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
//        if(sessionToken == null){
//            return "redirect:";
////            TODO: Add error page
//        } else {
//            Cart cart = cartService.findBySessionToken(sessionToken);
//            model.addAttribute("cart", cart);
////        }
//            return "cart";
//        }
//    }

    @GetMapping("/cart")
    public String viewCart(String sessionToken,  Model model){
//        Cart cart = cartService.findBySessionToken(sessionToken);
        model.addAttribute("cart", cartService.findBySessionToken(sessionToken));
        return "cart";
    }

    @PostMapping("/editCart")
    public String editCart(@RequestParam("id") int id, @RequestParam("quantity") int quantity){
        cartService.editProductInCart(id, quantity);
        return"redirect:cart";
    }

    @GetMapping("/deleteCartItem/{id}")
    public String deleteCartItem(@PathVariable("id") int id, HttpServletRequest request){
        String sessionToken = (String) request.getSession(false).getAttribute("sessionToken");
        cartService.deleteProductsFromCart(sessionToken, id);
        return"redirect:cart";
    }

}
