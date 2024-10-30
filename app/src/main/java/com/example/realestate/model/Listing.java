package com.example.realestate.model;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * This is the Listing class.
 * The Listing class represents a collection of properties and implements the Singleton pattern
 * to ensure that only one instance of the class is created.
 * This class contains an array list of Property objects and methods to load properties
 * from a CSV file.
 * It also provides methods to add, remove, and retrieve properties by location.
 *
 * @author Mahya Mottaghi
 */
public class Listing {
    private static ArrayList<Property> properties = null;

    /**
     * This is the constructor for the Listing class. I made it singelton to prevent multiple instances.
     * By invoking it for the first time, it creates a new instance of the Listing class and later
     * calls will return the same instance.
     */
    private Listing() {
    }

    public static Listing getInstance() {
        if (properties == null) {
            properties = new ArrayList<>();
        }
        return new Listing();

    }


    /**
     * Loads properties from the specified CSV file.
     *
     * @param inputStream which is passed by loadProperty in the MainActivity class.
     * throws Exeption if there is an error reading the file.
     */
    public void loadProperties(InputStream inputStream) {


        //reading data using buffered reader
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // splitting the read line by comma
                String[] parts = line.split(",");
                if (parts.length > 5) {

                    String id = parts[0];

                    if (id.startsWith("rp")) {
                    //creating a new ResidentialProperty object and adding it t the properties array list

                        System.out.println(id);
                        String location = parts[1];
                        double price = Double.parseDouble(parts[2].trim());
                        double annualHOAFee = Double.parseDouble(parts[3].trim());
                        int numBedrooms = Integer.parseInt(parts[4].trim());
                        double numBathrooms = Double.parseDouble(parts[5].trim());
                        ResidentialProperty property = new ResidentialProperty(id, location, price, annualHOAFee, numBedrooms, numBathrooms);

                        properties.add(property);


                    } else {
                     // creating a new CommercialProperty object and adding it to the properties array list
                        String location = parts[1];
                        double price = Double.parseDouble(parts[2].trim());
                        String zone = parts[3];
                        int numUnits = Integer.parseInt(parts[4].trim());
                        int numParking = Integer.parseInt(parts[5].trim());
                        CommercialProperty property = new CommercialProperty(id, location, price, zone, numUnits, numParking);

                        properties.add(property);

                        System.out.println(property.getId());
                    }


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //getter method to return the properties array list
    public ArrayList<Property> getAllProperties() {
        return properties;
    }

    //setter method to set the properties array list
    public static void setProperties(ArrayList<Property> properties) {
        Listing.properties = properties;
    }

    //    adding and removing properties from the properties array list
    public void addProperty(Property property) {
        properties.add(property);
    }

    public void removeProperty(Property property) {
        properties.remove(property);
    }


    /**
     * Retrieves a property based on its address.
     *
     * @param address The address of the property to retrieve.
     * @return The Property object matching the specified address, or null if not found.
     */
    public Property getProperty(String address) {

        for (Property property : properties) {
            if (property.getLocation().equals(address)) {
                return property;
            }
        }
        return null;
    }


}
