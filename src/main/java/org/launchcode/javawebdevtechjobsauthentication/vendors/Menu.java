package org.launchcode.javawebdevtechjobsauthentication.vendors;

import org.launchcode.javawebdevtechjobsauthentication.models.AbstractEntity;

import javax.persistence.*;
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

    @NotNull(message = "Please provide a description for the menu.")
    private String description;

    @NotNull(message = "Please enter price e.g. '99.99' ")
    private Double price;

//    @JoinColumn(name="menuId")
//    @OneToOne
//            (mappedBy="menuId")
//    private Location location;
//    @ManyToOne
//    @JoinColumn(name ="user_id")
//    private String userId;
    @ManyToMany(mappedBy= "menus")
    private List<Location> location = new ArrayList<>();

    public Menu() {
    }

    // Initialize the id and value fields.
    public Menu(String aName, String aDescription, Double somePrice) {
        super();
        this.name = aName;
        this.description = aDescription;
        this.price = somePrice;
//        this.location = location;
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

//    public Location getLocation() {
//        return location;
//    }
//
//    public void setLocation(Location location) {
//        this.location = location;
//    }


    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return name;
    }

}

    

