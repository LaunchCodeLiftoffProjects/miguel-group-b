package org.launchcode.javawebdevtechjobsauthentication.vendors;

import org.launchcode.javawebdevtechjobsauthentication.models.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Location extends AbstractEntity {

    @NotNull
    @Size(min=3, max=50)
    private String name;
    private String address;
    private String service;



    @ManyToMany
//            (mappedBy = "")
//    ,cascade = CascadeType.ALL)
    private List<Menu> menus = new ArrayList<>();

    public Location() {
    }

    // Initialize the id and value fields.
    public Location(String aName, String anAddress, String someService) {
        super();
        this.name = aName;
        this.address = anAddress;
        this.service = someService;

    }

    // Getters and setters.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public List<Menu> getMenus() {
        return menus;
    }


    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return name;
    }
}
