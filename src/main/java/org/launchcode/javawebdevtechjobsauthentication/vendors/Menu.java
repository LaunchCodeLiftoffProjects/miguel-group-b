package org.launchcode.javawebdevtechjobsauthentication.vendors;

import org.launchcode.javawebdevtechjobsauthentication.models.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Entity
public class Menu extends AbstractEntity {

    @NotNull
    @Size(min=3, max=50)
    private String name;
    private String description;
    private Double price;

    @JoinColumn
    @OneToMany
    private final List<Location> locations = new ArrayList<>();


    public Menu() {
    }

    // Initialize the id and value fields.
    public Menu(String aName, String aDescription, Double somePrice) {
        super();
        this.name = aName;
        this.description = aDescription;
        this.price = somePrice;
    }

    // Getters and setters.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Location> getLocations() {
        return locations;
    }

//    public void setLocations(List<Location> locations){
//        this.locations.addAll(locations);
//    }

    @Override
    public String toString() {
        return name;
    }



}

    

