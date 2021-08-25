package org.launchcode.javawebdevtechjobsauthentication.models;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Restaurant extends AbstractEntity {

    @NotNull
    @Size(min=3, max=50)
    private String name;
    private String location;
    private String rating;

    public Restaurant() {
    }

    // Initialize the id and value fields.
    public Restaurant(String nameame, String locationocation, String rating) {
        super();
        this.name = name;
        this.location = location;
        this.rating = rating;
    }

    // Getters and setters.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setEmployer(String employer) {
        this.location = location;
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
