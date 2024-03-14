package edu.ucalgary.oop;
import java.util.ArrayList;

public class Inquirer extends Person {
    private String info;
    private String servicesPhone;
    private ArrayList<String> interactions;

    public Inquirer(String firstName, String lastName, String info, String servicesPhone) {
        super(firstName, lastName);
        this.info = info;
        this.servicesPhone = servicesPhone;
        this.interactions = new ArrayList<>();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getServicesPhone() {
        return servicesPhone;
    }

    public void setServicesPhone(String servicesPhone) {
        this.servicesPhone = servicesPhone;
    }

    public void addInteraction(String interaction) {
        interactions.add(interaction);
    }
    public ArrayList<String> getInteractions() {
        return interactions;
    }

    public void clearInteractions() {
        interactions.clear();
    }
}
