package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.DTO.AddProductToCartDTO;
import org.launchcode.javawebdevtechjobsauthentication.models.DTO.CartDTO;
import org.launchcode.javawebdevtechjobsauthentication.models.DTO.CartItemDTO;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.User;
import org.launchcode.javawebdevtechjobsauthentication.models.data.UserRepository;
import org.launchcode.javawebdevtechjobsauthentication.services.CartService;
import org.launchcode.javawebdevtechjobsauthentication.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    UserRepository userRepository;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    //is User the correct param to use?
    @GetMapping("/view")
    public ResponseEntity<CartDTO> viewCart(User user, Model model){
        CartDTO cartDTO = cartService.listCartItems(user);
        model.addAttribute("cartDTO", cartDTO);
        return new ResponseEntity<>(cartDTO, HttpStatus.OK);
    }

//    @PostMapping("/add")
//    public ResponseEntity<AddProductToCartDTO> addProductToCart(@RequestBody AddProductToCartDTO addProductToCartDTO, User user){
//        Product newProduct = productService.findProductById(addProductToCartDTO.getProductId());
////                .getProductById(addProductToCartDTO.getProductId());
//        cartService.addToCart(addProductToCartDTO, newProduct, user);
//        return new ResponseEntity<AddProductToCartDTO>(newProduct, HttpStatus.CREATED);
//    }

//    @PostMapping("/add")
//    public ResponseEntity<Cart> addToCart(@RequestBody AddProductToCartDTO addProductToCartDTO){
//        Product product = productService.findProductById(addProductToCartDTO.getProductId());
//        Cart cart = cartService.addToCart(addProductToCartDTO, product, );
////        cartService.addToCart(addProductToCartDTO, product, user);
//        return new ResponseEntity<>(cart, HttpStatus.CREATED);
//    }

}
