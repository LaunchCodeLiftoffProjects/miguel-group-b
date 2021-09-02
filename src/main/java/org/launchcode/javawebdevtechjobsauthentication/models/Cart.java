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
    @OneToMany
    private List<Product> products;

    private int quantity;

    public Cart(){}

    public Cart(List<Product> products, int quantity) {
        this.products = products;
        this.quantity = quantity;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product){
        if(products.isEmpty()){
        List<Product> products = new ArrayList<>();
        products.add(product);
        this.setProducts(products);
        }
        else {
            this.getProducts().add(product);
        }
    }

    public Double getTotal(Cart cart){
        double total = 0;
        for(Product product : products){
            total = (product.getPrice() * cart.quantity);
        }
        return total;
    }
}
