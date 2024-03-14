package edu.ucalgary.oop;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class InquirerTest {
    
    private Inquirer inquirer;
    private String expectedFirstName = "John";
    private String expectedLastName = "Smith";
    private String expectedInfo = "Test info";
    private String expectedServicesPhone = "123-456-7890";
    private String expectedInteraction = "Test interaction";

    @Before
    public void setUp() {
        inquirer = new Inquirer(expectedFirstName, expectedLastName, expectedInfo, expectedServicesPhone);
    }

    @Test
    public void testGetFirstName() {
        assertEquals(expectedFirstName, inquirer.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals(expectedLastName, inquirer.getLastName());
    }

    @Test
    public void testGetInfo() {
        assertEquals(expectedInfo, inquirer.getInfo());
    }

    @Test
    public void testSetInfo() {
        String newInfo = "New info";
        inquirer.setInfo(newInfo);
        assertEquals(newInfo, inquirer.getInfo());
    }

    @Test
    public void testGetServicesPhone() {
        assertEquals(expectedServicesPhone, inquirer.getServicesPhone());
    }

    @Test
    public void testSetServicesPhone() {
        String newServicesPhone = "987-654-3210";
        inquirer.setServicesPhone(newServicesPhone);
        assertEquals(newServicesPhone, inquirer.getServicesPhone());
    }

    @Test
    public void testAddInteraction() {
        inquirer.addInteraction(expectedInteraction);
        assertEquals(1, inquirer.getInteractions().size());
        assertEquals(expectedInteraction, inquirer.getInteractions().get(0));
    }

    @Test
    public void testClearInteractions() {
        inquirer.addInteraction(expectedInteraction);
        inquirer.clearInteractions();
        assertEquals(0, inquirer.getInteractions().size());
    }
}
