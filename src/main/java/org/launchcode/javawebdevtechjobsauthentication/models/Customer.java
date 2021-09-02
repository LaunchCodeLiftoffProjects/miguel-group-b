package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.Entity;

@Entity
public class Customer extends AbstractEntity{

    private String username;

    public Customer(){}

    public Customer(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
