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
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
//    @ModelAttribute("cart")
//    public Cart cart(){
//        return new Cart();
//    }

    @GetMapping
    public String viewCart(
//            @SessionAttribute("cart")
                                       Cart cart, Model model){
        model.addAttribute(new Cart());
        model.addAttribute("cart", cart);
        return "cart/index";
    }

    @PostMapping("addToCart")
    public String addToCart(Model model, @ModelAttribute Cart cart, @ModelAttribute Product product){
        if(cart!=null){
            cart.addProduct(product);
            model.addAttribute("cart", cart);
        } else {
            Cart newCart = new Cart();
            cart.addProduct(product);
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

    @PostMapping("add-product")
    public String processAddProductForm(@ModelAttribute @Valid CartProductDTO cartProduct, Errors errors){
        if (!errors.hasErrors()) {
            Cart cart = cartProduct.getCart();
            Product product = cartProduct.getProduct();
            if (!cart.getProducts().contains(product)){
                cart.addProduct(product);
                cartRepository.save(cart);
            }
            return "redirect:detail?cartId=" + cart.getId();
        }
        return "redirect:add-product";
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
