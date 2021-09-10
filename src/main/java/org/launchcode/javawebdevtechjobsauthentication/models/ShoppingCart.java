package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
public class ShoppingCart extends AbstractEntity{

    @Transient
    private Double totalCost;

    @Transient
    private int numberOfItems;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<CartItem> cartItems;

    private String tokenSession;

    public ShoppingCart(){}

    public ShoppingCart(Collection<CartItem> cartItems) {
        this.cartItems = new ArrayList<CartItem>();
    }
    //    public ShoppingCart(Double totalCost, int numberOfItems, Collection<CartItem> cartItems, String tokenSession) {
//        this.totalCost = totalCost;
//        this.numberOfItems = numberOfItems;
//        this.cartItems = cartItems;
//        this.tokenSession = tokenSession;
//    }

    public Double getTotalCost() {
        Double sum = 0.0;
        for (CartItem item : this.cartItems) {
            sum = sum + item.getProduct().getPrice();
        }
        return sum;
    }

    public int getNumberOfItems() {
        return this.cartItems.size();
    }

    public Collection<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Collection<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public String getTokenSession() {
        return tokenSession;
    }

    public void setTokenSession(String tokenSession) {
        this.tokenSession = tokenSession;
    }
}
