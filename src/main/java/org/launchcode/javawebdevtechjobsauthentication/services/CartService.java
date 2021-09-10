package org.launchcode.javawebdevtechjobsauthentication.services;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.CartItem;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.data.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CartService {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartRepository cartRepository;

    public Cart addFirstCart(int id, String sessionToken, int quantity) {
        Cart cart = new Cart();
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);
        cartItem.setProduct(productService.getProductById(id));
        cart.getCartItems().add(cartItem);
        cart.setSessionToken(sessionToken);
        return cartRepository.save(cart);
    }

    public Cart addToExistingCart(int id, String sessionToken, int quantity) {
        Cart cart = cartRepository.findBySessionToken(sessionToken);
        Product prod = productService.getProductById(id);
        if(cart!=null) {
            Set<CartItem> cartItems = cart.getCartItems();
            for (CartItem item : cartItems) {
                if (item.getProduct().equals(prod)) {
                    item.setQuantity(item.getQuantity() + quantity);
                    cart.setCartItems(cartItems);
                    cartRepository.saveAndFlush(cart);
//                  saveAndFlush used to read saved changes at a later point during the same transaction but before the commit
                }
            }
        } else {
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);
        cartItem.setProduct(prod);
        cart.getCartItems().add(cartItem);
        cartRepository.saveAndFlush(cart);
        }
        return this.addToExistingCart(id, sessionToken ,quantity);
    }

    public Cart findCartBySessionToken(String sessionToken){
        return cartRepository.findBySessionToken(sessionToken);
    }
}
