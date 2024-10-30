package com.example.realestate.model;

/**
 * This is the CommercialProperty class and extends the Property class.
 * This class contains  String zone, int numUnits, int numParking.
 *
 * @author Mahya Mottaghi
 */
public class CommercialProperty extends Property {

    private String zone;
    private int numUnits;
    private int numParking;

    // This is the constructor for the CommercialProperty class.
    public CommercialProperty(String id, String location, double price, String zone, int numUnits, int numParking) {
        super(id, location, price);
        this.zone = zone;
        this.numUnits = numUnits;
        this.numParking = numParking;

    }
    //The following are the getter and setter methods
    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public int getNumUnits() {
        return numUnits;
    }

    public void setNumUnits(int numUnits) {
        this.numUnits = numUnits;
    }

    public int getNumParking() {
        return numParking;
    }

    public void setNumParking(int numParking) {
        this.numParking = numParking;
    }

    //This is the toString method override to print the details in readable format
    @Override
    public String toString() {
        return "CommercialProperty{" +
                "zone='" + zone + '\'' +
                ", numUnits=" + numUnits +
                ", numParking=" + numParking +
                '}';
    }
}
