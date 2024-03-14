package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;

public class SupplyTest {

    String expectedType = "Tent";
    int expectedQuantity = 10;
    private Supply supply = new Supply(expectedType, expectedQuantity);

    @Test
    public void testObjectCreation() {
        assertNotNull("Supply object should not be null", supply);
    }

    @Test
    public void testGetType() {
        assertEquals("getType should return the correct type", expectedType, supply.getType());
    }

    @Test
    public void testSetType() {
        String newType = "Food";
        supply.setType(newType);
        assertEquals("setType should update the type", newType, supply.getType());
    }

    @Test
    public void testGetQuantity() {
        assertEquals("getQuantity should return the correct quantity", expectedQuantity, supply.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        int newQuantity = 20;
        supply.setQuantity(newQuantity);
        assertEquals("setQuantity should update the quantity", newQuantity, supply.getQuantity());
    }
}
