package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.Entity;

@Entity
public class Product extends AbstractEntity{

    private String name;
    private String description;
    private Double price;
    private String pictureURL;

    public Product(){}

    public Product(String name, String description, Double price, String pictureURL) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.pictureURL = pictureURL;
    }

    public Product(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
}
