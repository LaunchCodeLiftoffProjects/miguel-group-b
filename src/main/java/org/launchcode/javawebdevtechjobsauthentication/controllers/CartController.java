package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Order;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.data.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public String viewOrder(Model model){
        model.addAttribute("order", orderRepository.findAll());
        return "index";
    }

//    TODO: METHOD TO ADD PRODUCT TO CART
//    @PostMapping("add")
//    public String addProductToOrder(@ModelAttribute Product newProduct){
//        orderRepository.save(newProduct);
//        return "redirect:";
//    }


    @GetMapping("purchase/{orderId}")
    public String viewPurchaseOrderForm(Model model, @PathVariable int orderId, @ModelAttribute Order newOrder){
        model.addAttribute("order", orderRepository.findById(orderId));
        model.addAttribute("items", newOrder.getOrderProducts());
        model.addAttribute("total", newOrder.getOrderTotal());
        return "purchase/{orderId}";
    }

//    TODO: METHOD THAT SENDS INFO TO USER PAYMENT

}
