package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;

import java.beans.Transient;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import static org.junit.Assert.*;


public class DisasterVictimTest {
    private DisasterVictim disasterVictim;

    @Before
    public void setUp() {
        disasterVictim = new DisasterVictim("John", "Doe", "1990-01-01", "", 123, "2024-01-01");
    }

    @Test
    public void testObjectCreation() {
        assertNotNull(disasterVictim);
    }
    @Test
    public void testSetFirstName() {
        disasterVictim.setFirstName("Jane");
        assertEquals("Jane", disasterVictim.getFirstName());
    }

    @Test
    public void testGetFirstName() {
        assertEquals("John", disasterVictim.getFirstName());
    }

    @Test
    public void testSetLastName() {
        disasterVictim.setLastName("Smith");
        assertEquals("Smith", disasterVictim.getLastName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Doe", disasterVictim.getLastName());
    }
    @Test
public void testSetGender() {
    disasterVictim.setGender("man");
    assertEquals("man", disasterVictim.getGender());
}

@Test
public void testGetGender() {
    disasterVictim.setGender("woman");
    assertEquals("woman", disasterVictim.getGender());
}

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidGender() {
        disasterVictim.setGender("Invalid");
    }

    @Test
    public void testGenerateSocialID() {
        int initialID = disasterVictim.generateSocialID();
        int newID = disasterVictim.generateSocialID();
        assertEquals(initialID + 1, newID);
    }

    @Test
    public void testAddPersonalBelonging() {
        Supply supply = new Supply("Water", 1);
        disasterVictim.addPersonalBelonging(supply);
        assertTrue(disasterVictim.getPersonalBelongings().contains(supply));

        
    }
    @Test
    public void testRemovePersonalBelonging() {
        Supply supply = new Supply("Water", 1);

        disasterVictim.removePersonalBelonging(supply);
        assertTrue(!disasterVictim.getPersonalBelongings().contains(supply));
    }

    @Test
    public void testAddFamilyConnection() {
        FamilyRelation familyRelation = new FamilyRelation(disasterVictim, "Sibling", null);
        disasterVictim.addFamilyConnection(familyRelation);
        assertTrue(disasterVictim.getFamilyConnections().contains(familyRelation));

        
    }
    @Test
    public void testRemoveFamilyConnection() {
        FamilyRelation familyRelation = new FamilyRelation(disasterVictim, "Sibling", null);
    

        disasterVictim.removeFamilyConnection(familyRelation);
        assertTrue(!disasterVictim.getFamilyConnections().contains(familyRelation));
    }

    @Test
    public void testAddMedicalRecord() {
        Location location = new Location("Hospital", "123 Street");
        MedicalRecord medicalRecord = new MedicalRecord(location, "Treatment", "2024-01-01");
        disasterVictim.addMedicalRecord(medicalRecord);
        assertTrue(disasterVictim.getMedicalRecords().contains(medicalRecord));

    }
    @Test
    public void testRemoveMedicalRecord() {
        Location location = new Location("Hospital", "123 Street");
        MedicalRecord medicalRecord = new MedicalRecord(location, "Treatment", "2024-01-01");

        disasterVictim.removeMedicalRecord(medicalRecord);
        assertTrue(!disasterVictim.getMedicalRecords().contains(medicalRecord));
    }

    @Test
    public void testAddDietaryRestriction() {
        DietaryRestriction restriction = DietaryRestriction.AVML;
        disasterVictim.addDietaryRestriction(restriction);
        assertTrue(disasterVictim.getDietaryRestrictions().contains(restriction));

    }
    @Test
    public void testRemoveDietaryRestriction() {
        DietaryRestriction restriction = DietaryRestriction.AVML;
        disasterVictim.removeDietaryRestriction(restriction);
        assertTrue(!disasterVictim.getDietaryRestrictions().contains(restriction));
    }

}
