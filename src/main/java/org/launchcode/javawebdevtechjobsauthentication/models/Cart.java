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

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

//    public void addCartItems(Product product){
//        this.products.add(product);
//    }

//    public void removeCartItems(Product product){
//        this.cartItems.remove(product);
//    }
}
