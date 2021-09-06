package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Rating extends AbstractEntity{

//    @ManyToMany
//    (mappedBy="restaurants")
    private final ArrayList<Restaurant>restaurants = new ArrayList<>();

    private String description;

    public Rating() {

    }

    public ArrayList<Restaurant> getRestaurant() {
        return(ArrayList<Restaurant>) restaurants;
    }

    public void setRestaurants(List<Restaurant>restaurants){
        this.restaurants.addAll(restaurants);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
