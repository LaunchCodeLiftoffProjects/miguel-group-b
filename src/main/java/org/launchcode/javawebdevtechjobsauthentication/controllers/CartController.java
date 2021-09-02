package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.DTO.CartProductDTO;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.data.CartRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.ProductRepository;
import org.launchcode.javawebdevtechjobsauthentication.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("cart")
//@SessionAttributes("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

//   when controller is accessed for the first time, spring instantiates an instance and places in the model
    @ModelAttribute("cart")
    public Cart cart(){
        return new Cart();
    }

    @GetMapping("view")
    public String viewCart(
//            @SessionAttribute("cart")
                                       Cart cart, Model model){
        model.addAttribute("cart", cart);
        return "cart/view";
    }

    @PostMapping("addToCart")
    public String addToCart(Model model, @ModelAttribute Cart cart, @ModelAttribute Product product){
        if(cart!=null){
            cart.setProduct(product);
            model.addAttribute("cart", cart);
        } else {
            Cart newCart = new Cart();
            cart.setProduct(product);
            model.addAttribute("cart", newCart);
        }
        return "redirect:";
//        + product detail page
    }

    @GetMapping("add-product")
    public String displayAddProductForm(@RequestParam int cartId, Model model){
        Optional<Cart> result = cartRepository.findById(cartId);
        Cart cart = result.get();
        model.addAttribute("products", productRepository.findAll());
        CartProductDTO cartProduct = new CartProductDTO();
        cartProduct.setCart(cart);
        model.addAttribute("cartProduct", cartProduct);
        return "cart/add-product";
    }

//    @GetMapping("view/{cartId}")
//    public String viewCustomerCart(@PathVariable int cartId, Model model){
//        Optional optCart = cartRepository.findById(cartId);
//        if(!optCart.isPresent()){
//            Cart cart = (Cart) optCart.get();
//            model.addAttribute("cart", cart);
//            model.addAttribute("total", cart.getTotal(cart));
//            return "view";
//        } else {
//            return "redirect:";
//        }
//    }
}
