package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Product extends AbstractEntity{

    @NotNull
    private String name;

    @NotNull
    @Size(min=3, max = 250, message = "must be longer than 3 characters")
    private String description;

    @NotNull
    private Double price;

    private String pictureURL;

//    @OneToMany
//    private List<Cart> carts;
    @ManyToOne
    private Cart cart;

    public Product(){}

    public Product(String name, String description, Double price, String pictureURL, Cart cart) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.pictureURL = pictureURL;
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPictureURL() { return pictureURL; }

    public void setPictureURL(String pictureURL) {this.pictureURL = pictureURL; }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    //    public List<Cart> getCarts() {
//        return carts;
//    }
//
//    public void setCarts(List<Cart> carts) {
//        this.carts = carts;
//    }
}
