package org.launchcode.javawebdevtechjobsauthentication.models;



import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Restaurant extends AbstractEntity {


    @NotBlank(message = "Location is required.")
    private String location;
    private String  rating;


//    @JoinColumn
//    private final ArrayList<Location> locations = new ArrayList<>();

   public Restaurant(){

   }

    // Initialize the id and value fields.
    public Restaurant( String location, String  rating) {
        super();
        this.rating = rating;
    }

    // Getters and setters.


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String  getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


}
