package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.Entity;

@Entity
public class Customer extends AbstractEntity{

    private Cart cart;
    private String username;

    public Customer(){}

    public Customer(Cart cart, String username) {
        this.cart = cart;
        this.username = username;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
