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
    ITime bt;
    ITime et;
    ITimeSpan afspraak;
    Appointment appointment;
    
    Contact floris;
    Contact johan;

    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        bt = new Time(2016, 10, 14, 21, 00);
        et = new Time(2016, 10, 14, 22, 00);
        afspraak = new TimeSpan(bt, et);
        appointment = new Appointment("Werk afspraak", afspraak);
        
        floris = new Contact("Floris");
        johan = new Contact("Johan");
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void testConstructor() {
        System.out.println("Constructor");
        // Standaard
        try {
            bt = new Time(2016, 10, 14, 21, 00);
            et = new Time(2016, 10, 14, 22, 00);
            afspraak = new TimeSpan(bt, et);
            appointment = new Appointment("Een nieuwe werk afspraak", afspraak);
        } catch (IllegalArgumentException ex) {
            fail("De appointment zou hier aangemaakt moeten zijn");
        }
          
        // Standaard
        try {
            bt = new Time(2016, 9, 12, 21, 00);
            et = new Time(2016, 9, 12, 22, 00);
            afspraak = new TimeSpan(bt, et);
            appointment = new Appointment("Een nieuwe werk afspraak", afspraak);
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
        assertEquals("Werk afspraak", appointment.getSubject());

        // Controle op spaties
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
        
        appointment.addContact(floris);
        appointment.addContact(johan);
        appointment.removeContact(floris);
        
        // Als we floris goed hebben verwijderd zou johan de volgende in de lijst moeten zijn
        assertEquals(johan, appointment.invitees().next());
    }

    /**
     * Test of getBeginTime method, of class Appointment.
     */
    @Test
    public void testGetBeginTime() {
        System.out.println("getBeginTime");
        ITime expResult = new Time(2016, 10, 14, 21, 00);
        ITime result = appointment.getBeginTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndTime method, of class Appointment.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");
        ITime expResult = new Time(2016, 10, 14, 22, 00);
        ITime result = appointment.getEndTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of length method, of class Appointment.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        int expResult = 60;
        int result = appointment.length();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBeginTime method, of class Appointment.
     */
    @Test
    public void testSetBeginTime() {
        System.out.println("setBeginTime");
        ITime beginTime = new Time(2016, 10, 14, 21, 00);
        afspraak.setBeginTime(beginTime);
        assertEquals(afspraak.getBeginTime(), beginTime);
    }

    /**
     * Test of setEndTime method, of class Appointment.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        ITime endTime = new Time(2016, 10, 15, 21, 00);
        appointment.setEndTime(endTime);
        assertEquals(appointment.getEndTime(), endTime);
    }

    /**
     * Test of move method, of class Appointment.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int minutes = 60;
        appointment.move(minutes);
        ITime btResult = new Time(2016, 10, 14, 22, 00);
        ITime etResult = new Time(2016, 10, 14, 23, 00);
        assertEquals(appointment.getBeginTime(), btResult);
        assertEquals(appointment.getEndTime(), etResult);
    }

    /**
     * Test of changeLengthWith method, of class Appointment.
     */
    @Test
    public void testChangeLengthWith() {
        System.out.println("changeLengthWith");
        int minutes = 60;
        appointment.changeLengthWith(minutes);
        ITime btResult = new Time(2016, 10, 14, 21, 00);
        ITime etResult = new Time(2016, 10, 14, 23, 00);
        
        assertEquals(appointment.getBeginTime(), btResult);
        assertEquals(appointment.getEndTime(), etResult);
    }

    /**
     * Test of isPartOf method, of class Appointment.
     */
    @Test
    public void testIsPartOf() {
        System.out.println("isPartOf");        
        
        ITime bt2 = new Time(2016, 10, 14, 20, 00);
        ITime et2 = new Time(2016, 10, 14, 23, 00);
        ITimeSpan afspraak2 = new TimeSpan(bt, et);
        ITimeSpan appointment2 = new Appointment("Werk afspraak", afspraak);
        
        assertTrue(appointment.isPartOf(appointment2));
    }

    /**
     * Test of unionWith method, of class Appointment.
     */
    @Test
    public void testUnionWith() {
        System.out.println("unionWith");        
        
        ITime bt2 = new Time(2016, 10, 14, 20, 00);
        ITime et2 = new Time(2016, 10, 14, 21, 30);
        ITimeSpan afspraak2 = new TimeSpan(bt2, et2);
        ITimeSpan appointment2 = new Appointment("Werk afspraak", afspraak2);
        
        ITime btExpResult = new Time(2016, 10, 14, 20, 00);
        ITime etExpResult = new Time(2016, 10, 14, 22, 00);
        ITimeSpan afspraakExpResult = new TimeSpan(btExpResult, etExpResult);
        ITimeSpan appointmentExpResult = new Appointment("Werk afspraak 2", afspraakExpResult);
        
        ITimeSpan union = appointment.unionWith(appointment2);
        
        assertEquals(union.getBeginTime(), appointmentExpResult.getBeginTime());
        assertEquals(union.getEndTime(), appointmentExpResult.getEndTime());
    }

    /**
     * Test of intersectionWith method, of class Appointment.
     */
    @Test
    public void testIntersectionWith() {
        System.out.println("intersectionWith");        
        
        ITime bt2 = new Time(2016, 10, 14, 20, 00);
        ITime et2 = new Time(2016, 10, 14, 21, 30);
        ITimeSpan afspraak2 = new TimeSpan(bt2, et2);
        ITimeSpan appointment2 = new Appointment("Werk afspraak", afspraak2);
        
        ITime btExpResult = new Time(2016, 10, 14, 21, 00);
        ITime etExpResult = new Time(2016, 10, 14, 21, 30);
        ITimeSpan afspraakExpResult = new TimeSpan(btExpResult, etExpResult);
        ITimeSpan appointmentExpResult = new Appointment("Werk afspraak 2", afspraakExpResult);
        
        ITimeSpan union = appointment.intersectionWith(appointment2);
        
        assertEquals(union.getBeginTime(), appointmentExpResult.getBeginTime());
        assertEquals(union.getEndTime(), appointmentExpResult.getEndTime());
    }
}
