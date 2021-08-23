package org.launchcode.javawebdevtechjobsauthentication.models;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public class Vendor extends AbstractEntity{

    @NotNull
    @Size(min=3, max=50)
    private String name;
    private String location;
    private String productType;

    public Vendor() {
    }

    // Initialize the id and value fields.
    public Vendor(String aName, String aLocation, String aProductType) {
        super();
        this.name = aName;
        this.location = aLocation;
        this.productType = aProductType;
    }

    // Getters and setters.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return name;
    }
}
