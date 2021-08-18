package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Menu extends AbstractEntity {

    @OneToMany(mappedBy = "menu")
    @JoinColumn
    private List<Product> productList;

    private String restaurantTitle;


    public Menu() {
    }

    public Menu(String restaurantTitle, List<Product> productList) {
        this.restaurantTitle = restaurantTitle;
        this.productList = productList;
    }

    public String getRestaurantTitle() {
        return restaurantTitle;
    }

    public void setRestaurantTitle(String restaurantTitle) {
        this.restaurantTitle = restaurantTitle;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}


