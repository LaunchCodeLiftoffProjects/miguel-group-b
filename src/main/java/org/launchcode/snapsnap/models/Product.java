package org.launchcode.snapsnap.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product extends AbstractEntity{
    
    @ManyToOne
    @JoinColumn (name = "menu_id")
    private Menu menu;

    private String name;
    private String description;
    private Double price;
    private String pictureURL;

    public Product(){}

    public Product(Menu aMenu, String aName, String aDescription, Double aPrice, String aPictureURL) {
        this.menu = aMenu;
        this.name = aName;
        this.description = aDescription;
        this.price = aPrice;
        this.pictureURL = aPictureURL;
    }

    public Product(String aName, String aDescription, Double aPrice) {
        this.name = aName;
        this.description = aDescription;
        this.price = aPrice;
    }

    public Product(String aName, Double aPrice) {
        this.name = aName;
        this.price = aPrice;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
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

    @Override
    public String toString() {
        return name + "  :  " + description;
    }
}
