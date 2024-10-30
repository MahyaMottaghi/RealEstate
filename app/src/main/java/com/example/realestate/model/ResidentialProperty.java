package com.example.realestate.model;

/**
 * This is the ResidentialProperty class and extends the Property class.
 *
 * This class contains  double annualHOAFee, int bedrooms, double bathrooms.
 *
 * @author Mahya Mottaghi
 */
public class ResidentialProperty extends Property {
    private double annualHOAFee;
    private int bedrooms;
    private double bathrooms;

    // This is the constructor for the ResidentialProperty class.
    public ResidentialProperty(String id, String location, double price, double annualHOAFee, int bedrooms, double bathrooms) {

        super(id, location, price);
        this.annualHOAFee = annualHOAFee;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;

    }

    //The following are the getter and setter methods
    public double getAnnualHOAFee() {
        return annualHOAFee;
    }

    public void setAnnualHOAFee(double annualHOAFee) {
        this.annualHOAFee = annualHOAFee;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public double getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(double bathrooms) {
        this.bathrooms = bathrooms;
    }

    //This is the toString method override to print the details in readable format
    @Override
    public String toString() {
        return "ResidentialProperty{" +
                "annualHOAFee=" + annualHOAFee +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                '}';
    }
}
