package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CartItem extends AbstractEntity{

    @ManyToOne
    private Product product;

    @ManyToOne
    private Cart cart;

    private int quantity;

    public CartItem(){}

    public CartItem(Product product, Cart cart, int quantity) {
        this.product = product;
        this.cart = cart;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
