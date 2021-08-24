package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Cart extends AbstractEntity {

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems = new ArrayList<>();

    public Cart(){}

    public Cart(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<CartItem> getCartItems() { return cartItems; }

    public void setCartItems(List<CartItem> cartItems) {this.cartItems = cartItems; }

    public void addItemToCart(CartItem cartItem){
        this.cartItems.add(cartItem);
    }

//    public Double getCartTotal(List<CartItem> cartItems){
//        double sum = 0;
//
//        for(CartItem c : cartItems){
//            sum += c.getProduct().getPrice();
//        }
//        return sum;
//    }

    public Double getCartTotal(List<CartItem> cartItems){
        double sum = 0;

        for(int i = 0; i < cartItems.size();i++){
            sum += cartItems.get(i).getProduct().getPrice();
        }
        return sum;
    }

}
