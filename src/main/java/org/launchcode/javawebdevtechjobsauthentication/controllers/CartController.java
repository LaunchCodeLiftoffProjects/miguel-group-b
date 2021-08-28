package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.data.CartRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("view")
    public String viewCart(Model model, @ModelAttribute Cart newCart){
//        model.addAttribute("cart", cartRepository.findAll());
        model.addAttribute("cart", newCart.getCartItems());
        return "cart/view";
    }

//    @GetMapping("add")
//    public String addItemToCart(Model model,@ModelAttribute Cart newCart, @ModelAttribute Product newProduct){
////        model.addAttribute("products", productRepository.findAll());
//        model.addAttribute("cart", cartRepository.findAll());
//        newCart.addProduct(newProduct);
//        return "cart/add";
//    }
//
//    @PostMapping("add")
//    public String processAddItemToCart(@ModelAttribute Product newProduct, @ModelAttribute Cart newCart, Model model){
//        newCart.addProduct(newProduct);
//        return "cart/add";
//    }
////TODO: TEST ADD METHODS
//    @GetMapping("add/{productId}")
//    public String addItemToCart(Model model, @ModelAttribute Cart newCart){
//        model.addAttribute("products", productRepository.findAll());
//        return"add/{productId}";
//    }
////DOES THIS EVEN MEAN ANYTHING
//    @PostMapping("add/{productId}")
//    public String processAddItemToCart(@RequestParam int productId, @ModelAttribute Cart newCart, @ModelAttribute Product newProduct,Model model){
//        model.addAttribute("productId", productRepository.findById(newProduct.getId()));
//        newCart.addProduct(newProduct);
//
//        return"redirect:";
//    }

    @GetMapping("delete")
    public String renderDeleteProductFromCart(Model model, @ModelAttribute Cart newCart){
        model.addAttribute("title", "Delete Item");
        model.addAttribute("cart", newCart.getCartItems());
        return "cart/delete";
    }

    @PostMapping("delete")
    public String processDeleteProductFromCart(@RequestParam int[] productIds, @ModelAttribute Cart cart){
        for(int p : productIds){
            cart.removeProduct(p);
        }
        return "redirect:";
    }


//    @PostMapping("delete")
//    public String processDeleteProductFromCart(@RequestParam(required = false) int[] productIds) {
//        if (productIds != null) {
//            for(int p : productIds) {
//                cartRepository.deleteById(p);
//            }
//        }
//        return "redirect:";
//    }

}
