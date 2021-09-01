package org.launchcode.javawebdevtechjobsauthentication.services;

import org.launchcode.javawebdevtechjobsauthentication.exceptions.NotFoundException;
import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.DTO.AddProductToCartDTO;
import org.launchcode.javawebdevtechjobsauthentication.models.DTO.CartDTO;
import org.launchcode.javawebdevtechjobsauthentication.models.DTO.CartItemDTO;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.User;
import org.launchcode.javawebdevtechjobsauthentication.models.data.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    public CartService(){}

//    REMOVED USER PARAM FROM METHOD FOR NOW
//    public void addToCart(AddProductToCartDTO addToCartDTO, Product product, User user){
//        Cart cart = new Cart(product, addToCartDTO.getQuantity(), user);
//        cartRepository.save(cart);
//    }

    public void addToCart(Product product, AddProductToCartDTO addToCartDTO){
        Cart cart = new Cart(product, addToCartDTO.getQuantity());
        cartRepository.save(cart);
    }

    public CartDTO listCartItems(User user){
//        List<Cart> cartList = cartRepository.findAllByUserOrder(user);
        List<Cart> cartList = cartRepository.findAll();
        List<CartItemDTO> cartItems = new ArrayList<>();
        for(Cart cart: cartList){
            CartItemDTO cartItemDTO = getDTOFromCart(cart);
            cartItems.add(cartItemDTO);
        }
        double totalAmount=0;
        for(CartItemDTO cartItemDTO : cartItems){
            totalAmount += (cartItemDTO.getProduct().getPrice() * cartItemDTO.getQuantity());
        }
        CartDTO cartDTO = new CartDTO(cartItems, totalAmount);
        return cartDTO;
    }

    public static CartItemDTO getDTOFromCart(Cart cart){
        CartItemDTO cartItemDTO = new CartItemDTO(cart);
        return cartItemDTO;
    }

//    public Cart findCartById(int id){
//        return cartRepository.findByCartId(id).orElseThrow(() -> new NotFoundException("Cart with id " + id + "was not found."));
//    }

}
