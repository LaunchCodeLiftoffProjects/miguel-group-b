package org.launchcode.javawebdevtechjobsauthentication.models;


import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class CartDetails extends AbstractEntity{

//    TODO: Add Cart Property
    private String username;
    private String email;
    private String status;
    private LocalDate dateCreated;

    public CartDetails() {
    }

    public CartDetails(String username, String email, String status, LocalDate dateCreated) {
        this.username = username;
        this.email = email;
        this.status = status;
        this.dateCreated = dateCreated;
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
