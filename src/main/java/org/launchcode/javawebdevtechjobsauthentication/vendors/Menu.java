package org.launchcode.javawebdevtechjobsauthentication.vendors;

import org.launchcode.javawebdevtechjobsauthentication.models.AbstractEntity;
import org.launchcode.javawebdevtechjobsauthentication.models.Product;
import org.launchcode.javawebdevtechjobsauthentication.users.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu extends AbstractEntity {

//    @ManyToOne
//    @JoinColumn (name = "user_id")
//    private User user;


    @OneToMany (mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Product> product = new ArrayList<>();

    @NotNull
    @Size(min=3, max=50)
    private String facility;
    private String city;
    private String State;
    private String address;
    private String serviceDescription;

    public Menu() {
    }

    public Menu(List<Product> product, String facility, String city, String state, String address, String serviceDescription) {
        this.product = product;
        this.facility = facility;
        this.city = city;
        State = state;
        this.address = address;
        this.serviceDescription = serviceDescription;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "product=" + product +
                ", facility='" + facility + '\'' +
                ", city='" + city + '\'' +
                ", State='" + State + '\'' +
                ", address='" + address + '\'' +
                ", serviceDescription='" + serviceDescription + '\'' +
                '}';
    }
}

    

