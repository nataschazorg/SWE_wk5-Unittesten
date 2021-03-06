/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 *
 * @author Frank Peeters, Nico Kuijpers
 *
 * LET OP: De klasse Time bevat enkele fouten.
 *
 */
public class Time implements ITime {

    private GregorianCalendar gc;

    /**
     * creation of a time-object with year y, month m, day d, hours h and
     * minutes m; if the combination of y-m-d refers to a non-existing date the
     * value of this Time-object will be not guaranteed
     *
     * @param y 1900≤m≤2100
     * @param m 1≤m≤12
     * @param d 1≤d≤31
     * @param h 0≤h≤23
     * @param min 0≤m≤59
     */
    public Time(int y, int m, int d, int h, int min) {
        if (y < 1900 || y > 2100) {
            throw new IllegalArgumentException("Year must be within 1900..3000");
        }
        if (m < 1 || m > 12) {
            throw new IllegalArgumentException("month must be within 1..12");
        }

        if (d < 1 || d > lastDayOfMonth(y, m)) {
            // TODO Check what month it is and assert on the maximum days in the month
            throw new IllegalArgumentException("day must be within 1..31");
        }
        if (h < 0 || h > 23) {
            throw new IllegalArgumentException("hours must be within 0..23");
        }
        if (min < 0 || min > 59) {
            throw new IllegalArgumentException("minutes must be within 0..59");
        }

        gc = new GregorianCalendar(y, m, d, h, min);
    }

    Time(Time t) {
        gc = (GregorianCalendar) t.gc.clone();
    }

    /**
     * @author Johan
     *
     * Use the given year and month to get the last day of the month.
     * @param y 1900≤m≤3000
     * @param m 1≤m≤12
     * @return the last day of the given month
     */
    private int lastDayOfMonth(int y, int m) {
        Calendar c = Calendar.getInstance();
        c.set(y, m - 1, 1);
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * @author Johan
     * 
     * @return the concerning day in the week of this time
     */
    @Override
    public DayInWeek getDayInWeek() {
        int day_of_week = gc.get(GregorianCalendar.DAY_OF_WEEK);
        System.out.println(day_of_week);
        switch (day_of_week - 1) {
            case GregorianCalendar.SUNDAY:
                return DayInWeek.SUN;
            case GregorianCalendar.MONDAY:
                return DayInWeek.MON;
            case GregorianCalendar.TUESDAY:
                return DayInWeek.TUE;
            case GregorianCalendar.WEDNESDAY:
                return DayInWeek.WED;
            case GregorianCalendar.THURSDAY:
                return DayInWeek.THU;
            case GregorianCalendar.FRIDAY:
                return DayInWeek.FRI;
            default:
                return DayInWeek.SAT;
        }
    }

    @Override
    public int getYear() {
        return gc.get(GregorianCalendar.YEAR);
    }

    @Override
    public int getMonth() {
        return gc.get(GregorianCalendar.MONTH);
    }

    @Override
    public int getDay() {
        return gc.get(GregorianCalendar.DAY_OF_MONTH);
    }

    @Override
    public int getHours() {
        return gc.get(GregorianCalendar.HOUR_OF_DAY);
    }

    @Override
    public int getMinutes() {
        return gc.get(GregorianCalendar.MINUTE);
    }

    @Override
    public ITime plus(int minutes) {
        Time time = new Time(this);
        time.gc.add(GregorianCalendar.MINUTE, minutes);
        return time;
    }

    @Override
    public int compareTo(ITime t) {
        Time time = (Time) t;
        return time.gc.compareTo(gc);
    }

    /**
     * 
     * @param time
     * @return the difference between this time and [time] expressed in minutes
     */
    @Override
    public int difference(ITime time) {
        Time t = (Time) time;
        return (int) ((this.gc.getTimeInMillis() - t.gc.getTimeInMillis()) / 60000);
    }
    
    /**
     * @author Johan
     * @param other Time object
     * 
     * @return 
     *      False in case of:
     *      - other cannot be cast into a Time object
     *      - The year in the other object does not the year in this object
     *      - The month in the other object does not match the month in this object
     *      - The day in the other object does not match the day in this object
     *      - The hour in the other object does not match the hour in this object
     *      - The minute in the other object does not match the minute in this object
     *      
     *      True if all of the above attributes match
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        try {
            Time otherTime = (Time) other;
            
            if (this.getYear() != otherTime.getYear()) {
                return false;
            }
            if (this.getMonth() != otherTime.getMonth()) {
                return false;
            }
            if (this.getDay() != otherTime.getDay()) {
                return false;
            }
            if (this.getHours() != otherTime.getHours()) {
                return false;
            }
            return this.getMinutes() == otherTime.getMinutes();

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.gc);
        return hash;
    }
}
