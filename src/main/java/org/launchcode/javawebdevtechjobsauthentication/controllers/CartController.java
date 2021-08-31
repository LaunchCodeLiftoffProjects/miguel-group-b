//package org.launchcode.javawebdevtechjobsauthentication.controllers;
//
//import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
//import org.launchcode.javawebdevtechjobsauthentication.models.Product;
//import org.launchcode.javawebdevtechjobsauthentication.models.data.CartRepository;
//import org.launchcode.javawebdevtechjobsauthentication.models.data.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("cart")
//public class CartController {
//
//    @Autowired
//    private CartRepository cartRepository;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//
//    @GetMapping("view")
//    public String viewCart(Model model, @ModelAttribute Cart newCart){
//        model.addAttribute("cart", newCart.getCartItems());
//        return "cart/view";
//    }
//
//////TODO: TEST ADD METHODS
////    @GetMapping("add/{productId}")
////    public String addItemToCart(Model model, @ModelAttribute Cart newCart){
////        model.addAttribute("products", productRepository.findAll());
////        return"add/{productId}";
////    }
//
//    @GetMapping("delete")
//    public String renderDeleteProductFromCart(Model model, @ModelAttribute Cart newCart){
//        model.addAttribute("title", "Delete Item");
//        model.addAttribute("cart", newCart.getCartItems());
//        return "cart/delete";
//    }
//
//    @PostMapping("delete")
//    public String processDeleteProductFromCart(@RequestParam int[] productIds, @ModelAttribute Cart cart){
//        for(int p : productIds){
//            cart.removeProduct(p);
//        }
//        return "redirect:";
//    }
//
//}
