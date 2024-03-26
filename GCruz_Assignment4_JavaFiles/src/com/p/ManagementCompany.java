/*
 * Class: CMSC203 30339
 * Instructor: Grinberg
 * Description: Write an application that lets the user create a management company and add the properties managed by the company to its list 
 * Due: 3/25/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gianpaulo Cruz
*/
package com.p;

public class ManagementCompany extends Object {
	
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    private String name;
    private String taxID;
    private double mgmFee;
    private Property[] properties;
    private Plot plot;

    public ManagementCompany() {
        this("", "", 0.0);
    }

    public ManagementCompany(String name, String taxID, double mgmFee) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
    }

    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
    }

    public ManagementCompany(ManagementCompany otherCompany) {
        this.name = otherCompany.name;
        this.taxID = otherCompany.taxID;
        this.mgmFee = otherCompany.mgmFee;
        this.plot = new Plot(otherCompany.plot);
        this.properties = new Property[MAX_PROPERTY];
    }

    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(name, city, rent, owner, 0, 0, 1, 1);
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    public int addProperty(Property property) {
        if (property == null)
            return -2;
        
        if (!plot.encompasses(property.getPlot()))
            return -3;
        
        for (int i = 0; i < properties.length; i++) {
            if (properties[i] == null)
                continue;
            if (properties[i].getPlot().overlaps(property.getPlot()))
                return -4;
        }
        for (int i = 0; i < properties.length; i++) {
            if (properties[i] == null) {
                properties[i] = property;
                return i;
            }
        }
        return -1; 
    }

    public void removeLastProperty() {
        for (int i = properties.length - 1; i >= 0; i--) {
            if (properties[i] != null) {
                properties[i] = null;
                return;
            }
        }
    }

    public boolean isPropertiesFull() {
        for (Property property : properties) {
            if (property == null)
                return false;
        }
        return true;
    }

    public int getPropertiesCount() {
        int count = 0;
        for (Property property : properties) {
            if (property != null)
                count++;
        }
        return count;
    }

    public double getTotalRent() {
        double totalRent = 0.0;
        for (Property property : properties) {
            if (property != null)
                totalRent += property.getRentAmount();
        }
        return totalRent;
    }

    public Property getHighestRentProperty() {
        Property highestRentProperty = null;
        double maxRent = Double.MIN_VALUE;
        for (Property property : properties) {
            if (property != null && property.getRentAmount() > maxRent) {
                maxRent = property.getRentAmount();
                highestRentProperty = property;
            }
        }
        return highestRentProperty;
    }

    public boolean isManagementFeeValid() {
        return mgmFee >= 0 && mgmFee <= 100;
    }

    public String getName() {
        return name;
    }

    public String getTaxID() {
        return taxID;
    }

    public double getMgmFeePer() {
        return mgmFee;
    }

    public Plot getPlot() {
        return plot;
    }

    public Property[] getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name).append(", taxID: ").append(taxID).append("\n");
        sb.append("______________________________________________________\n");
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] != null) sb.append(properties[i].toString()).append("\n");
        }
        sb.append("______________________________________________________\n\n");
        sb.append(" total management Fee: ").append(getTotalRent() * (mgmFee/ 100));
        return sb.toString();
    }
}

