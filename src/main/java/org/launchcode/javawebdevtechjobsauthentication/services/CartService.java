package org.launchcode.javawebdevtechjobsauthentication.services;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.Customer;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.models.data.CartRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.Optional;

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

////    TEST
//    public Optional<Cart> listCartItems(Customer customer){
//        return cartRepository.findById(customer.getId());
//    }

//    public Cart viewCustomerCart(@PathVariable int cartId, Model model){
//        Optional optCart = cartRepository.findById(cartId);
//        if(!optCart.isPresent()){
//            Cart cart = (Cart) optCart.get();
//            model.addAttribute("cart", cart);
//            return "view";
//        } else {
//            return "redirect:";
//        }
//    }

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
