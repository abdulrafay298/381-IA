package edu.ucalgary.oop;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReliefService implements ReliefServiceInterface {
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private String dateOfInquiry;
    private String infoProvided;
    private Location lastKnownLocation;
    private ArrayList<DisasterVictim> disasterVictims;
    private ArrayList<String> inquirerQueries = new ArrayList<>();
    private Scanner scanner;

    // Constructor
    public ReliefService(Inquirer inquirer, DisasterVictim missingPerson, String dateOfInquiry, String infoProvided, Location lastKnownLocation) {
        this.inquirer = inquirer;
        this.missingPerson = missingPerson;
        setDateOfInquiry(dateOfInquiry);
        this.infoProvided = infoProvided;
        this.lastKnownLocation = lastKnownLocation;
       
    }


    // Getter and setter methods

    public Inquirer getInquirer() {
        return inquirer;
    }

    public void setInquirer(Inquirer inquirer) {
        this.inquirer = inquirer;
    }

    public DisasterVictim getMissingPerson() {
        return missingPerson;
    }

    public void setMissingPerson(DisasterVictim missingPerson) {
        this.missingPerson = missingPerson;
    }

    public String getDateOfInquiry() {
        return dateOfInquiry;
    }
    public void setDisasterVictims(ArrayList<DisasterVictim> victims) {
        this.disasterVictims = victims;
    }

    public void setDateOfInquiry(String dateOfInquiry) {
        // Check if the dateOfInquiry string matches the expected date format
        if (!isValidDateFormat(dateOfInquiry)) {
            throw new IllegalArgumentException("Invalid date format for date of inquiry. Expected format: YYYY-MM-DD");
        }
        this.dateOfInquiry = dateOfInquiry;
    }

    public String getInfoProvided() {
        return infoProvided;
    }

    public void setInfoProvided(String infoProvided) {
        this.infoProvided = infoProvided;
    }

    public Location getLastKnownLocation() {
        return lastKnownLocation;
    }

    public void setLastKnownLocation(Location lastKnownLocation) {
        this.lastKnownLocation = lastKnownLocation;
    }

    
    public boolean isValidDateFormat(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Implementation of ReliefServiceInterface methods

    @Override
    public void logInquirerQuery() {
        System.out.println("Enter log query");
        String query = scanner.nextLine();
        inquirerQueries.add(query);
        System.out.println("Inquirer query logged: " + query);
    }

    @Override
public void searchForDisasterVictims() {
    System.out.println("searchTerm");
    String searchTerm = scanner.nextLine();
    searchTerm = searchTerm.toLowerCase();
    
    // Iterate through the list of disaster victims and check if their names contain the searchTerm
    for (DisasterVictim victim : disasterVictims) {
        // Convert victim's name to lowercase for case-insensitive comparison
        String victimName = victim.getFirstName().toLowerCase() + " " + victim.getLastName().toLowerCase();
        // Check if the victim's name contains the searchTerm
        if (victimName.contains(searchTerm)) {
            // If a matching victim is found, print the details and return true
            System.out.println("Found matching disaster victim: " + victim.getFirstName() + " " + victim.getLastName());
            
        }
    }
    
    // If no matching victim is found, print a message and return false
    System.out.println("No matching disaster victims found.");
   
}

    

    // Additional method to get log details
    public String getLogDetails() {
        // Construct log details string
        return String.format("Inquirer: %s, Missing Person: %s %s, Date of Inquiry: %s, Info Provided: %s, Last Known Location: %s",
                inquirer.getFirstName(), missingPerson.getFirstName(),missingPerson.getLastName(), dateOfInquiry.toString(), infoProvided, lastKnownLocation.getName());
    }
}

interface ReliefServiceInterface {
    void logInquirerQuery();
    void searchForDisasterVictims();
}
