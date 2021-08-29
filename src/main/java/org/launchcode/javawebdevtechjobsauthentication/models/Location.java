package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Location extends AbstractEntity{

    private final List<Restaurant> restaurant =new ArrayList<>();

    private String description;

    @NotBlank(message = "Please enter a number between 1 and 10.")
    private Integer rating;

    public Location(){}

    public List<Restaurant> getRestaurant() {
        return restaurant;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
