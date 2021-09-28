package org.launchcode.snapsnap.controllers;

import org.launchcode.snapsnap.models.Cart;
import org.launchcode.snapsnap.services.CartService;
import org.launchcode.snapsnap.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class CartController {

    @Value("${stripe.public.key}")
    private String stripePublicKey;


    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @PostMapping("/addToCart")
    public String addToCart(HttpServletRequest request, Model model, @RequestParam("id")int id, @RequestParam("quantity") int quantity){

        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");

        if(sessionToken == null){
            sessionToken = UUID.randomUUID().toString();
            request.getSession().setAttribute("sessionToken", sessionToken);
            cartService.addFirstCart(id, sessionToken, quantity);
        } else {
            cartService.findBySessionToken(sessionToken);
            cartService.addToExistingCart(id,sessionToken, quantity);
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

//    @GetMapping("/order")
//    public String viewOrder(HttpServletRequest request,  Model model){
//        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
//        if(sessionToken == null){
//            return "redirect:";
//        } else {
//            Cart cart = cartService.findBySessionToken(sessionToken);
//            model.addAttribute("amount", cart.getTotalCost());
////        }
//            return "order";
//        }
//    }
//
//    @PostMapping("/order")
//    public String checkout(@ModelAttribute @Valid Cart newCart, BindingResult bindingResult, Model model){
//        if(bindingResult.hasErrors()){
//            return "redirect:";
//        }
//        model.addAttribute("stripePublicKey", stripePublicKey);
//        model.addAttribute("amount", newCart.getTotalCost());
//        return "checkout";
//    }

}
