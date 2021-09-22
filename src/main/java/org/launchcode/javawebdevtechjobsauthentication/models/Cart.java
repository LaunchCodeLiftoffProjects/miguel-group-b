package org.launchcode.javawebdevtechjobsauthentication.models;

import org.launchcode.javawebdevtechjobsauthentication.users.User;

import javax.persistence.*;
import java.util.*;

@Entity
public class Cart extends AbstractEntity{

//    @Transient
    private Double totalCost;

    @Transient
    private int numberOfItems;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems = new ArrayList<>();

    private String sessionToken;

    private User userId;

    public Cart(){}

    public Double getTotalCost() {
        Double sum = 0.00;
        for (CartItem item : this.cartItems) {
            sum = sum + item.getProduct().getPrice() * item.getQuantity();
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

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cart cart = (Cart) o;
        return Objects.equals(cartItems, cart.cartItems) && Objects.equals(sessionToken, cart.sessionToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cartItems, sessionToken);
    }
}
