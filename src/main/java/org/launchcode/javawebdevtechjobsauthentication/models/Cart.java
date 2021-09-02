package org.launchcode.javawebdevtechjobsauthentication.models;

import org.springframework.util.CollectionUtils;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Cart extends AbstractEntity{

    @OneToOne
    private Customer customer;

//    @ManyToOne
    private List<Product> products;

    private int quantity;

    public Cart(){}

    public Cart(Customer customer, List<Product> products, int quantity) {
        this.customer = customer;
        this.products = products;
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        if(CollectionUtils.isEmpty(this.getProducts())){
        List<Product> products = new ArrayList<>();
        products.add(product);
        this.setProducts(products);
        } else {
            this.getProducts().add(product);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cart cart = (Cart) o;
        return Objects.equals(customer, cart.customer) && Objects.equals(products, cart.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customer, products, quantity);
    }

    public Double getTotal(Cart cart){
        double total = 0;
        for(Product product : products){
            total = (product.getPrice() * cart.quantity);
        }
        return total;
    }
}
