package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.services.CartService;
import org.launchcode.javawebdevtechjobsauthentication.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
//        Check for an existing session token
        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
        cartService.addFirstCart(id, sessionToken, quantity);
        if(sessionToken == null){
            sessionToken = UUID.randomUUID().toString();
            request.getSession().setAttribute("sessionToken", sessionToken);
            cartService.addFirstCart(id, sessionToken, quantity);
        } else {
            cartService.addToExistingCart(id, sessionToken, quantity);
        }
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String displayCart(HttpServletRequest request,  Model model){
        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
        if(sessionToken == null){
            return "redirect:";
//            TODO: Add error page
        } else {
            Cart cart = cartService.findCartBySessionToken(sessionToken);
            model.addAttribute("cart", cart);
        }
        return "cart";
    }
}
