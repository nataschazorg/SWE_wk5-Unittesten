/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

/**
 *
 * @author floris
 */
public class Appointment implements ITimeSpan {
    
    public String subject;
    public ITimeSpan timeSpan;
    public ArrayList<Contact> invitees;
    
     /**
     * Constructor
     * @param subject string mag leeg zijn
     * @param timeSpan ITimeSpan moet later zijn dan de huidige datum
     */
    public Appointment(String subject, ITimeSpan timeSpan) {
        // Dag van dandaag ophalen
        GregorianCalendar now = new GregorianCalendar();
        GregorianCalendar ts = new GregorianCalendar(timeSpan.getBeginTime().getYear(),timeSpan.getBeginTime().getMonth(),timeSpan.getBeginTime().getDay(),timeSpan.getBeginTime().getHours(),timeSpan.getBeginTime().getMinutes());
        if(subject != null && ts.after(now))
        {
            this.subject = subject.trim();
            this.timeSpan = timeSpan;
        } else {
            throw new IllegalArgumentException("De datum moet later dan de huidige datum zijn");
        }
        this.invitees = new ArrayList<>();
    }

 /**
     * Geeft de subject terug
     * @return subject String.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Geeft de timeSpan terug
     * @return timeSpan ITimeSpan;
     */
    public ITimeSpan getTimeSpan() {
        return timeSpan;
    }
    
    /**
     * Gives back the next object of the invitees
     * @return a Contact that is the next one in the invitees
     */
    public Iterator<Contact> invitees()
    {
        return invitees.iterator();
    }    
    
    /**
     * Voegt een contact toe aan de appointment en de appointment wordt vervolgens
     * ook toegevoegd aan de contact omdat deze hier ook moet bestaan
     * @param c Contact, Contact mag niet NULL zijn of al bestaan ook mag deze niet overlappen met appointments of de contacte
     * @return boolean true als contact is toegevoegd, false indien fout
     */
    public boolean addContact(Contact c)
    {
        boolean toegevoegd = false;
        if(c != null && !this.invitees.contains(c))
        {
            Appointment a = null;
            for (Iterator<Appointment> iter = c.appointments(); iter.hasNext(); ) {
                a = iter.next();
                if (a.unionWith(timeSpan) != null) 
                {
                    this.invitees.add(c);
                    c.addAppointment(this);
                    toegevoegd = true;
                }
            }
            // Als hij niet door itator is geweest standaard toevoegen
            if (a == null) {
                this.invitees.add(c);
                c.addAppointment(this);
                toegevoegd = true;
            }
        }
        return toegevoegd;
    }
    
    /**
     * Verwijderd een contact uit de appoinent
     * @param contact Contact.
     */
    public void removeContact(Contact c)
    {
        if(c != null && this.invitees.contains(c))
        {
            invitees.remove(c);
            c.removeAppointment(this);
        }
    }
    
    @Override
    public ITime getBeginTime() {
        return this.timeSpan.getBeginTime();
    }

    @Override
    public ITime getEndTime() {
        return this.timeSpan.getEndTime();
    }

    @Override
    public int length() {
        return this.timeSpan.length();
    }

    @Override
    public void setBeginTime(ITime beginTime) {
        this.timeSpan.setBeginTime(beginTime);
    }

    @Override
    public void setEndTime(ITime endTime) {
        this.timeSpan.setEndTime(endTime);
    }

    @Override
    public void move(int minutes) {
        this.timeSpan.move(minutes);
    }

    @Override
    public void changeLengthWith(int minutes) {
        this.timeSpan.changeLengthWith(minutes);
    }

    @Override
    public boolean isPartOf(ITimeSpan timeSpan) {
        return this.timeSpan.isPartOf(timeSpan);
    }

    @Override
    public ITimeSpan unionWith(ITimeSpan timeSpan) {
       return this.timeSpan.unionWith(timeSpan);
    }

    @Override
    public ITimeSpan intersectionWith(ITimeSpan timeSpan) {
        return this.timeSpan.intersectionWith(timeSpan);
    }    
}
