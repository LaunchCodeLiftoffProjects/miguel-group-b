package org.launchcode.javawebdevtechjobsauthentication.services;

import org.launchcode.javawebdevtechjobsauthentication.models.CartItem;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.ShoppingCart;
import org.launchcode.javawebdevtechjobsauthentication.models.data.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        for(CartItem item : shoppingCart.getCartItems()){
            if(prod.getId() == (item.getProduct().getId())){
              item.setQuantity(item.getQuantity() + quantity);
              return shoppingCartRepository.save(shoppingCart);
            }
        }
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);
        cartItem.setProduct(prod);
        shoppingCart.getCartItems().add(cartItem);
        return shoppingCartRepository.save(shoppingCart);
    }
}
