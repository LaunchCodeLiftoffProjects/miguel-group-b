package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Cart extends AbstractEntity {

    @OneToMany(mappedBy = "cart")
    private List<Product> products = new ArrayList<>();

    public Cart(){}

    public Cart(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addCartItems(Product product){
        this.products.add(product);
    }

//    public void removeCartItems(Product product){
//        this.cartItems.remove(product);
//    }
}
