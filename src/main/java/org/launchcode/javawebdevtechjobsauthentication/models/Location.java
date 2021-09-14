package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.Entity;
import java.security.PublicKey;

@Entity
public class Location extends AbstractEntity {

    private String name;

    private String service;

    private String address;

    public Location(){};

    public Location(String aName, String aService, String anAddress){
        super();
        this.name = aName;
        this.service = aService;
        this.address = anAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getMenu() {
        return address;
    }

    public void setMenu(String menu) {
        this.address = address;
    }

    @Override
    public String toString(){
        return name;
    }
}
