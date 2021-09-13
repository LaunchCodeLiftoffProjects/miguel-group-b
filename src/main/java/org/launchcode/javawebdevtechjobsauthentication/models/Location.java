package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.Entity;
import java.security.PublicKey;

@Entity
public class Location extends AbstractEntity {

    private String name;

    private String service;

    private String menu;

    public Location(){};

    public Location(String aName, String aService, String aMenu){
        super();
        this.name = aName;
        this.service = aService;
        this.menu = aMenu;
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
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    @Override
    public String toString(){
        return name;
    }
}
