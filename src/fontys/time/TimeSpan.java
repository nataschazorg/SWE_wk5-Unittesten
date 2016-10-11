/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

/**
 *
 * @author Frank Peeters, Nico Kuijpers
 * 
 * LET OP: De klasse TimeSpan bevat enkele fouten.
 * 
 */
public class TimeSpan implements ITimeSpan {

    /* class invariant: 
     * A stretch of time with a begin time and end time.
     * The end time is always later then the begin time; the length of the time span is
     * always positive
     * 
     */
    private ITime bt, et;
    
    /**
     * 
     * @param bt must be earlier than et
     * @param et 
     */
    public TimeSpan(ITime bt, ITime et) {
        if (bt.compareTo(et) <= 0) {
            throw new IllegalArgumentException("begin time "
                    + bt + " must be earlier than end time " + et);
        }

        this.bt = bt;
        this.et = et;
    }
    
    /*
    * Geeft de begintijd van de klasse terug
    * @Return bt
    */
    @Override
    public ITime getBeginTime() {
        return bt;
    }

    /*
    * Geeft de eindtijd van de klasse terug
    * @Return et 
    */
    @Override
    public ITime getEndTime() {
        return et;
    }
    
    /*
    * Berekend het verschil tussen begin en eind tijd
    * @Return difference 
    */
    @Override
    public int length() {
        return et.difference(bt);
    }

    /*
    * Zet een nieuwe waarde als begintijd
    * @param beginTime moet eerder zijn dan de eindtijd
    */
    @Override
    public void setBeginTime(ITime beginTime) {
        if (et.compareTo(beginTime) >= 0) {
            throw new IllegalArgumentException("begin time "
                    + bt + " must be earlier than end time " + et);
        }

        bt = beginTime;
    }
    
    /*
    * Zet een nieuwe waarde als eindtijd
    * @param endTime moet groter zijn dan beginTime
    */
    @Override
    public void setEndTime(ITime endTime) {
        if (bt.compareTo(endTime) <= 0) {
            throw new IllegalArgumentException("end time "
                    + et + " must be later then begin time " + bt);
        }

        et = endTime;
    }

    /*
    * Deze methode verzet de begin en eindtijd met aan aantal minuten
    * @param minutes
    */
    @Override
    public void move(int minutes) {
        bt = bt.plus(minutes);
        et = et.plus(minutes);
    }
    
    /*
    * Deze methode maakt de lengte tussen de datums groter door alleen de eindtijd te verzetten
    * @param minutes
    */
    @Override
    public void changeLengthWith(int minutes) {
        if (minutes <= 0) {
            throw new IllegalArgumentException("length of period must be positive");
        }
        
        et = et.plus(minutes);
    }
    /*
    * Deze methode controleert of de ene timespan in de andere zit
    * @param timeSpan
    * @return boolean 
    */
    @Override
    public boolean isPartOf(ITimeSpan timeSpan) {
        return (getBeginTime().compareTo(timeSpan.getBeginTime()) >= 0
                && getEndTime().compareTo(timeSpan.getEndTime()) <= 0);
    }
    
    /*
    * @param timeSpan
    * @return timeSpan
    */
    @Override
    public ITimeSpan unionWith(ITimeSpan timeSpan) {
        if (bt.compareTo(timeSpan.getEndTime()) < 0 || et.compareTo(timeSpan.getBeginTime()) > 0) {
            return null;
        }
        
        ITime begintime, endtime;
        if (bt.compareTo(timeSpan.getBeginTime()) > 0) {
            begintime = bt;
        } else {
            begintime = timeSpan.getBeginTime();
        }

        if (et.compareTo(timeSpan.getEndTime()) < 0) {
            endtime = et;
        } else {
            endtime = timeSpan.getEndTime();
        }

        return new TimeSpan(begintime, endtime);
    }

    @Override
    public ITimeSpan intersectionWith(ITimeSpan timeSpan) {

        ITime begintime, endtime;
        if (bt.compareTo(timeSpan.getBeginTime()) < 0) {
            begintime = bt;
        } else {
            begintime = timeSpan.getBeginTime();
        }

        if (et.compareTo(timeSpan.getEndTime()) > 0) {
            endtime = et;
        } else {
            endtime = timeSpan.getEndTime();
        }

        if (begintime.compareTo(endtime) <= 0) {
            return null;
        }

        return new TimeSpan(begintime, endtime);
    }
}
