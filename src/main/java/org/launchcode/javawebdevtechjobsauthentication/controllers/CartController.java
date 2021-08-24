package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.CartItem;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.data.CartItemRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.CartRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @GetMapping("view")
    public String viewCart(Model model){
        model.addAttribute("cartItems", cartItemRepository.findAll());
        return "cart/view";
    }

    @GetMapping("add")
    public String addProductToCart(Model model){
        model.addAttribute(new CartItem());
        model.addAttribute("products", productRepository.findAll());
        return "cart/add";
    }

//    @PostMapping("add")
//    public String processAddProductToCart(@ModelAttribute List<CartItem> cartItems,
//                                    Errors errors){
//        cartItems
//
////        cartItemRepository.save(newCartItem);
//        return "cart/view";
//    }
//

    @GetMapping("delete")
    public String renderDeleteProductFromCart(Model model){
        model.addAttribute("title", "Delete Item");
        model.addAttribute("cartItems", cartItemRepository.findAll());
        return "cart/delete";
    }

//    @PostMapping("delete")
//    public String processDeleteProductFromCart(@RequestParam(required = false) Product[] products, @ModelAttribute Cart newCart) {
//        if (products != null) {
//            for(Product p : products) {
//                newCart.removeCartItems(p);
//            }
//        }
//        return "redirect:";
//    }

}
