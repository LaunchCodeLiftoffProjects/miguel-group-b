package org.launchcode.javawebdevtechjobsauthentication.services;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.User;
import org.launchcode.javawebdevtechjobsauthentication.models.data.CartRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServices {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Cart> listItemsInCart(User user){
        return cartRepository.findByUser(user);
    }
    public Integer addProductQuantity(int productId, int quantity){
        int addedQuantity = quantity;
        Product product = productRepository.findById(productId).get();
//      find by customer needed
        Cart cart = cartRepository.findByProduct(product);
        if(cart != null){
            addedQuantity = cart.getQuantity() + quantity;
            cart.setQuantity(addedQuantity);
        } else {
            cart = new Cart();
            cart.setQuantity(quantity);
            cart.setProduct(product);
        }
        cartRepository.save(cart);
        return addedQuantity;
    }
}
