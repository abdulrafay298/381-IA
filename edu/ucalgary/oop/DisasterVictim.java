package edu.ucalgary.oop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DisasterVictim extends Person implements DisasterVictimEntryInterface {
    private static int counter = 0;
    private String dateOfBirth;
    private String comments;
    private int ASSIGNED_SOCIAL_ID;
    private ArrayList<MedicalRecord> medicalRecords;
    private ArrayList<FamilyRelation> familyConnections;
    private String ENTRY_DATE;
    private ArrayList<Supply> personalBelongings;
    private String gender;
    private int approximateAge;
    private Scanner scanner;
    private ArrayList<DietaryRestriction> dietaryRestrictions;

    public DisasterVictim(String firstName, String lastName, String dateOfBirth, String comments, int ASSIGNED_SOCIAL_ID, String ENTRY_DATE) {
        super(firstName, lastName);
        this.dateOfBirth = dateOfBirth;
        this.comments = comments;
        this.medicalRecords = new ArrayList<>();
        this.familyConnections = new ArrayList<>();
        this.personalBelongings = new ArrayList<>();
        this.dietaryRestrictions = new ArrayList<>();
        if (!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
        this.ENTRY_DATE = ENTRY_DATE;
        this.ASSIGNED_SOCIAL_ID = ASSIGNED_SOCIAL_ID;
    }
    private static boolean isValidDateFormat(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
        return date.matches(dateFormatPattern);
    }

    // Getters and setters

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (!isValidDateFormat(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date format for date of birth. Expected format: YYYY-MM-DD");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getASSIGNED_SOCIAL_ID() {
        return ASSIGNED_SOCIAL_ID;
    }

    public ArrayList<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public String getENTRY_DATE() {
        return ENTRY_DATE;
    }

    public ArrayList<Supply> getPersonalBelongings() {
        return personalBelongings;
    }

    public ArrayList<FamilyRelation> getFamilyConnections() {
        return familyConnections;
    }

    public void setGender(String gender) {
        Set<String> validGenders = readGenderOptionsFromFile();
    
        if (!validGenders.contains(gender.toLowerCase())) {
            throw new IllegalArgumentException("Invalid gender. Acceptable values are: " + String.join(", ", validGenders));
        }
    
        this.gender = gender.toLowerCase(); 
    }
    
    public String getGender() {
        Set<String> validGenders = readGenderOptionsFromFile();
    
        if (!validGenders.contains(gender.toLowerCase())) {
            throw new IllegalArgumentException("Invalid gender. Acceptable values are: " + String.join(", ", validGenders));
        }
    
        return gender;
    }
    
    public Set<String> readGenderOptionsFromFile() {
        Set<String> genderOptions = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(".\\edu\\ucalgary\\oop\\GenderOptions.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                genderOptions.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }
        return genderOptions;
    }

    public int getApproximateAge() {
        return approximateAge;
    }

    public void setApproximateAge(int approximateAge) {
        this.approximateAge = approximateAge;
    }

    public ArrayList<DietaryRestriction> getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    // Methods

    public static int generateSocialID() {
        counter++;
        return counter;
    }

    public void addPersonalBelonging(Supply supply) {
        personalBelongings.add(supply);
    }

    public void removePersonalBelonging(Supply supply) {
        personalBelongings.remove(supply);
    }

    public void addFamilyConnection(FamilyRelation familyConnection) {
        familyConnections.add(familyConnection);
    }

    public void removeFamilyConnection(FamilyRelation familyConnection) {
        familyConnections.remove(familyConnection);
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
    }
    public void removeMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.remove(medicalRecord);
    }

    public void addDietaryRestriction(DietaryRestriction restriction) {
        dietaryRestrictions.add(restriction);
    }

    public void removeDietaryRestriction(DietaryRestriction restriction) {
        dietaryRestrictions.remove(restriction);
    }

    @Override
    public void enterDisasterVictimInformation() {
        System.out.println("Enter Disaster Victim Information:");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        // Set the entered disaster victim information
        setFirstName(firstName);
        setLastName(lastName);
    }

    @Override
    public void enterRelationshipInformation() {
        System.out.println("Enter Relationship Information:");
    
        String relationship = scanner.nextLine();
        
        
        
        FamilyRelation newRelation = new FamilyRelation(this, relationship, null);
        
        // Add the family relation to the list
        if (familyConnections == null) {
            familyConnections = new ArrayList<>();
        }
        familyConnections.add(newRelation);
    }
    

    @Override
    public void enterMedicalRecordInformation() {
        System.out.println("Enter Medical Record Information:");
    
    // Prompt the user to input medical record information
    System.out.print("Location Name: ");
    String locationName = scanner.nextLine();
    System.out.print("Location Address: ");
    String locationAddress = scanner.nextLine();
    Location location = new Location(locationName, locationAddress);
    
    System.out.print("Medical Treatment Details: ");
    String treatmentDetails = scanner.nextLine();
    
    System.out.print("Date of Treatment (YYYY-MM-DD): ");
    String dateOfTreatment = scanner.nextLine();
    
    // Create the medical record object
    try {
        MedicalRecord medicalRecord = new MedicalRecord(location, treatmentDetails, dateOfTreatment);
        // Now you can do whatever you want with the medical record object
    } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
    }
    }
}

interface DisasterVictimEntryInterface {
    void enterDisasterVictimInformation();
    void enterRelationshipInformation();
    void enterMedicalRecordInformation();
}

enum DietaryRestriction {
    AVML,
    DBML,
    GFML,
    KSML,
    LSML,
    MOML,
    PFML,
    VGML,
    VJML
}
