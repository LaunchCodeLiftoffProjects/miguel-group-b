package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCart extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private int quantity;

    public ShoppingCart(Product product, User user, int quantity) {
        this.product = product;
        this.user = user;
        this.quantity = quantity;
    }
    public ShoppingCart(){}

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
}


//    private User customer;
//
//    private LocalDate dateCreated;
//
//    private String status;
//
//    private List<Product> orderProducts;
//
//    public Order(LocalDate dateCreated, String status, List<Product> orderProducts) {
//        this.dateCreated = dateCreated;
//        this.status = status;
//        this.orderProducts = orderProducts;
//    }
//
//    public Order() {
//    }
//
//    public void addOrderProducts(Product product){
//        this.orderProducts.add(product);
//    }
//
//    public Double getOrderTotal() {
//        double sum = 0;
//        List<Product> orderProducts = getOrderProducts();
//        for (Product p : orderProducts) {
//            sum += p.getPrice();
//        }
//        return sum;
//    }
//
//    public LocalDate getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(LocalDate dateCreated) {
//        this.dateCreated = dateCreated;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public int getNumberOfProducts(){
//        return this.orderProducts.size();
//    }
//
//    public List<Product> getOrderProducts() {
//        return orderProducts;
//    }
//
//    public void setOrderProducts(List<Product> orderProducts) {
//        this.orderProducts = orderProducts;
//    }
//}
