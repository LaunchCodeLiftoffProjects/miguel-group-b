package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Location extends AbstractEntity{

//    @JoinColumn
//    @OneToOne
    private final ArrayList<Restaurant> restaurants =new ArrayList<>();

    @NotBlank(message = "Provide description for the location.")
    private String description;

    public Location(){
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Restaurant> getRestaurant() {
        return(ArrayList<Restaurant>) restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants.addAll(restaurants);
    }


}
