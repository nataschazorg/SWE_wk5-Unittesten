/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author floris
 */
public class AppointmentTest {

    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void testConstructor() {
        System.out.println("Constructor");
        // Standaard
        try {
            Time bt = new Time(2016, 10, 14, 21, 00);
            Time et = new Time(2016, 10, 14, 22, 00);
            TimeSpan afspraak = new TimeSpan(bt, et);
            Appointment appointment = new Appointment("Een nieuwe werk afspraak", afspraak);
        } catch (IllegalArgumentException ex) {
            fail("De appointment zou hier aangemaakt moeten zijn");
        }
          
        // Standaard
        try {
            Time bt = new Time(2016, 9, 12, 21, 00);
            Time et = new Time(2016, 9, 12, 22, 00);
            TimeSpan afspraak = new TimeSpan(bt, et);
            Appointment appointment = new Appointment("Een nieuwe werk afspraak", afspraak);
            fail("De appointment mag niet gemaakt zijn deze is in het verleden");
        } catch (IllegalArgumentException ex) {
        }        
    }
    /**
     * Test of getSubject method, of class Appointment.
     */
    @Test
    public void testGetSubject() {
        System.out.println("getSubject");
        Time bt = new Time(2016, 10, 14, 21, 00);
        Time et = new Time(2016, 10, 14, 22, 00);
        TimeSpan afspraak = new TimeSpan(bt, et);
        Appointment appointment = new Appointment("Een nieuwe werk afspraak", afspraak);
        assertEquals("Een nieuwe werk afspraak", appointment.getSubject());

        // Controle op spaties
        bt = new Time(2016, 10, 14, 21, 00);
        et = new Time(2016, 10, 14, 22, 00);
        afspraak = new TimeSpan(bt, et);
        appointment = new Appointment("    Een nieuwe werk afspraak  ", afspraak);
        assertEquals("Een nieuwe werk afspraak", appointment.getSubject());
    }

    /**
     * Test of getTimeSpan method, of class Appointment.
     */
    @Test
    public void testGetTimeSpan() {
        System.out.println("getTimeSpan");
        // Tijd controleren
        Time bt = new Time(2016, 10, 14, 21, 00);
        Time et = new Time(2016, 10, 14, 22, 00);
        TimeSpan afspraak = new TimeSpan(bt, et);
        Appointment appointment = new Appointment("Een nieuwe werk afspraak", afspraak);
        assertEquals(afspraak.getBeginTime(), appointment.getTimeSpan().getBeginTime());
        assertEquals(afspraak.getEndTime(), appointment.getTimeSpan().getEndTime());
        
        // Nog een keer tijd controleren
        bt = new Time(2016, 10, 14, 14, 00);
        et = new Time(2016, 10, 14, 15, 00);
        afspraak = new TimeSpan(bt, et);
        appointment = new Appointment("Een tweede werk afspraak", afspraak);
        assertEquals(afspraak.getBeginTime(), appointment.getTimeSpan().getBeginTime());
        assertEquals(afspraak.getEndTime(), appointment.getTimeSpan().getEndTime());
    }

    /**
     * Test of invitees method, of class Appointment.
     */
    @Test
    public void testInvitees() {
        System.out.println("invitees");
        Contact floris = new Contact("Floris");
        Contact johan = new Contact("Johan");
        
        ITime bt = new Time(2016, 10, 14, 21, 00);
        ITime et = new Time(2016, 10, 14, 22, 00);
        ITimeSpan afspraak = new TimeSpan(bt, et);
        Appointment appointment = new Appointment("Werk afspraak", afspraak);

        appointment.addContact(floris);
        appointment.addContact(johan);
        
        // Via iterator kunnen we de contacten ophalen
        Iterator<Contact> i = appointment.invitees();
        assertEquals(floris.getName(), i.next().getName());
        assertEquals(johan.getName(), i.next().getName());
    }

    /**
     * Test of addContact method, of class Appointment.
     */
    @Test
    public void testAddContact() {
        System.out.println("addContact");
        Contact floris = new Contact("Floris");
        Contact johan = new Contact("Johan");
        ITime bt = new Time(2016, 10, 14, 21, 00);
        ITime et = new Time(2016, 10, 14, 22, 00);
        ITimeSpan afspraak = new TimeSpan(bt, et);
        Appointment appointment = new Appointment("Werk afspraak", afspraak);
        
        // Eerst toevoegen
        assertTrue(appointment.addContact(floris));
        assertTrue(appointment.addContact(johan));
        
        // Daarna legen toevoegen of al bestaande
        assertFalse(appointment.addContact(floris));
        assertFalse(appointment.addContact(johan));
        assertFalse(appointment.addContact(null));
    }

    /**
     * Test of removeContact method, of class Appointment.
     */
    @Test
    public void testRemoveContact() {
        System.out.println("removeContact");
        Contact floris = new Contact("Floris");
        Contact johan = new Contact("Johan");
        ITime bt = new Time(2016, 10, 14, 21, 00);
        ITime et = new Time(2016, 10, 14, 22, 00);
        ITimeSpan afspraak = new TimeSpan(bt, et);
        Appointment appointment = new Appointment("Werk afspraak", afspraak);
        
        appointment.addContact(floris);
        appointment.addContact(johan);
        appointment.removeContact(floris);
        
        // Als we floris goed hebben verwijderd zou johan de volgende in de lijst moeten zijn
        assertEquals(johan, appointment.invitees().next());
    }
}
