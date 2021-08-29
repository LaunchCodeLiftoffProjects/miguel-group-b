package org.launchcode.javawebdevtechjobsauthentication.models;

import java.util.ArrayList;
import java.util.List;

public class Rating extends AbstractEntity{

    private final List<Restaurant>restaurant = new ArrayList<>();

    private String description;

    public Rating() {}

    public List<Restaurant> getRestaurant() {
        return restaurant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
