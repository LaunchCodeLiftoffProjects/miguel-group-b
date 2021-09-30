package org.launchcode.snapsnap.controllers;

import org.launchcode.snapsnap.models.Cart;
import org.launchcode.snapsnap.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class CheckoutController {

    @Autowired
    private CartService cartService;

    @Value("${stripe.public.key}")
    private String stripePublicKey;

    @GetMapping("review")
    public String reviewCheckout(HttpServletRequest request, Model model){
        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
        Cart cart = cartService.findBySessionToken(sessionToken);
        model.addAttribute("cart", cart);
        return "review";
    }

    @PostMapping("checkout")
    public String checkout(@ModelAttribute @Valid Cart newCart, BindingResult bindingResult, Model model, String sessionToken){
        if (bindingResult.hasErrors()){
            return"review";
        }
        Cart cart = cartService.findBySessionToken(sessionToken);
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("amount", cart.getTotalCost());
//        model.addAttribute("email", checkOutForm.getEmail());
        return "checkout";
    }

//    @PostMapping("/order")
//    public String checkout(@ModelAttribute @Valid CheckOutForm checkOutForm, BindingResult bindingResult, Model model){
//        if (bindingResult.hasErrors()){
//            return"order";
//        }
//        model.addAttribute("stripePublicKey", stripePublicKey);
//        model.addAttribute("amount", checkOutForm.getAmount());
//        model.addAttribute("email", checkOutForm.getEmail());
//        return "checkout";
//    }
    //    @GetMapping("/order")
//    public String orderForm(Model model){
//        model.addAttribute("checkoutForm", new CheckOutForm());
//        return "order";
//    }
//    @GetMapping("/order")
////    public String reviewOrder(HttpServletRequest request, Model model){
////        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
////        model.addAttribute("cart", cartService.findBySessionToken(sessionToken));
////        return "order";
////    }
    //    @GetMapping("/review-order")
//    public String reviewOrderForm(HttpServletRequest request, Model model){
//        String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
//        Cart cart = cartService.findBySessionToken(sessionToken);
//        model.addAttribute("reviewOrder", new ReviewOrderForm(cart, cart.getTotalCost()));
//        return "review-order";
//    }

//    @PostMapping("/review-order")
//    public String checkout(@ModelAttribute @Valid ReviewOrderForm reviewOrderForm, BindingResult bindingResult, Model model){
//        if(bindingResult.hasErrors()){
//            return "review-order";
//        }
//        model.addAttribute("stripePublicKey", stripePublicKey);
//        model.addAttribute("amount", reviewOrderForm.getAmount());
////        model.addAttribute("cart", reviewOrderForm.getCart());
//        return "checkout";
//    }

}
