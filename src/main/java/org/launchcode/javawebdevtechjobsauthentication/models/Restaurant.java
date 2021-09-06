package org.launchcode.javawebdevtechjobsauthentication.models;



import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Restaurant extends AbstractEntity {


//    @NotBlank(message = "Location is required.")
//    private String location;
//

    private Integer rating;


//    @JoinColumn
    private final ArrayList<Location> locations = new ArrayList<>();

   public Restaurant(){

   }

    // Initialize the id and value fields.
    public Restaurant( Integer rating) {
        super();
        this.rating = rating;
    }

    // Getters and setters.


    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public  ArrayList<Location> getLocations() {
        return (ArrayList<Location>) locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations.addAll(locations);
    }
}
