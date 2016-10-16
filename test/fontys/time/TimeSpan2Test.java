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
public class TimeSpan2Test {
    
    public TimeSpan2Test() {
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
    
    @Test
    public void testConstructor() {
        System.out.println("constructor");
        // Begin time aanmaken
        ITime BT = new Time(2016, 10, 4, 20, 15);
        ITime ET = new Time(2016, 10, 4, 20, 30);
        // Nieuwe instance maken
        try {
            ITimeSpan instance = new TimeSpan2(BT, ET);
        }
        catch (IllegalArgumentException e) {
            fail("Timespan zou toegevoegd moeten worden");
        }
        
        BT = new Time(2016, 10, 4, 20, 14);
        ET = new Time(2016, 10, 4, 15, 30);
        try {
            ITimeSpan instance = new TimeSpan2(BT, ET);
            fail("Timespan zou niet toegevoegd moeten worden tijd begintijd is eerder");
        }
        catch (IllegalArgumentException e) {
        }
    }
    /**
     * Test of getBeginTime method, of class TimeSpan2.
     */
    @Test
    public void testGetBeginTime() {
        System.out.println("getBeginTime");
        
        // Begin time aanmaken
        Time BT = new Time(2016, 10, 4, 20, 14);
        // Eind tijd aanmakens
        Time ET = new Time(2016, 10, 4, 20, 30);
        // Nieuwe instance maken
        ITimeSpan instance = new TimeSpan2(BT, ET);
        
        // BT moet gelijk zijn aan de teruggegeven begintijd
        ITime expResult = BT;
        ITime result = instance.getBeginTime();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndTime method, of class TimeSpan2.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");

        // Begin time aanmaken
        Time BT = new Time(2016, 10, 4, 20, 14);
        // Eind tijd aanmakens
        Time ET = new Time(2016, 10, 4, 20, 30);
        // Nieuwe instance maken
        ITimeSpan instance = new TimeSpan2(BT, ET);
        
        // BT moet gelijk zijn aan de teruggegeven eindtijd
        ITime expResult = ET;
        ITime result = instance.getEndTime();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of length method, of class TimeSpan2.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        
        // Begin time aanmaken
        Time BT = new Time(2016, 10, 4, 20, 14);
        // Eind tijd aanmakens
        Time ET = new Time(2016, 10, 4, 20, 30);
        // Nieuwe instance maken
        ITimeSpan instance = new TimeSpan2(BT, ET);
        
        int expResult = 16;
        int result = instance.length();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBeginTime method, of class TimeSpan2.
     */
    @Test
    public void testSetBeginTime() {
        System.out.println("setBeginTime");
        
        // Begin time aanmaken
        ITime BT = new Time(2016, 10, 4, 20, 14);
        // Eind tijd aanmakens
        ITime ET = new Time(2016, 10, 4, 20, 30);
        // Nieuwe instance maken
        ITimeSpan instance = new TimeSpan2(BT, ET);
        
        ITime beginTime = new Time(2016,10,4,20,10);
        ITime beginTime2 = new Time(2016,10,4,20,10);
        // BT moet gelijk zijn aan de teruggegeven begintijd
        ITime expResult = beginTime;
        instance.setBeginTime(beginTime2);
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
     * Test of setEndTime method, of class TimeSpan2.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        
        // Begin time aanmaken
        ITime BT = new Time(2016, 10, 4, 20, 14);
        // Eind tijd aanmakens
        ITime ET = new Time(2016, 10, 4, 20, 30);
        // Nieuwe instance maken
        ITimeSpan instance = new TimeSpan2(BT, ET);
        
        ITime endTime = new Time(2016,10,4,21,30);
        ITime endTime2 = new Time(2016,10,4,21,30);
        // BT moet gelijk zijn aan de teruggegeven begintijd
        ITime expResult = endTime;
        instance.setEndTime(endTime2);
        ITime result = instance.getEndTime();
        
        assertEquals(expResult, result);
        
        // Test exceptions
        endTime = new Time(2016,10,4,18,45);
        try {
            instance.setEndTime(endTime);
            fail("Moet exception geven");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test of move method, of class TimeSpan2.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        
        // Begin time aanmaken
        ITime BT = new Time(2016, 10, 4, 20, 14);
        // Eind tijd aanmakens
        ITime ET = new Time(2016, 10, 4, 20, 30);
        // Nieuwe instance maken
        ITimeSpan instance = new TimeSpan2(BT, ET);
        
        int minutes = 10;
        // Nieuwe begin/eindtijd maken om deze te vergelijken
        ITime newBT = new Time(2016, 10, 4, 20, 24);
        ITime newET = new Time(2016, 10, 4, 20, 40);    
        instance.move(minutes);
        
        // Controle of de resultaten gelijk zijn
        assertEquals(newBT, instance.getBeginTime());
        assertEquals(newET, instance.getEndTime());
    }

    /**
     * Test of changeLengthWith method, of class TimeSpan2.
     */
    @Test
    public void testChangeLengthWith() {
        System.out.println("changeLengthWith");
        
        // Begin time aanmaken
        ITime BT = new Time(2016, 10, 4, 20, 14);
        // Eind tijd aanmakens
        ITime ET = new Time(2016, 10, 4, 20, 30);
        // Nieuwe instance maken
        ITimeSpan instance = new TimeSpan2(BT, ET);
        
        // De lengte 10 minuten vergrooten dus de eindtijd verzetten
        int minutes = 10;
        // Nieuwe begin/eindtijd maken om deze te vergelijken
        ITime newET = new Time(2016, 10, 4, 20, 40);    
        instance.changeLengthWith(minutes);
        
        // Controle of de resultaten gelijk zijn
        assertEquals(BT, instance.getBeginTime());
        assertEquals(newET, instance.getEndTime());
        
        // De exception afhandelen
        minutes = -10;
        try {
            instance.changeLengthWith(minutes);
            fail("Moet exception geven");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    /**
     * Test of isPartOf method, of class TimeSpan2.
     */
    @Test
    public void testIsPartOf() {
        System.out.println("isPartOf");
        // Begin time aanmaken
        ITime BT = new Time(2016, 10, 9, 20, 5);
        // Eind tijd aanmakens
        ITime ET = new Time(2016, 10, 9, 20, 30);
        // Nieuwe instance maken
        ITimeSpan instance = new TimeSpan2(BT, ET);
        
        // Begin time aanmaken
        ITime BT2 = new Time(2016, 10, 9, 20, 10);
        // Eind tijd aanmakens
        ITime ET2 = new Time(2016, 10, 9, 20, 20);
        // Nieuwe instance maken
        ITimeSpan instance2 = new TimeSpan2(BT2, ET2);        
        
        // Testen op tijd binnen elkaars
        boolean expResult = true;
        boolean result = instance.isPartOf(instance2);
        assertEquals(expResult, result);
        
        // nog een test maken
        BT2 =  new Time(2016, 10, 9, 20, 5);
        ET2 =  new Time(2016, 10, 9, 20, 35);
        
        // Nieuwe instance maken
        instance2 = new TimeSpan2(BT2, ET2);  
        
        // Testen als de eindtijd later is 
        expResult = false;
        result = instance.isPartOf(instance2);
        assertEquals(expResult, result);
        
        // nog een test maken
        BT2 =  new Time(2016, 10, 9, 20, 00);
        ET2 =  new Time(2016, 10, 9, 20, 10);
        
        // Nieuwe instance maken
        instance2 = new TimeSpan2(BT2, ET2);    
        
//        Testen als de begintijd eerder is
        expResult = false;
        result = instance.isPartOf(instance2);
        assertEquals(expResult, result);
        
        // nog een test maken
        BT2 =  new Time(2016, 10, 9, 19, 00);
        ET2 =  new Time(2016, 10, 9, 21, 10);
        
        // Nieuwe instance maken
        instance2 = new TimeSpan2(BT2, ET2);    
        
        // Testen als beide timespans erbuiten zijn
        expResult = false;
        result = instance.isPartOf(instance2);
        assertEquals(expResult, result);        
    }

    /**
     * Test of unionWith method, of class TimeSpan2.
     */
    @Test
    public void testUnionWith() {
        System.out.println("unionWith");
        
        // Begin end eind time aanmaken
        Time BT = new Time(2016, 10, 9, 15, 00);
        Time ET = new Time(2016, 10, 9, 20, 00);        
        Time BT2 = new Time(2016, 10, 9, 21, 00);
        Time ET2 = new Time(2016, 10, 9, 22, 00);  
        
        TimeSpan2 timeSpan = new TimeSpan2(BT, ET);
        TimeSpan2 instance = new TimeSpan2(BT2, ET2);
        
        // Test zonder overlap
        ITimeSpan result = instance.unionWith(timeSpan);
        assertNull(result);
        
        //Test met 30 minuten overlap
        BT = new Time(2016, 10, 9, 15, 00);
        ET = new Time(2016, 10, 9, 16, 00);

        BT2 = new Time(2016, 10, 9, 15, 30);
        ET2 = new Time(2016, 10, 9, 16, 30);
            
        timeSpan = new TimeSpan2(BT, ET);
        instance = new TimeSpan2(BT2, ET2);

        result = instance.unionWith(timeSpan);
        
        Time BTverwacht = new Time(2016, 10, 9, 15, 00);
        Time ETverwacht = new Time(2016, 10, 9, 16, 30);
        TimeSpan2 tsVerwacht = new TimeSpan2(BTverwacht, ETverwacht);
        
        assertEquals(result.getBeginTime(), tsVerwacht.getBeginTime());
        assertEquals(result.getEndTime(), tsVerwacht.getEndTime());
        
        //Test met met tijd binnenin
        BT = new Time(2016, 10, 9, 15, 00);
        ET = new Time(2016, 10, 9, 20, 00);

        BT2 = new Time(2016, 10, 9, 16, 00);
        ET2 = new Time(2016, 10, 9, 17, 00);
            
        timeSpan = new TimeSpan2(BT, ET);
        instance = new TimeSpan2(BT2, ET2);

        result = timeSpan.unionWith(instance);
        
        BTverwacht = new Time(2016, 10, 9, 15, 00);
        ETverwacht = new Time(2016, 10, 9, 20, 00);
        tsVerwacht = new TimeSpan2(BTverwacht, ETverwacht);
        
        assertEquals(result.getBeginTime(), tsVerwacht.getBeginTime());
        assertEquals(result.getEndTime(), tsVerwacht.getEndTime());
        
        //Test met met tijd buitenom aan beide kanten
        BT = new Time(2016, 10, 9, 15, 00);
        ET = new Time(2016, 10, 9, 20, 00);

        BT2 = new Time(2016, 10, 9, 13, 00);
        ET2 = new Time(2016, 10, 9, 22, 00);
            
        timeSpan = new TimeSpan2(BT, ET);
        instance = new TimeSpan2(BT2, ET2);

        result = timeSpan.unionWith(instance);
        
        BTverwacht = new Time(2016, 10, 9, 13, 00);
        ETverwacht = new Time(2016, 10, 9, 22, 00);
        tsVerwacht = new TimeSpan2(BTverwacht, ETverwacht);
        
        assertEquals(result.getBeginTime(), tsVerwacht.getBeginTime());
        assertEquals(result.getEndTime(), tsVerwacht.getEndTime());        
        
        //Test met met tijd aan een volgend aan 
        BT = new Time(2016, 10, 9, 15, 00);
        ET = new Time(2016, 10, 9, 17, 00);

        BT2 = new Time(2016, 10, 9, 17, 00);
        ET2 = new Time(2016, 10, 9, 20, 00);
            
        timeSpan = new TimeSpan2(BT, ET);
        instance = new TimeSpan2(BT2, ET2);

        result = timeSpan.unionWith(instance);
        
        BTverwacht = new Time(2016, 10, 9, 15, 00);
        ETverwacht = new Time(2016, 10, 9, 20, 00);
        tsVerwacht = new TimeSpan2(BTverwacht, ETverwacht);
        
        assertEquals(result.getBeginTime(), tsVerwacht.getBeginTime());
        assertEquals(result.getEndTime(), tsVerwacht.getEndTime());        
        
        //Test met met tijd aan een volgend aan de andere kant
        BT = new Time(2016, 10, 9, 15, 00);
        ET = new Time(2016, 10, 9, 17, 00);

        BT2 = new Time(2016, 10, 9, 13, 00);
        ET2 = new Time(2016, 10, 9, 15, 00);
            
        timeSpan = new TimeSpan2(BT, ET);
        instance = new TimeSpan2(BT2, ET2);

        result = timeSpan.unionWith(instance);
        
        BTverwacht = new Time(2016, 10, 9, 13, 00);
        ETverwacht = new Time(2016, 10, 9, 17, 00);
        tsVerwacht = new TimeSpan2(BTverwacht, ETverwacht);
        
        assertEquals(result.getBeginTime(), tsVerwacht.getBeginTime());
        assertEquals(result.getEndTime(), tsVerwacht.getEndTime());        
        
    }

    /**
     * Test of intersectionWith method, of class TimeSpan2.
     */
    @Test
    public void testIntersectionWith() {
        System.out.println("intersectionWith");
        
        // Test zonder overlap
        // Begin end eind time aanmaken
        Time BT = new Time(2016, 10, 9, 15, 00);
        Time ET = new Time(2016, 10, 9, 20, 00);        
        Time BT2 = new Time(2016, 10, 9, 21, 00);
        Time ET2 = new Time(2016, 10, 9, 22, 00);  
        
        TimeSpan2 timeSpan = new TimeSpan2(BT, ET);
        TimeSpan2 instance = new TimeSpan2(BT2, ET2);
        
        // Test zonder overlap
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertNull(result);
        
        //Test met met tijd aaneenvolgend
        BT = new Time(2016, 10, 9, 15, 00);
        ET = new Time(2016, 10, 9, 20, 00);

        BT2 = new Time(2016, 10, 9, 20, 00);
        ET2 = new Time(2016, 10, 9, 22, 00);
            
        timeSpan = new TimeSpan2(BT, ET);
        instance = new TimeSpan2(BT2, ET2);

        result = timeSpan.intersectionWith(instance);
        
        assertNull(result);
        
        //Test met overlap aan de achterkant
        BT = new Time(2016, 10, 9, 15, 00);
        ET = new Time(2016, 10, 9, 20, 00);

        BT2 = new Time(2016, 10, 9, 18, 00);
        ET2 = new Time(2016, 10, 9, 22, 00);
            
        timeSpan = new TimeSpan2(BT, ET);
        instance = new TimeSpan2(BT2, ET2);

        result = timeSpan.intersectionWith(instance);
        
        Time BTverwacht = new Time(2016, 10, 9, 18, 00);
        Time ETverwacht = new Time(2016, 10, 9, 20, 00);
        TimeSpan2 tsVerwacht = new TimeSpan2(BTverwacht, ETverwacht);
        
        assertEquals(result.getBeginTime(), tsVerwacht.getBeginTime());
        assertEquals(result.getEndTime(), tsVerwacht.getEndTime());  
        
        //Test met tijd binnenin
        BT = new Time(2016, 10, 9, 15, 00);
        ET = new Time(2016, 10, 9, 20, 00);

        BT2 = new Time(2016, 10, 9, 16, 00);
        ET2 = new Time(2016, 10, 9, 18, 00);
            
        timeSpan = new TimeSpan2(BT, ET);
        instance = new TimeSpan2(BT2, ET2);

        result = timeSpan.intersectionWith(instance);
        
        BTverwacht = new Time(2016, 10, 9, 16, 00);
        ETverwacht = new Time(2016, 10, 9, 18, 00);
        tsVerwacht = new TimeSpan2(BTverwacht, ETverwacht);
        
        assertEquals(result.getBeginTime(), tsVerwacht.getBeginTime());
        assertEquals(result.getEndTime(), tsVerwacht.getEndTime());  
    }
    
}
