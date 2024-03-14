package edu.ucalgary.oop;

import java.util.ArrayList;

public class Location {
    private String name;
    private String address;
    private ArrayList<DisasterVictim> occupants = new ArrayList<>(); 
    private ArrayList<Supply> supplies = new ArrayList<>(); 

    // Constructor
    public Location(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter and setter
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

    
    public ArrayList<DisasterVictim> getOccupants() {
        return new ArrayList<>(occupants); 
    }

    
    public void setOccupants(ArrayList<DisasterVictim> occupants) {
        this.occupants = new ArrayList<>(occupants); 
    }

    // Getter for supplies
    public ArrayList<Supply> getSupplies() {
        return new ArrayList<>(supplies); 
    }

    // Setter for supplies
    public void setSupplies(ArrayList<Supply> supplies) {
        this.supplies = new ArrayList<>(supplies); 
    }

    // Add an occupant to occupants
    public void addOccupant(DisasterVictim occupant) {
        occupants.add(occupant);
    }

    // Remove an occupant from occupants
    public void removeOccupant(DisasterVictim occupant) {
        occupants.remove(occupant);
    }

    // Add a supply to supplies
    public void addSupply(Supply supply) {
        supplies.add(supply);
    }

    // Remove a supply from supplies
    public void removeSupply(Supply supply) {
        supplies.remove(supply);
    }
    public void allocateSupplyToVictim(Supply supply, DisasterVictim victim) {
        // Check if the supply exists at the location
        if (!supplies.contains(supply)) {
            System.out.println("The supply does not exist at this location.");
            return;
        }
        
        // Remove the supply from the location's available supplies
        supplies.remove(supply);
        
        // Add the supply to the victim's personal belongings
        victim.addPersonalBelonging(supply);
        
    }
}
