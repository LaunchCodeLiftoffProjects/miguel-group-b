package org.launchcode.javawebdevtechjobsauthentication.models;

import org.springframework.util.CollectionUtils;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Cart extends AbstractEntity{
//    @ManyToOne
//    @JoinColumn(name = "cart")
//    @OneToMany
//    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User user;

    private int quantity;

//    public Cart(){}
//
//    public Cart(Product product, User user, int quantity) {
//        this.product = product;
//        this.user = user;
//        this.quantity = quantity;
//    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    public void setProduct(Product product){
//        if(products.isEmpty()){
//        List<Product> products = new ArrayList<>();
//        products.add(product);
//        this.setProducts(products);
//        }
//        else {
//            this.getProducts().add(product);
//        }
//    }
//    public void addProduct(Product product){
//        this.products.add(product);
//    }
//
//    public Double getTotal(Cart cart){
//        double total = 0;
//        for(Product product : products){
//            total = (product.getPrice() * cart.quantity);
//        }
//        return total;
//    }
}
