package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

public class Cart extends AbstractEntity {

    private Product product;
    private Double quantity;
    private List<Product> cartItems = new ArrayList<>();

    public Cart(){}

    public Cart(Product product, Double quantity, List<Product> cartItems) {
        this.product = product;
        this.quantity = quantity;
        this.cartItems = cartItems;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Product> cartItems) {
        this.cartItems = cartItems;
    }

    public void addCartItems(Product product){
        this.cartItems.add(product);
    }
}
