package org.launchcode.snapsnap.models;

import org.launchcode.snapsnap.users.User;

import javax.persistence.*;
import java.util.*;

@Entity
public class Cart extends AbstractEntity{

//    @OneToOne
//    @JoinColumn(name="user_id")
//    private User user;

    @ManyToOne
    private User user;

    @Transient
    private Double totalCost;

    @Transient
    private int numberOfItems;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems = new ArrayList<>();

    private String sessionToken;

    private static final String userSessionKey = "user";

    public Cart(){}

    public Cart(User user) {
        this.user.getCart();
    }
    //    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public Double getTotalCost() {
        Double sum = 0.00;
        for (CartItem item : this.cartItems) {
            sum = sum + item.getProduct().getPrice() * item.getQuantity();
        }
        return sum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
