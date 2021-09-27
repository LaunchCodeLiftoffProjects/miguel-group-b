package org.launchcode.snapsnap.services;

import org.launchcode.snapsnap.models.Cart;
import org.launchcode.snapsnap.models.CartItem;
import org.launchcode.snapsnap.models.Product;
import org.launchcode.snapsnap.models.data.CartItemRepository;
import org.launchcode.snapsnap.models.data.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private ProductService productService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;

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
        Product product = productService.getProductById(id);
        Boolean productInCart = false;
        if (cart!=null) {
            List<CartItem> cartItems = cart.getCartItems();
            for (CartItem item : cartItems) {
                if (item.getProduct().equals(product)) {
                    productInCart = true;
                    item.setQuantity(item.getQuantity() + quantity);
                    cart.setCartItems(cartItems);
                    return cartRepository.saveAndFlush(cart);
//                  saveAndFlush used to read saved changes at a later point during the same transaction but before the commit
                }
            }
        }
        if((cart != null) && !productInCart ){
            CartItem newCartItem = new CartItem();
            newCartItem.setQuantity(quantity);
            newCartItem.setProduct(product);
            cart.getCartItems().add(newCartItem);
            return cartRepository.saveAndFlush(cart);
        }
       return this.addFirstCart(id, sessionToken, quantity);
    }

    public Cart findBySessionToken(String sessionToken){
        return cartRepository.findBySessionToken(sessionToken);
    }

    public CartItem editProductInCart(int id, int quantity){
        CartItem cartItem = cartItemRepository.findById(id).get();
        cartItem.setQuantity(quantity);
        return cartItemRepository.saveAndFlush(cartItem);
    }

    public Cart deleteProductsFromCart(String sessionToken, int productId){
        Cart cart = cartRepository.findBySessionToken(sessionToken);
        List<CartItem> cartItems = cart.getCartItems();
        CartItem cartItem = null;
        for(CartItem item : cartItems){
            if(item.getId()==productId){
                cartItem = item;
            }
        }
        cartItems.remove(cartItem);
        cartItemRepository.delete(cartItem);
        cart.setCartItems(cartItems);
        return  cartRepository.save(cart);
    }
}
