package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Restaurant {

    @ManyToOne
    private TypeOfRestaurant typeOfRestaurant;


    @OneToMany
    private static List<LocationOfRestaurant> locationOfRestaurants = new ArrayList<>();


    @NotNull
    @Size(min=3, max=50)
    private String name;

//    private String locationOfRestaurant;
    private String rating;
    private String  TypeOfRestaurant;

    public Restaurant() {
    }

    // Initialize the id and value fields.
    public Restaurant(String aName, TypeOfRestaurant typeOfRestaurant, LocationOfRestaurant locationOfRestaurant, String rating) {
        super();
        this.name = aName;
        this.typeOfRestaurant = typeOfRestaurant;
//        this.LocationOfRestaurant = locationOfRestaurant;
        this.rating = rating;
    }

    // Getters and setters.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getTypeOfRestaurant() {
        return TypeOfRestaurant;
    }

    public void setTypeOfRestaurant(String typeOfRestaurant) {
        TypeOfRestaurant = typeOfRestaurant;
    }

    public List <LocationOfRestaurant> getLocationOfRestaurants () {
        return locationOfRestaurants;
    }

    public void setLocationOfRestaurants(List<LocationOfRestaurant> locationOfRestaurants) {
        this.locationOfRestaurants.addAll(locationOfRestaurants);
    }

    public void setTypeOfRestaurant(TypeOfRestaurant typeOfRestaurant) {
        this.typeOfRestaurant = typeOfRestaurant;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name;
    }
}

