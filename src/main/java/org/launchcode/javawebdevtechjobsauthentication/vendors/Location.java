//package org.launchcode.javawebdevtechjobsauthentication.vendors;
//
//import org.launchcode.javawebdevtechjobsauthentication.models.AbstractEntity;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//@Entity
//public abstract class Location extends AbstractEntity {
//
//    @NotNull
//    @Size(min=3, max=50)
//    private String name;
//    private String address;
//    private String service;
//
//    public Location() {
//    }
//
//    // Initialize the id and value fields.
//    public Location(String aName, String anAddress, String someService) {
//        super();
//        this.name = aName;
//        this.address = anAddress;
//        this.service = someService;
//    }
//
//    // Getters and setters.
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getService() {
//        return service;
//    }
//
//    public void setService(String service) {
//        this.service = service;
//    }
//
//    @Override
//    public String toString() {
//        return name;
//    }
//}
