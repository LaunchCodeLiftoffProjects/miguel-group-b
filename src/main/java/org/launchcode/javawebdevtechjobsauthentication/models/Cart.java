package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Cart extends AbstractEntity{

    private User user;
    private Product product;
    private int quantity;

    public Cart(Product product, int quantity, User user){}

    public Cart(User user, Product product, LocalDate dateCreated, int quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
