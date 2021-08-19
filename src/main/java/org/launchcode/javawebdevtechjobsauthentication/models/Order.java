package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.Entity;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Order extends AbstractEntity{


    private User username;


    private LocalDate dateCreated;

    private String status;

    @Valid
    private List<Product> orderProducts = new ArrayList<>();

    public Order(User username, LocalDate dateCreated, String status, List<Product> orderProducts) {
        this.username = username;
        this.dateCreated = dateCreated;
        this.status = status;
        this.orderProducts = orderProducts;
    }

    public Order() {
    }

    public Double getOrderTotal() {
        double sum = 0;
        List<Product> orderProducts = getOrderProducts();
        for (Product p : orderProducts) {
            sum += p.getPrice();
        }
        return sum;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public int getNumberOfProducts(){
        return this.orderProducts.size();
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<Product> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
