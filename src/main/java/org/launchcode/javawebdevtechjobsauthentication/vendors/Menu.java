package org.launchcode.javawebdevtechjobsauthentication.vendors;

import org.launchcode.javawebdevtechjobsauthentication.models.AbstractEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Menu extends AbstractEntity {

    @NotNull
    @Size(min=3, max=50)
    private String name;
    private String description;
    private Integer price;

    public Menu() {
    }

    // Initialize the id and value fields.

    public Menu(String aName, String aDescription, Integer aPrice) {
        super();
        this.name = aName;
        this.description = aDescription;
        this.price = aPrice;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }
}
    
    

