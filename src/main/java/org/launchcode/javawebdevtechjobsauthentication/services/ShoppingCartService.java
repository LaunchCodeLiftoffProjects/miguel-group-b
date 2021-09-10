package org.launchcode.javawebdevtechjobsauthentication.services;

import org.launchcode.javawebdevtechjobsauthentication.models.CartItem;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.ShoppingCart;
import org.launchcode.javawebdevtechjobsauthentication.models.data.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ShoppingCartService {

    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart addFirstShoppingCart(int id, String sessionToken, int quantity) {
        ShoppingCart shoppingCart = new ShoppingCart();
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);
        cartItem.setProduct(productService.getProductById(id));
        shoppingCart.getCartItems().add(cartItem);
        shoppingCart.setSessionToken(sessionToken);
        return shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart addToExistingShoppingCart(int id, String sessionToken, int quantity) {
        ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
        Product prod = productService.getProductById(id);
        if(shoppingCart!=null) {
            Set<CartItem> cartItems = shoppingCart.getCartItems();
            for (CartItem item : cartItems) {
                if (item.getProduct().equals(prod)) {
                    item.setQuantity(item.getQuantity() + quantity);
                    shoppingCart.setCartItems(cartItems);
                    shoppingCartRepository.saveAndFlush(shoppingCart);
//                  saveAndFlush used to read saved changes at a later point during the same transaction but before the commit
                }
            }
        } else {
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);
        cartItem.setProduct(prod);
        shoppingCart.getCartItems().add(cartItem);
        shoppingCartRepository.saveAndFlush(shoppingCart);
        }
        return this.addToExistingShoppingCart(id, sessionToken ,quantity);
    }
}
