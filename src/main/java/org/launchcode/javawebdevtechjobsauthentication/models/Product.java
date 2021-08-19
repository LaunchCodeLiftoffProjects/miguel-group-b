package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product extends AbstractEntity{

    @NotNull(message = "Product name is required")
    private String name;

    @NotNull
    @Size(min=3, max = 250, message = "must be longer than 3 characters")
    private String description;

    @NotNull
    private Double price;

    private String pictureURL;

    private Order order;

    public Product(){}

    public Product(String name, String description, Double price, String pictureURL, Order order) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.pictureURL = pictureURL;
        this.order=order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
