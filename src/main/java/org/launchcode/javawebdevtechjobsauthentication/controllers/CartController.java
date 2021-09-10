package org.launchcode.javawebdevtechjobsauthentication.controllers;

import antlr.StringUtils;
import org.launchcode.javawebdevtechjobsauthentication.models.CartItem;
import org.launchcode.javawebdevtechjobsauthentication.models.ShoppingCart;
import org.launchcode.javawebdevtechjobsauthentication.models.data.ProductRepository;
import org.launchcode.javawebdevtechjobsauthentication.services.ProductService;
import org.launchcode.javawebdevtechjobsauthentication.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.UUID;

@Controller
public class CartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ProductService productService;

    @PostMapping("/addToCart")
    public String addToCart(HttpServletRequest request, Model model, @RequestParam("id")int id, @RequestParam("quantity") int quantity){
//        check for sessiontoken
        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
        shoppingCartService.addFirstShoppingCart(id, sessionToken, quantity);
        if(sessionToken == null){
            sessionToken = UUID.randomUUID().toString();
            request.getSession().setAttribute("sessionToken", sessionToken);
//            ShoppingCart shoppingCart = new ShoppingCart();
//            CartItem cartItem = new CartItem();
//            cartItem.setQuantity(quantity);
//            cartItem.setProduct(productService.getProductById(id));
//            shoppingCart.getCartItems().add(cartItem);
        } else {
            shoppingCartService.addToExistingShoppingCart(id, sessionToken, quantity);
        }
        return "redirect:/";
    }

    @GetMapping("shoppingCart")
    public String showCart(HttpServletRequest request,  Model model){
        return "shoppingCart";
    }
}
