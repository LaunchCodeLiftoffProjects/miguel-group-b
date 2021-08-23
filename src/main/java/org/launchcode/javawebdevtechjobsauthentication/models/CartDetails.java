package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.beans.Transient;
import java.time.LocalDate;

public class CartDetails extends AbstractEntity{

//    TODO: Add Cart Property
    @OneToOne(mappedBy = "cartDetails")
    private Cart cart;

    private String username;
    private String email;
    private String status;
    private LocalDate dateCreated;

    public CartDetails() {
    }

    public CartDetails(Cart cart, String username, String email, String status, LocalDate dateCreated) {
        this.cart = cart;
        this.username = username;
        this.email = email;
        this.status = status;
        this.dateCreated = dateCreated;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }


}
