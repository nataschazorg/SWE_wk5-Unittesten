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
public class ContactTest {
    
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
        try {
            Contact c = new Contact("Floris");
        } catch (Exception e) {
            fail("Contact zou hier aangemaakt moeten zijn");
        }
        
        // Fouten
        try {
            Contact c = new Contact("");
            fail("Contact mag niet leeg zijn dus heir niet komen");
        } catch (IllegalArgumentException e) {
        }
        
        try {
            Contact c = new Contact(null);
            fail("Contact mag niet null zijn dus hier niet komen");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test of getName method, of class Contact.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Contact floris = new Contact("Floris");
        Contact johan = new Contact("Johan");
        assertEquals("Floris", floris.getName());
        assertEquals("Johan", johan.getName());

        // Extra controle voor de trim functie
        floris = new Contact("   Floris  ");
        johan = new Contact("  Johan   ");
        assertEquals("Floris", floris.getName());
        assertEquals("Johan", johan.getName());
    }

    /**
     * Test of removeAppointment method, of class Contact.
     */
    @Test
    public void testRemoveAppointment() {
        System.out.println("removeAppointment");
        Contact floris = new Contact("Floris");
        
        ITime bt = new Time(2016, 10, 14, 21, 00);
        ITime et = new Time(2016, 10, 14, 22, 00);
        ITimeSpan afspraak = new TimeSpan(bt, et);
        Appointment appointment = new Appointment("Werk afspraak", afspraak);
        Appointment appointment2 = new Appointment("Andere werk afspraak", afspraak);
        
        // 2 afspraken toevoegen
        floris.addAppointment(appointment);
        floris.addAppointment(appointment2);
        // eerste appointment verwijderen
        floris.removeAppointment(appointment);
        // De eerste appointment zou nu de 2e afspraak moeten zijn
        assertEquals(appointment2, floris.appointments().next());
    }

    /**
     * Test of addAppointment method, of class Contact.
     */
    @Test
    public void testAddAppointment() {
        System.out.println("addAppointment");
        Contact floris = new Contact("Floris");
        Contact johan = new Contact("Johan");
        
        ITime bt = new Time(2016, 10, 14, 21, 00);
        ITime et = new Time(2016, 10, 14, 22, 00);
        ITimeSpan afspraak = new TimeSpan(bt, et);
        Appointment appointment = new Appointment("Werk afspraak", afspraak);
        
        // Toevoegen moet goed gaan
        assertTrue(floris.addAppointment(appointment));
        assertTrue(johan.addAppointment(appointment));
        // Toevoegen moet fout gaan want deze bestaan al
        assertFalse(floris.addAppointment(appointment));
        assertFalse(johan.addAppointment(appointment));
        // Toevoegen moet fout gaan want de appointment mag nie null zijn
        assertFalse(floris.addAppointment(null));
        assertFalse(johan.addAppointment(null));
    }

    /**
     * Test of appointments method, of class Contact.
     */
    @Test
    public void testAppointments() {
        System.out.println("appointments");
        Contact floris = new Contact("Floris");
        ITime bt = new Time(2016, 10, 14, 21, 00);
        ITime et = new Time(2016, 10, 14, 22, 00);
        ITimeSpan afspraak = new TimeSpan(bt, et);
        Appointment appointment = new Appointment("Werk afspraak", afspraak);
        Appointment appointment2 = new Appointment("Andere werk afspraak", afspraak);
        
        floris.addAppointment(appointment);
        floris.addAppointment(appointment2);
        // iterator starten en loopen om te kijken of we alles terug krijgen
        Iterator<Appointment> i = floris.appointments();
        assertEquals(appointment, i.next());
        assertEquals(appointment2, i.next());
    }
    
}
