package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Cart extends AbstractEntity{

    @Transient
    private Double totalCost;

    @Transient
    private int numberOfItems;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<CartItem> cartItems = new HashSet<CartItem>();

    private String sessionToken;

    public Cart(){}

    public Cart(Set<CartItem> cartItems) {
        this.cartItems = new HashSet<CartItem>();
    }

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

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public String getSessionToken() {
        return sessionToken;
    }
    //    public String getTokenSession() {
//        return this.tokenSession = UUID.randomUUID().toString();
//    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
