package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Order extends AbstractEntity{

//    private User username;

    private LocalDate dateCreated;

    private String status;

    private List<Product> orderProducts = new ArrayList<>();

    public Order(LocalDate dateCreated, String status, List<Product> orderProducts) {
        this.dateCreated = dateCreated;
        this.status = status;
        this.orderProducts = orderProducts;
    }

    public Order() {
    }

    public void addOrderProducts(Product product){
        this.orderProducts.add(product);
    }

    public Double getOrderTotal() {
        double sum = 0;
        List<Product> orderProducts = getOrderProducts();
        for (Product p : orderProducts) {
            sum += p.getPrice();
        }
        return sum;
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
