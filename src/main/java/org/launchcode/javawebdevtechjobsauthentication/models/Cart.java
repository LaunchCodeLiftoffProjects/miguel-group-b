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

    public Cart(Double totalCost, int numberOfItems, Set<CartItem> cartItems, String sessionToken) {
        this.totalCost = totalCost;
        this.numberOfItems = numberOfItems;
        this.cartItems = new HashSet<CartItem>();
        this.sessionToken = sessionToken;
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

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
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
