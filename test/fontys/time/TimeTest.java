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
 * @author johan
 */
public class TimeTest {
    Time time;
    
    public TimeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        time = new Time(2016, 2, 4, 12, 30);
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test all the situations where the constructor
     * should not raise an exception
     */
    @Test
    public void testConstructtor(){
        // Test year == 1900
        
        // Test year == 2100
        
        // Test month == 1
        
        // Test month == 12
        
        // Test day == 1
        
        // Test hour == 0
        
        // Test hour == 23
        
        // Test minute == 0
        
        // Test minute == 59
        
    }
    
    
    /**
     * Test all all the situations 
     * where the constructor should raise an exception
     */
    @Test
    public void testConstructtorExceptions(){
        // Test year < 1900
        try {
            time = new Time(1889, 1, 1, 1, 1);
            fail("There should be an IllegalArgumentException when year < 1900");
        } catch (IllegalArgumentException e) {
        }
        
        // Test year > 2100
        try {
            time = new Time(2101, 1, 1, 1, 1);
            fail("There should be an IllegalArgumentException when year > 2100");
        } catch (IllegalArgumentException e) {
        }
        
        // Test month < 1
        try {
            time = new Time(2016, 0, 1, 1, 1);
            fail("There should be an IllegalArgumentException when month < 1");
        } catch (Exception e) {
        }
        
        // Test month > 12
        try {
            time = new Time(2016, 13, 1, 1, 1);
            fail("There should be an IllegalArgumentException when month > 12");
        } catch (IllegalArgumentException e) {
        }
        
        // Test day < 1
        try {
            time = new Time(2016, 2, 0, 1, 1);
            fail("There should be an IllegalArgumentException when day < 1");
        } catch (Exception e) {
        }
        
        // Test hour < 0
        try {
            time = new Time(2016, 2, 1, -1, 1);
            fail("There should be an IllegalArgumentException when hour < 0");
        } catch (Exception e) {
        }        
        
        // Test hour > 23
        try {
            time = new Time(2016, 2, 1, 24, 1);
            fail("There should be an IllegalArgumentException when hour > 23");
        } catch (Exception e) {
        }
        
        // Test minute < 0
        try {
            time = new Time(2016, 2, 1, 1, -1);
            fail("There should be an IllegalArgumentException when minute < 0");
        } catch (Exception e) {
        }
        
        // Test minute > 59
        try {
            time = new Time(2016, 2, 0, 1, 60);
            fail("There should be an IllegalArgumentException when minute > 59");
        } catch (Exception e) {
        }
        
    }
    
    /**
     * Test of getLastDayOfMonth method, of class Time.
     */
    @Test
    public void testLastDayOfMonth(){
        System.out.println("lastDayOfMonth");
        int expResult = 29;
        int result = time.lastDayOfMonth(time.getYear(), time.getMonth());
        assertEquals(expResult, result);
    }

    /**
     * Test of getDayInWeek method, of class Time.
     */
    @Test
    public void testGetDayInWeek() {
        System.out.println("getDayInWeek");
        DayInWeek expResult = DayInWeek.THU;
        DayInWeek result = time.getDayInWeek();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYear method, of class Time.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        int expResult = 2016;
        int result = time.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonth method, of class Time.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        int expResult = 2;
        int result = time.getMonth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDay method, of class Time.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        int expResult = 4;
        int result = time.getDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHours method, of class Time.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
        int expResult = 12;
        int result = time.getHours();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinutes method, of class Time.
     */
    @Test
    public void testGetMinutes() {
        System.out.println("getMinutes");
        int expResult = 30;
        int result = time.getMinutes();
        assertEquals(expResult, result);
    }

    /**
     * Test of plus method, of class Time.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        int minutes = 1;
        ITime expResult = new Time(2016, 2, 4, 12, 31);
        ITime result = time.plus(minutes);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Time.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        ITime t = null;
        Time instance = null;
        int expResult = 0;
        int result = instance.compareTo(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of difference method, of class Time.
     */
    @Test
    public void testDifference() {
        System.out.println("difference");
        
        // Test subtract 1 minute
        ITime time2 = new Time(2016, 2, 4, 12, 29);
        int expResult = 1;
        int result = time.difference(time2);
        assertEquals(expResult, result);
        
        // Test subtract 1 minute reverse
        time2 = new Time(2016, 2, 4, 12, 31);
        expResult = -1;
        result = time.difference(time2);
        assertEquals(expResult, result);
        
        // Test difference = 0
        time2 = new Time(2016, 2, 4, 12, 30);
        expResult = 0;
        result = time.difference(time2);
        assertEquals(expResult, result);
        
        // Test time difference 1 hour
        time2 = new Time(2016, 2, 4, 11, 30);
        expResult = 60;
        result = time.difference(time2);
        assertEquals(expResult, result);

        // Test time difference 1 day
        time2 = new Time(2016, 2, 3, 12, 30);
        expResult = 1440;
        result = time.difference(time2);
        assertEquals(expResult, result);
    }
    
}
