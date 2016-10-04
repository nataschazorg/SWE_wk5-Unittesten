/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

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
public class TimeSpanTest {
    
    public TimeSpanTest() {
    }
    
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

    /**
     * Test of getBeginTime method, of class TimeSpan.
     */
    @Test
    public void testGetBeginTime() {
        System.out.println("getBeginTime");
        
        // Begin time aanmaken
        Time BT = new Time(2016, 10, 4, 20, 14);
        // Eind tijd aanmakens
        Time ET = new Time(2016, 10, 4, 20, 30);
        // Nieuwe instance maken
        TimeSpan instance = new TimeSpan(BT, ET);
        
        // BT moet gelijk zijn aan de teruggegeven begintijd
        ITime expResult = BT;
        ITime result = instance.getBeginTime();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndTime method, of class TimeSpan.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");

        // Begin time aanmaken
        Time BT = new Time(2016, 10, 4, 20, 14);
        // Eind tijd aanmakens
        Time ET = new Time(2016, 10, 4, 20, 30);
        // Nieuwe instance maken
        TimeSpan instance = new TimeSpan(BT, ET);
        
        // BT moet gelijk zijn aan de teruggegeven eindtijd
        ITime expResult = ET;
        ITime result = instance.getEndTime();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of length method, of class TimeSpan.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        
        // Begin time aanmaken
        Time BT = new Time(2016, 10, 4, 20, 14);
        // Eind tijd aanmakens
        Time ET = new Time(2016, 10, 4, 20, 30);
        // Nieuwe instance maken
        TimeSpan instance = new TimeSpan(BT, ET);
        
        int expResult = 16;
        int result = instance.length();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBeginTime method, of class TimeSpan.
     */
    @Test
    public void testSetBeginTime() {
        System.out.println("setBeginTime");
        
        // Begin time aanmaken
        ITime BT = new Time(2016, 10, 4, 20, 14);
        // Eind tijd aanmakens
        ITime ET = new Time(2016, 10, 4, 20, 30);
        // Nieuwe instance maken
        TimeSpan instance = new TimeSpan(BT, ET);
        
        ITime beginTime = new Time(2016,10,4,20,10);
        // BT moet gelijk zijn aan de teruggegeven begintijd
        ITime expResult = beginTime;
        instance.setBeginTime(beginTime);
        ITime result = instance.getBeginTime();
        
        assertEquals(expResult, result);
        
        // Test exceptions
        beginTime = new Time(2016,10,4,21,45);
        try {
            instance.setBeginTime(beginTime);
            fail("Moet exception geven");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test of setEndTime method, of class TimeSpan.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        
        // Begin time aanmaken
        ITime BT = new Time(2016, 10, 4, 20, 14);
        // Eind tijd aanmakens
        ITime ET = new Time(2016, 10, 4, 20, 30);
        // Nieuwe instance maken
        TimeSpan instance = new TimeSpan(BT, ET);
        
        ITime endTime = new Time(2016,10,4,20,30);
        // BT moet gelijk zijn aan de teruggegeven begintijd
        ITime expResult = endTime;
//        instance.setEndTime(endTime);
        ITime result = instance.getEndTime();
        
        assertEquals(expResult, result);
        
        // Test exceptions
        endTime = new Time(2016,10,4,21,45);
        try {
            instance.setEndTime(endTime);
            fail("Moet exception geven");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test of move method, of class TimeSpan.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int minutes = 0;
        TimeSpan instance = null;
        instance.move(minutes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeLengthWith method, of class TimeSpan.
     */
    @Test
    public void testChangeLengthWith() {
        System.out.println("changeLengthWith");
        int minutes = 0;
        TimeSpan instance = null;
        instance.changeLengthWith(minutes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPartOf method, of class TimeSpan.
     */
    @Test
    public void testIsPartOf() {
        System.out.println("isPartOf");
        ITimeSpan timeSpan = null;
        TimeSpan instance = null;
        boolean expResult = false;
        boolean result = instance.isPartOf(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unionWith method, of class TimeSpan.
     */
    @Test
    public void testUnionWith() {
        System.out.println("unionWith");
        ITimeSpan timeSpan = null;
        TimeSpan instance = null;
        ITimeSpan expResult = null;
        ITimeSpan result = instance.unionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of intersectionWith method, of class TimeSpan.
     */
    @Test
    public void testIntersectionWith() {
        System.out.println("intersectionWith");
        ITimeSpan timeSpan = null;
        TimeSpan instance = null;
        ITimeSpan expResult = null;
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
