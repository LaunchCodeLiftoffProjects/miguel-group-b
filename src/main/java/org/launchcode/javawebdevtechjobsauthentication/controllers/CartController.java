package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
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

    @GetMapping("view")
    public String viewCart(Model model, @ModelAttribute Cart newCart){
        model.addAttribute("cartItems", newCart.getCartItems());
        return "cart/view";
    }

    @GetMapping("add")
    public String addProductToCart(Model model){
        model.addAttribute(new Product());
        model.addAttribute("products", productRepository.findAll());
        return "cart/add";
    }

    @PostMapping("add")
    public String processAddProduct(@ModelAttribute @Valid Product newProduct,
                                    @RequestParam List<Product> cartItems,
                                    Errors errors, Model model){
        if(errors.hasErrors()){
            return "cart/add";
        }
        cartItems.add(newProduct);
        return "redirect:";
    }


}
