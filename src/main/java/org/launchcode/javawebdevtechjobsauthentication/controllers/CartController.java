package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
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

    @GetMapping
    public String index(Model model){
        return "cart/index";
    }

    @GetMapping("view")
    public String viewCart(Model model){
        model.addAttribute("cart", cartRepository.findAll());
        return "cart/view";
    }

    @GetMapping("add")
    public String addProductToCart(Model model){
        model.addAttribute(new Product());
        return "cart/add";
    }

    @PostMapping("add")
    public String processAddProductToCart(@ModelAttribute Product newProduct,
                                    Errors errors, Model model){
        if(errors.hasErrors()){
            return "cart/add";
        }
        cartRepository.save(newProduct);
        System.out.println("nice");
        return "cart/view";
    }


    @GetMapping("delete")
    public String renderDeleteProductFromCart(Model model){
        model.addAttribute("title", "Delete Item");
        model.addAttribute("products", productRepository.findAll());
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