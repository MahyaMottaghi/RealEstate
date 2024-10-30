package com.example.realestate.model;

/**
 * This is an abstract class representing a property.
 * This class contains  String id , String location, double price.
 * These common attributes shared by all properties.
 *
 * @author Mahya Mottaghi
 */

public abstract class Property {
    private String id;
    private String location;
    private double price;

    // This is the constructor for the Property class.
    public Property(String id, String location, double price) {
        this.id = id;
        this.location = location;
        this.price = price;

    }

    //The following are the getter methods
    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    //The following are the setter methods
    public void setId(String id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //This is the toString method override to print the property details
    @Override
    public String toString() {
        return "Property{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                '}';
    }
}
