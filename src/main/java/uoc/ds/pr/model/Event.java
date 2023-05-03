package uoc.ds.pr.model;

import edu.uoc.ds.adt.sequential.LinkedList;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;
import edu.uoc.ds.traversal.Iterator;
import uoc.ds.pr.UniversityEvents;
import uoc.ds.pr.util.ElementWithId;

import java.time.LocalDate;

public class Event extends ElementWithId {
    protected LinkedList<Rating> ratings = new LinkedList<>();

    protected double meanRating = 0;
    protected double totalRating = 0;
    protected QueueArrayImpl<Attendee> queuAttendees = new QueueArrayImpl<>();
    protected String entityId;
    private final int maxAttendees;
    private  UniversityEvents.InstallationType installationType;
    private byte resources;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isAllowToRegister;
    private String description;

    private String eventId;


    public Event(String eventId, String entityId, String description, UniversityEvents.InstallationType installationType, byte resources, int max, LocalDate startDate, LocalDate endDate, boolean allowRegister){
        this.eventId = eventId;
        this.entityId = entityId;
        this.description = description;
        this.maxAttendees = max;
        this.installationType = installationType;
        this.resources = resources;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isAllowToRegister = allowRegister;
    }

    @Override
    public String getId(){
        return this.eventId;
    }

    public String getEventId(){
        return this.eventId; }
    public boolean isAllowToRegister(){
        return isAllowToRegister;
    }

    public Double rating(){
        return this.meanRating;
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
        int size = this.queuAttendees.size();
        return size > maxAttendees ? maxAttendees: size;
    }

    public String getEntityId(){
        return this.entityId;
    }

    public int getSubstitutesAmnt(){
        int queuSize = this.queuAttendees.size();
        int subs = (queuSize - this.maxAttendees ) <= 0 ? 0 : (queuSize - this.maxAttendees);

        return subs;
    }


    public void addRating(Rating newRating){
        this.ratings.insertEnd(newRating);
        this.totalRating +=  newRating.getRating().getValue();
        int ratingAmount = this.ratings.size();

        this.meanRating = totalRating / ratingAmount;

    }


    public int numRatings(){
        return this.ratings.size();
    }


}
