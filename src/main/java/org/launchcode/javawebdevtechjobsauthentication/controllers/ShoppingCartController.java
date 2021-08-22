package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.ShoppingCart;
import org.launchcode.javawebdevtechjobsauthentication.models.data.ShoppingCartRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("index")
    public String index(){
        return "cart/index";
    }

    @GetMapping("add")
    public String addProductToShoppingCart(Model model){
        model.addAttribute("products", productRepository.findAll());
        return"cart/add";
    }

    @PostMapping("add")
    public String processAddProduct(@ModelAttribute @Valid ShoppingCart newShoppingCart, Errors errors, Model model){
        if(errors.hasErrors()){
            return "cart/add";
        }
        shoppingCartRepository.save(newShoppingCart);
        return "redirect:";
    }

}

//    TODO: METHOD TO ADD PRODUCT TO CART
//    @PostMapping("add")
//    public String addProductToOrder(@ModelAttribute Product newProduct){
//        orderRepository.save(newProduct);
//        return "redirect:";
//    }

//    @GetMapping("add")
//    public String addProductToCart(Model model){
//        model.addAttribute("title", "Add Item To Cart");
//        model.addAttribute("products", productRepository.findAll());
//        return "cart/add";
//    }
//
//    @PostMapping("add")
//    public String processAddProductToCart(@RequestParam(required = false) Product[] products, Order newOrder){
//        if(products!=null){
//            for(Product product: products){
//                newOrder.setOrderProducts((List<Product>) product);
//            }
//        }
//        return "redirect:";
//    }
//
//    @GetMapping("purchase/{orderId}")
//    public String viewPurchaseOrderForm(Model model, @PathVariable int orderId, @ModelAttribute Order newOrder){
//        model.addAttribute("order", orderRepository.findById(orderId));
//        model.addAttribute("items", newOrder.getOrderProducts());
//        model.addAttribute("total", newOrder.getOrderTotal());
//        return "purchase/{orderId}";
//    }
//}

//    TODO: METHOD THAT SENDS INFO TO USER PAYMENT
//    @GetMapping("userPayment")
//    public String sendToPayment(Model model){
//        model.addAttribute("title", "Go To Payment");
//        return "userPayment";
//    }

