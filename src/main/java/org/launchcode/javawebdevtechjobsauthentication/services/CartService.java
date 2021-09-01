package org.launchcode.javawebdevtechjobsauthentication.services;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
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

@Service
@Transactional
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public CartService(){}

    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

//    Add to Cart
    public void addToCart(CartItemDTO cartItemDTO, Product product, User user){
//        Cart cart = new Cart(product, cartItemDTO.getQuantity());
        Cart cart = new Cart(user, product, cartItemDTO.getQuantity());
        cartRepository.save(cart);
    }

//    View Items in Cart + total cost
    public CartDTO viewCart(User user){
        List<Cart> cartlist = cartRepository.findByCustomer(user);
        List<CartItemDTO> cartItems = new ArrayList<>();
        for(Cart cart: cartlist){
            CartItemDTO cartItemDTO = getDtoFromCart(cart);
            cartItems.add(cartItemDTO);
        }
        double orderTotal = 0;
        for(CartItemDTO cartItemDTO : cartItems){
            orderTotal += (cartItemDTO.getProduct().getPrice() * cartItemDTO.getQuantity());
        }
        CartDTO cartDTO = new CartDTO(cartItems, orderTotal);
        return cartDTO;
    }

    public static CartItemDTO getDtoFromCart(Cart cart) {
        CartItemDTO cartItemDto = new CartItemDTO(cart);
        return cartItemDto;
    }
//    update cart item

//    delete cart item
    public void deleteAllCartItems(){
        cartRepository.deleteAll();
    }


}
