package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class LocationTest {

    private Location testLocation;
    private DisasterVictim testVictim;
    private Supply testSupply;

    @Before
    public void setUp() {
        testLocation = new Location("Test Location", "123 Test Street");
        testVictim =  new DisasterVictim("John", "Dalan", "2024-01-19", "", 123, "2024-01-19");
        testSupply = new Supply("Water", 10);
    }

    @Test
    public void testObjectCreation() {
        assertNotNull("Location object should not be null", testLocation);
    }

    @Test
    public void testGetName() {
        assertEquals("Name should be 'Test Location'", "Test Location", testLocation.getName());
    }

    @Test
    public void testSetName() {
        testLocation.setName("New Location Name");
        assertEquals("Name should be updated to 'New Location Name'", "New Location Name", testLocation.getName());
    }

    @Test
    public void testGetAddress() {
        assertEquals("Address should be '123 Test Street'", "123 Test Street", testLocation.getAddress());
    }

    @Test
    public void testSetAddress() {
        testLocation.setAddress("456 New Street");
        assertEquals("Address should be updated to '456 New Street'", "456 New Street", testLocation.getAddress());
    }

    @Test
    public void testAddOccupant() {
        testLocation.addOccupant(testVictim);
        assertTrue("Occupant should be added to the location", testLocation.getOccupants().contains(testVictim));
    }

    @Test
    public void testRemoveOccupant() {
        testLocation.addOccupant(testVictim);
        testLocation.removeOccupant(testVictim);
        assertFalse("Occupant should be removed from the location", testLocation.getOccupants().contains(testVictim));
    }

    @Test
    public void testAddSupply() {
        testLocation.addSupply(testSupply);
        assertTrue("Supply should be added to the location", testLocation.getSupplies().contains(testSupply));
    }

    @Test
    public void testRemoveSupply() {
        testLocation.addSupply(testSupply);
        testLocation.removeSupply(testSupply);
        assertFalse("Supply should be removed from the location", testLocation.getSupplies().contains(testSupply));
    }

    @Test
    public void testAllocateSupplyToVictim() {
        testLocation.addSupply(testSupply);
        testLocation.allocateSupplyToVictim(testSupply, testVictim);
        assertTrue("Supply should be removed from the location", !testLocation.getSupplies().contains(testSupply));
        assertTrue("Supply should be added to the victim's personal belongings", testVictim.getPersonalBelongings().contains(testSupply));
    }
}
