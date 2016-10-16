/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

/**
 *
 * @author johan
 */
public class TimeSpan2 implements ITimeSpan {

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
    public TimeSpan2(ITime bt, ITime et) {
        if (bt.compareTo(et) <= 0) {
            throw new IllegalArgumentException("begin time "
                    + bt + " must be earlier than end time " + et);
        }

        this.bt = bt;
        this.et = et;
    }

    /**
     *
     * @return the begin time of this time span
     */
    @Override
    public ITime getBeginTime() {
        return this.bt;
    }

    /**
     *
     * @return the end time of this time span
     */
    @Override
    public ITime getEndTime() {
        return this.et;
    }

    /**
     *
     * @return the length of this time span expressed in minutes (always
     * positive)
     */
    @Override
    public int length() {
        return et.difference(bt);
    }

    /**
     * beginTime will be the new begin time of this time span
     *
     * @param beginTime must be earlier than the current end time of this time
     * span
     */
    @Override
    public void setBeginTime(ITime beginTime) {
        if (et.difference(beginTime) <= 0) {
            throw new IllegalArgumentException("Begin time cannot be greater then the end time");
        }
        bt = beginTime;
    }

    /**
     * endTime will be the new end time of this time span
     *
     * @param endTime must be later than the current begin time of this time
     * span
     */
    @Override
    public void setEndTime(ITime endTime) {
        if (endTime.difference(bt) <= 0) {
            throw new IllegalArgumentException("Begin time cannot be greater then the end time");
        }
        et = endTime;
    }

    /**
     * the begin and end time of this time span will be moved up both with
     * [minutes] minutes
     *
     * @param minutes (a negative value is allowed)
     */
    @Override
    public void move(int minutes) {
        bt = bt.plus(minutes);
        et = et.plus(minutes);
    }

    /**
     * the end time of this time span will be moved up with [minutes] minutes
     *
     * @param minutes minutes + length of this period must be positive
     */
    @Override
    public void changeLengthWith(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Minutes must have a positive value");
        }
        
        et = et.plus(minutes);
        if (et.compareTo(bt) > 0) {
            throw new IllegalArgumentException("Begin time cannot be greater then the end time");
        }
    }

    /**
     *
     * @param timeSpan
     * @return true if all moments within this time span are included within
     * [timeSpan], otherwise false
     */
    @Override
    public boolean isPartOf(ITimeSpan timeSpan) {
        ITime timeSpanBegin = timeSpan.getBeginTime();
        ITime timeSpanEnd = timeSpan.getEndTime();

        return bt.compareTo(timeSpanBegin) < 1
                && et.compareTo(timeSpanEnd) > -1;
    }

    /**
     *
     * @param timeSpan
     * @return if this time span and [timeSpan] are consecutive or possess a
     * common intersection, then the smallest time span ts will be returned,
     * whereby this time span and [timeSpan] are part of ts, otherwise null will
     * be returned
     */
    @Override
    public ITimeSpan unionWith(ITimeSpan timeSpan) {
        ITime beginTime, endTime;

        if (bt.compareTo(timeSpan.getEndTime()) < 0
                || timeSpan.getBeginTime().compareTo(et) < 0) {
            return null;
        }

        if (bt.compareTo(timeSpan.getBeginTime()) > 0) {
            beginTime = bt;
        } else {
            beginTime = timeSpan.getBeginTime();
        }

        if (et.compareTo(timeSpan.getEndTime()) < 0) {
            endTime = et;
        } else {
            endTime = timeSpan.getEndTime();
        }

        return new TimeSpan2(beginTime, endTime);
    }

    /**
     *
     * @param timeSpan
     * @return the largest time span which is part of this time span and
     * [timeSpan] will be returned; if the intersection is empty null will be
     * returned
     */
    @Override
    public ITimeSpan intersectionWith(ITimeSpan timeSpan) {
        ITime beginTime, endTime;

        if (bt.compareTo(timeSpan.getEndTime()) < 1
                || timeSpan.getBeginTime().compareTo(et) < 1) {
            return null;
        }

        if (bt.compareTo(timeSpan.getBeginTime()) < 0) {
            beginTime = bt;
        } else {
            beginTime = timeSpan.getBeginTime();
        }

        if (et.compareTo(timeSpan.getEndTime()) > 0) {
            endTime = et;
        } else {
            endTime = timeSpan.getEndTime();
        }

        return new TimeSpan2(beginTime, endTime);
    }

}
