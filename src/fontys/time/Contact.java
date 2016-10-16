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
 * @author johan
 */
public class Contact {

    private final String name;
    private ArrayList<Appointment> agenda;

    /**
     * Constructor
     *
     * A new contact is created with the name of the contact. The new contact
     * will be added to the agenda ArrayList.
     *
     * @param name cannot be empty
     */
    public Contact(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Naam is verplicht");
        }

        this.name = name.trim();
        agenda = new ArrayList();
    }

    /**
     *
     * @return name The name of the contact
     */
    public String getName() {
        return name;
    }

    /**
     * Removes an appointment from the agenda.
     *
     * @param a as Appointment cannot be null and must exist in the agenda
     * ArrayList. If the appointment does not exist in the agenda ArrayList an
     * exception will be thrown.
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
     * Adds an appointment to the agenda ArrayList. An appointment cannot
     * overlap with other appointments in the agenda ArrayList. The appointments
     * can be directly adjacent to each other
     *
     * @param a appointment. This cannot be null.
     * @return true if the appointment is added to the agenda ArrayList, false
     * if the appointment was not added to the agenda ArrayList.
     */
    public boolean addAppointment(Appointment a) {
        boolean toegevoegd = false;
        if (a != null) {
            // Als de agenda nog leeg is is het altijd goed
            if (!this.agenda.isEmpty()) {
                for (Appointment app : this.agenda) {
                    if (app.unionWith(a) != null) {
                        if (!agenda.contains(a)) {
                            toegevoegd = true;
                        }
                    }
                }
            } else {
                toegevoegd = true;
            }

            // Niet direct toevoegen maar als toegevoegd true is uiteindelijk dan toevoegen
            if (toegevoegd == true) {
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
