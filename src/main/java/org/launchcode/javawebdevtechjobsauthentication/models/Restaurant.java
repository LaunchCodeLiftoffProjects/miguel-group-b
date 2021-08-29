package org.launchcode.javawebdevtechjobsauthentication.models;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant extends AbstractEntity {

    @NotNull(message = "Name is required.")
    @Size(min=3, max=50, message = "Name must be between 3 and 50 characters long.")
    private String name;

//    @NotBlank (message = "Location is required.")
//    private String location;

    @NotNull(message = "Please enter whole number between 1 and 10.")
    private Integer rating;

    private static List<Location> location = new ArrayList<>();

    public Restaurant() {
    }

    // Initialize the id and value fields.
    public Restaurant(String aName,  Integer aRating) {
        super();
        this.name = aName;
        this.rating = aRating;
    }

    // Getters and setters.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Location> getLocation() {
        return location;
    }

    public static void setLocation(List<Location> location) {
        Restaurant.location = location;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name;
    }
}
