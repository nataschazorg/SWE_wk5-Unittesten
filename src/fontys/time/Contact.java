/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author floris
 */
public class Contact {
    private final String name;
    private ArrayList<Appointment> agenda;
    
    /**
     * Constructor
     * @param name String mag niet leeg zijn
     */
    public Contact(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Naam is verplicht");
        }
        
        this.name = name.trim();
        agenda = new ArrayList();
    }
    
    /**
     * Geeft de naam van de contact terug
     * @return name string
     */
    public String getName() {
        return name;
    }

    /**
     * Verwijderd een appointment uit de agenda
     * @param a as Appointment
     */
    public void removeAppointment(Appointment a) {
        if (a != null) {
            if (agenda.contains(a)) {
                agenda.remove(a);
                a.removeContact(this);
            }
        }
    }
    /**
     * Voegt een appointment toe aan de agenda. Adds an appointment to the Agenda. Appointment can't be null and can't
     * @param a Appointment mag niet NULL of leeg zijn. Mag ook niet overlappen met andere appointments
     * @return true als Appointment is toegevoegd anders false bij fout
     */
    public boolean addAppointment(Appointment a) {
        boolean toegevoegd = false;
        if(a!= null)
        {
            // Als de agenda nog leeg is is het altijd goed
            if(!this.agenda.isEmpty())
            {
                for(Appointment app : this.agenda)
                {
                    if(app.unionWith(a) != null)
                    {
                        if(!agenda.contains(a))
                        {
                            toegevoegd = true;
                        }
                    }
                }
            }
            else
            {
                toegevoegd = true;
            }
            
            // Niet direct toevoegen maar als toegevoegd true is uiteindelijk dan toevoegen
            if(toegevoegd == true)
            {
                 agenda.add(a);
                 a.addContact(this);
            }
        }
        return toegevoegd;
    }

    /**
     * Gives the next object in the Agenda
     *
     * @return Appointment that is the next one in the Agenda
     */
    public Iterator<Appointment> appointments() {
        return agenda.iterator();
    }    
}
