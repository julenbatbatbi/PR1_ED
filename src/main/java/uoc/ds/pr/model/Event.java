package uoc.ds.pr.model;

import edu.uoc.ds.adt.sequential.LinkedList;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;
import edu.uoc.ds.traversal.Iterator;
import uoc.ds.pr.UniversityEvents;
import uoc.ds.pr.util.ElementWithId;

import java.time.LocalDate;

public class Event extends ElementWithId {
    protected LinkedList<Rating> ratings = new LinkedList<>();
    protected QueueArrayImpl<Attendee> queuAttendees = new QueueArrayImpl<>();


    private final AttendeeList attendees;
    private final int maxAttendees;
    private  UniversityEvents.InstallationType installationType;

    private byte resources;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isAllowToRegister;



    public Event(String id, int max, UniversityEvents.InstallationType installationType, byte resources, LocalDate startDate, LocalDate endDate, boolean isAllowToRegister){
        this.id = id;
        this.maxAttendees = max;
        this.attendees = new AttendeeList(max);
        this.installationType = installationType;
        this.resources = resources;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isAllowToRegister = isAllowToRegister;


    }
    @Override
    public String getId(){
        return this.id;
    }

    public String getEventId(){
        return this.getId(); }
    public boolean isAllowToRegister(){
        return isAllowToRegister;
    }

    public Integer rating(){
        return null;
    }

    public Attendee getAttendee(String attendeeId) {
        Iterator<Attendee> it = queuAttendees.values();
        while (it.hasNext()) {
            Attendee _attendee = it.next();
            if(attendeeId.equals(_attendee.getId())) return _attendee;

        }
        return null;
    }

    public LinkedList<Rating> getRatings(){
        return this.ratings;
    }

    public void signUp(Attendee attendee){
        this.queuAttendees.add(attendee);
    }

    public int numAttendees(){
        return this.queuAttendees.size() > maxAttendees ? maxAttendees: this.queuAttendees.size();
    }

    public int getSubstitutesAmnt(){
        int queuSize = this.queuAttendees.size();
        int subs = (queuSize - this.maxAttendees ) <= 0 ? 0 : (queuSize - this.maxAttendees);

        return subs;


    }
}
