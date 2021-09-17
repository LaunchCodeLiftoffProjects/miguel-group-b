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
    private List<CartItem> cartItems = new ArrayList<>();

    private String sessionToken;

    public Cart(){}

    public Cart(int numberOfItems, List<CartItem> cartItems, String sessionToken) {
        this.numberOfItems = numberOfItems;
        this.cartItems = new ArrayList<>();
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

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
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
