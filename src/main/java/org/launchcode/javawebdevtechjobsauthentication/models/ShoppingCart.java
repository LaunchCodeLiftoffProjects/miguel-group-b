package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.*;
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

//    private String tokenSession;

    public ShoppingCart(){}

    public ShoppingCart(Double totalCost, int numberOfItems, Collection<CartItem> cartItems) {
        this.totalCost = totalCost;
        this.numberOfItems = numberOfItems;
        this.cartItems = cartItems;
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

    public Collection<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Collection<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
