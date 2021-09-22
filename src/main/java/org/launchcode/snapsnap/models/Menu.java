package org.launchcode.snapsnap.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {


    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany (mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    @NotNull
    @Size(min=3, max=50)
    private String facility;
    private String city;
    private String State;
    private String address;
    private String serviceDescription;

    public Menu(){}

    public Menu(Integer id, String facility,
                String city, String state, String address, String serviceDescription) {
        this.id = id;
        this.facility = facility;
        this.city = city;
        State = state;
        this.address = address;
        this.serviceDescription = serviceDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return facility;
    }
}

    

