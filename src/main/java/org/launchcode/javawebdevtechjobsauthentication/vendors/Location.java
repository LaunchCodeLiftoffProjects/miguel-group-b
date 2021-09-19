package org.launchcode.javawebdevtechjobsauthentication.vendors;

import org.launchcode.javawebdevtechjobsauthentication.models.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;


public class Location extends AbstractEntity {

    @NotNull
    @Size(min=3, max=50)
    private String facility;
    private String city;
    private String State;
    private String address;
    private String serviceDescription;

    public Location() {
        super();
    }



    // Initialize the id and value fields.

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
        return facility;
    }


}
