package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
public class Cart extends AbstractEntity {

    private Product product;

//    TODO: THIS RELATIONSHIP MAY BE INCORRECT
    @OneToOne
    @JoinColumn(name = "cartDetails_id")
    private CartDetails cartDetails;

    @OneToMany(mappedBy = "cart")
    private List<Product> cartItems = new ArrayList<>();

    public Cart(){}

    public Cart(Product product, List<Product> cartItems) {
        this.product = product;
        this.cartItems = cartItems;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

//    public void removeCartItems(Product product){
//        this.cartItems.remove(product);
//    }
}
