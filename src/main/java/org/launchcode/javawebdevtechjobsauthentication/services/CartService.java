package org.launchcode.javawebdevtechjobsauthentication.services;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.User;
import org.launchcode.javawebdevtechjobsauthentication.models.data.CartRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public CartService(){}

    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

//    add product
//    public int addProduct(int productId, int quantity){
//        Integer addedQuantity = quantity;
//        Product product = productRepository.findById(productId).get();
//        Cart cart = car
//
//        if(cart != null) {
//            cart.setQuantity(quantity);
//        } else {
//            cart = new Cart();
//            cart.setProduct(product);
//            cart.setQuantity(quantity);
//        }
//        cartRepository.save(cart);
//        return addedQuantity;
//    }
//


//    remove product

//    update quantity

}
