package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.data.CartRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;


    @GetMapping("view")
    public String viewCart(Model model){
        model.addAttribute("cart", cartRepository.findAll());
        return "cart/view";
    }

    @GetMapping("add")
    public String addItemToCart(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "cart/add";
    }

    @PostMapping("add")
    public String processAddItemToCart(@ModelAttribute Product newProduct, @ModelAttribute Cart newCart){
        newCart.addProduct(newProduct);
        return "cart/add";
    }

    @GetMapping("delete")
    public String renderDeleteProductFromCart(Model model){
        model.addAttribute("title", "Delete Item");
        model.addAttribute("products", productRepository.findAll());
        return "cart/delete";
    }

    @PostMapping("delete")
    public String processDeleteProductFromCart(@RequestParam(required = false) int[] productIds) {
        if (productIds != null) {
            for(int p : productIds) {
                cartRepository.deleteById(p);
            }
        }
        return "redirect:";
    }

}
