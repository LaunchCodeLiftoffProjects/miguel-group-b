//package org.launchcode.javawebdevtechjobsauthentication.controllers;
//
//import org.dom4j.rule.Mode;
//import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
//import org.launchcode.javawebdevtechjobsauthentication.models.CartItem;
//import org.launchcode.javawebdevtechjobsauthentication.models.data.CartRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class CartItemController {
//
//    @GetMapping("add")
//    public String addProductToCartItem(Model model){
//        model.addAttribute(new CartItem());
//        return "cart/add";
//    }
//
//    @PostMapping("add")
//    public String processAddProductToCartItem(Model model, @ModelAttribute CartItem cartItem, Errors errors, Cart newCart){
//        if(errors.hasErrors()){
//            return "cart/add";
//        }
//        cartItem.setCart(newCart);
//        return "redirect:";
//    }
//
//}
