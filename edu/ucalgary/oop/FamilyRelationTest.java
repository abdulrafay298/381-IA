package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;

public class FamilyRelationTest {

    private DisasterVictim personOne = new DisasterVictim("John", "Dalan", "2024-01-19", "", 123, "2024-01-19");
    private DisasterVictim personTwo = new DisasterVictim("Jane", "Dalan", "2024-02-20", "", 124, "2024-02-20");
    private String relationshipTo = "sibling";
    private FamilyRelation testFamilyRelationObject = new FamilyRelation(personOne, relationshipTo, personTwo);

    @Test
    public void testObjectCreation() {
        assertNotNull(testFamilyRelationObject);
    }

    @Test
    public void testSetPersonOne() {
        DisasterVictim newPersonOne = new DisasterVictim("New Person", "Person", "2024-03-21", "", 125, "2024-03-21");
        testFamilyRelationObject.setPersonOne(newPersonOne);
        assertEquals("setPersonOne should update personOne", newPersonOne, testFamilyRelationObject.getPersonOne());
    }

    @Test
    public void testGetPersonOne() {
        assertEquals("getPersonOne should retrieve personOne", personOne, testFamilyRelationObject.getPersonOne());
    }

    @Test
    public void testSetPersonTwo() {
        DisasterVictim newPersonTwo = new DisasterVictim("Another", "Person", "2024-04-22", "", 126, "2024-04-22");
        testFamilyRelationObject.setPersonTwo(newPersonTwo);
        assertEquals("setPersonTwo should update personTwo", newPersonTwo, testFamilyRelationObject.getPersonTwo());
    }

    @Test
    public void testGetPersonTwo() {
        assertEquals("getPersonTwo should retrieve personTwo", personTwo, testFamilyRelationObject.getPersonTwo());
    }

    @Test
    public void testSetRelationshipTo() {
        String newRelationship = "parent";
        testFamilyRelationObject.setRelationshipTo(newRelationship);
        assertEquals("setRelationshipTo should update the relationship", newRelationship, testFamilyRelationObject.getRelationshipTo());
    }

    @Test
    public void testGetRelationshipTo() {
        assertEquals("getRelationshipTo should retrieve the relationship", relationshipTo, testFamilyRelationObject.getRelationshipTo());
    }

    @Test
    public void testIsValidRelationship() {
        assertTrue("isValidRelationship should return true when all fields are valid", testFamilyRelationObject.isValidRelationship());
    }

    @Test
    public void testIsDuplicateRelationship() {
        FamilyRelation.addRelationship(personOne, relationshipTo, personTwo);
        FamilyRelation duplicateRelation = new FamilyRelation(personOne, relationshipTo, personTwo);
        assertTrue("isDuplicateRelationship should return true for a duplicate relation", duplicateRelation.isDuplicateRelationship());
    }

    @Test
    public void testAddRelationship() {
        assertTrue("addRelationship should return true when adding a new valid relation", FamilyRelation.addRelationship(personOne, relationshipTo, personTwo));
        assertFalse("addRelationship should return false when adding a duplicate relation", FamilyRelation.addRelationship(personOne, relationshipTo, personTwo));
        assertFalse("addRelationship should return false when adding an invalid relation", FamilyRelation.addRelationship(null, "", null));
    }
   

    
}
