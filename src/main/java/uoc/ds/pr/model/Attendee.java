package uoc.ds.pr.model;

import edu.uoc.ds.adt.sequential.LinkedList;
import edu.uoc.ds.traversal.Iterator;
import uoc.ds.pr.util.ElementWithId;

import java.time.LocalDate;

public class Attendee extends ElementWithId {
    private final String name;
    private final String surname;

    private final LocalDate birthdate;

    protected LinkedList<Event> attendedEvents = new LinkedList<>();



    public Attendee(String id, String name, String surname, LocalDate birthdate){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }
    @Override
    public String getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }



    public void signUp(Event event){
        this.attendedEvents.insertEnd(event);
    }

    public LinkedList<Event> getAttendedEvents(){
        return this.attendedEvents;
    }

    public int numEvents(){
       return this.attendedEvents.size();
    }
}
