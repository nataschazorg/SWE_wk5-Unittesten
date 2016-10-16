/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.GregorianCalendar;
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
    public void testConstructor(){
        // Test year == 1900
        time = new Time(1900, 2, 4, 12, 30);
        
        // Test year == 2100
        time = new Time(2100, 2, 4, 12, 30);
        
        // Test month == 1
        time = new Time(2016, 1, 4, 12, 30);
        
        // Test month == 12
        time = new Time(2016, 12, 4, 12, 30);
        
        // Test day == 1
        time = new Time(2016, 2, 1, 12, 30);
        
        // Test hour == 0
        time = new Time(2016, 2, 4, 0, 30);
        
        // Test hour == 23
        time = new Time(2016, 2, 4, 23, 30);
        
        // Test minute == 0
        time = new Time(2016, 2, 4, 12, 0);
        
        // Test minute == 59
        time = new Time(2016, 2, 4, 12, 59);
        
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
     * Test of getDayInWeek method, of class Time.
     */
    @Test
    public void testGetDayInWeek() {
        System.out.println("getDayInWeek");
                
        // Test monday
        time = new Time(2016, 2, 8, 12, 30);
        DayInWeek expResult = DayInWeek.MON;
        DayInWeek result = time.getDayInWeek();
        assertEquals(expResult, result);
        
        // Test tuesday
        time = new Time(2016, 2, 9, 12, 30);
        expResult = DayInWeek.TUE;
        result = time.getDayInWeek();
        assertEquals(expResult, result);
        
        // Test wednesday
        time = new Time(2016, 2, 10, 12, 30);
        expResult = DayInWeek.WED;
        result = time.getDayInWeek();
        assertEquals(expResult, result);
        
        // Test thursday
        time = new Time(2016, 2, 11, 12, 30);
        expResult = DayInWeek.THU;
        result = time.getDayInWeek();
        assertEquals(expResult, result);
        
        // Test friday
        time = new Time(2016, 2, 12, 12, 30);
        expResult = DayInWeek.FRI;
        result = time.getDayInWeek();
        assertEquals(expResult, result);
        
        // Test saturday
        time = new Time(2016, 2, 20, 12, 30);
        expResult = DayInWeek.SAT;
        result = time.getDayInWeek();
        assertEquals(expResult, result);
        
        // Test sunday
        time = new Time(2016, 2, 14, 12, 30);
        expResult = DayInWeek.SUN;
        result = time.getDayInWeek();
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
        // Add one minute
        System.out.println("plus");
        int minutes = 1;
        ITime expResult = new Time(2016, 2, 4, 12, 31);
        ITime result = time.plus(minutes);
        assertEquals(expResult.getMinutes(), result.getMinutes());
        
        // Add -1 minute
        minutes = -1;
        expResult = new Time(2016, 2, 4, 12, 29);
        result = time.plus(minutes);
        assertEquals(expResult.getMinutes(), result.getMinutes());
        
        // Add 0
        minutes = 0;
        expResult = new Time(2016, 2, 4, 12, 30);
        result = time.plus(minutes);
        assertEquals(expResult.getMinutes(), result.getMinutes());
        
        // Add 1 hour
        minutes = 60;
        expResult = new Time(2016, 2, 4, 13, 30);
        result = time.plus(minutes);
        assertEquals(expResult.getMinutes(), result.getMinutes());        
    }

    /**
     * Test of compareTo method, of class Time.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        ITime t = new Time(2016, 2, 4, 12, 30);
        int expResult = 0;
        int result = time.compareTo(t);
        assertEquals(expResult, result);
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

    /**
     * Test of equals method, of class Time.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object other = new Time(2016, 2, 4, 12, 30);
        boolean result = time.equals(other);
        assertTrue(result);
        
        // Test other = null
        other = null;
        result = time.equals(other);
        assertFalse(result);
        
        
        // Test other = this
        other = time;
        result = time.equals(other);
        assertTrue(result);
        
        // Test other class
        other = new GregorianCalendar();
        result = time.equals(other);
        assertFalse(result);
        
        // Test different year
        other = new Time(2015, 2, 4, 12, 30);
        assertFalse(time.equals(other));
        
        // Test different month
        other = new Time(2016, 3, 4, 12, 30);
        assertFalse(time.equals(other));
        
        // Test different day
        other = new Time(2016, 2, 5, 12, 30);
        assertFalse(time.equals(other));
        
        // Test different hour
        other = new Time(2016, 2, 4, 11, 30);
        assertFalse(time.equals(other));
        
        // Test different minute
        other = new Time(2016, 2, 4, 12, 20);
        assertFalse(time.equals(other));
    }
    
}
