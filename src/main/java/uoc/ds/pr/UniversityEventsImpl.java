package uoc.ds.pr;

import edu.uoc.ds.exceptions.EmptyContainerException;
import edu.uoc.ds.traversal.Iterator;
import uoc.ds.pr.exceptions.*;
import uoc.ds.pr.model.*;
import edu.uoc.ds.adt.sequential.*;
import uoc.ds.pr.util.OrderedVector;

import java.time.LocalDate;
import java.util.Comparator;


public class UniversityEventsImpl implements UniversityEvents {

    protected int TOTAL_EVENT_REQUESTS = 0;
    protected Attendee MOST_ACTIVE_ATTENDEE;

    protected AttendeeList attendees = new AttendeeList(MAX_NUM_ATTENDEES);
    protected EntityList entities = new EntityList(MAX_NUM_ENTITIES);
    protected EventsList events = new EventsList(MAX_NUM_EVENTS);

    protected QueueArrayImpl<EventRequest> requests = new QueueArrayImpl<>(MAX_NUM_REQUESTS);
    protected LinkedList<EventRequest> rejectedRequests = new LinkedList<>();

    protected Comparator<Event> CMP = (Event arg1, Event arg2) -> arg1.rating().compareTo(arg2.rating());
    protected OrderedVector<Event> OrderedRanking = new OrderedVector<>(MAX_NUM_EVENTS, CMP);


    @Override
    public void addEntity(String id, String name, String description, EntityType entityType) {

            // Para poder castear un Entity a su subclase original, se debe crear como instancia de esta
            // Sin embargo  esta funcion puede romper el principio OCP y es que cada vez que se añada un nuevo tipo
            // de entidad, el switch deberá ser extendido ...
            switch(entityType){
                case STUDENT :
                    entities.addElement( new Student(id, name, description));
                    break;
                case PROFESSOR:
                    entities.addElement( new Professor(id, name, description));
                    break;
                case OTHER:
                    entities.addElement( new Organism(id, name, description));
                   break;
                default:
                    break;
           }
    }

    @Override
    public void addAttendee(String id, String name, String surname, LocalDate dateOfBirth) {
        attendees.addElement(new Attendee(id, name, surname, dateOfBirth));
    }

    @Override
    public void addEventRequest(String id, String eventId, String entityId, String description, InstallationType installationType, byte resources, int max, LocalDate startDate, LocalDate endDate, boolean allowRegister) throws EntityNotFoundException {
        if(this.getEntity(entityId) == null) throw new EntityNotFoundException();
        this.requests.add(new EventRequest(id, eventId, entityId,description, installationType, resources,  max, startDate, endDate, allowRegister));
        this.TOTAL_EVENT_REQUESTS ++;
    }

    @Override
    public EventRequest updateEventRequest(Status status, LocalDate date, String message) throws NoEventRequestException {
        EventRequest evaluated = null;
        try {
            evaluated = this.requests.poll();
            evaluated.setStatus(status);
            evaluated.setStartDate(date);

            switch(status){
                case ENABLED:
                    this.addEvent(evaluated);
                    break;
                case PENDING: // Este caso por qué iba a darse ?

                    break;
                case DISABLED:
                    this.rejectedRequests.insertEnd(evaluated);
                    break;
                default:
                    break;
            }

        }catch(Exception e){
            if(e instanceof EmptyContainerException) throw new NoEventRequestException();
        }
        return evaluated;
    }

    @Override
    public void signUpEvent(String attendeeId, String eventId) throws AttendeeNotFoundException, EventNotFoundException, NotAllowedException, AttendeeAlreadyInEventException {
        Attendee _attendee = this.getAttendee(attendeeId);
        Event _event = this.getEvent(eventId);

        if(_event == null) throw new EventNotFoundException();
        else if(_attendee == null) throw new AttendeeNotFoundException();
        else if(!_event.isAllowToRegister()) throw new NotAllowedException();

        if(_event.getAttendee(attendeeId) != null) throw new AttendeeAlreadyInEventException();

        _attendee.signUp(_event);
        _event.signUp(_attendee);
        updateMostActiveAttendee(_attendee);
    }

    protected void updateMostActiveAttendee(Attendee attendee){
       if(MOST_ACTIVE_ATTENDEE == null) this.MOST_ACTIVE_ATTENDEE = attendee;
       else {
           if(MOST_ACTIVE_ATTENDEE.numEvents() < attendee.numEvents())
               MOST_ACTIVE_ATTENDEE = attendee;
       }
    }

    @Override
    public double getPercentageRejectedRequests() {
        if(this.TOTAL_EVENT_REQUESTS == 0) return  0.0;
        return   ((double) this.rejectedRequests.size() / (double) this.TOTAL_EVENT_REQUESTS);
    }

    @Override
    public Iterator<EventRequest> getRejectedRequests() throws NoEventRequestException {
        if(rejectedRequests.size() == 0) throw  new NoEventRequestException();
        return  this.rejectedRequests.values();
    }

    @Override
    public Iterator<Event> getEventsByEntity(String entityId) throws NoEventsException {
            Iterator<Event> it =  this.events.getEventsByEntity(entityId);
            if(!it.hasNext()) throw new NoEventsException();
            else return it;
    }

    @Override
    public Iterator<Event> getAllEvents() throws NoEventsException {
        if(this.events.getCurrentSize()  == 0) throw new NoEventsException();
        else return this.events.getAll();
    }

    @Override
    public Iterator<Event> getEventsByAttendee(String attendeeId) throws NoEventsException {
        Attendee _attendee = this.getAttendee(attendeeId);
        LinkedList<Event> _events =  _attendee.getAttendedEvents();

        if(_events.size() == 0) throw new NoEventsException();
        else return _events.values();
    }

    @Override
    public void addRating(String attendeeId, String eventId, Rating rating, String message) throws AttendeeNotFoundException, EventNotFoundException, AttendeeNotInEventException {
        Attendee _attendee = this.getAttendee(attendeeId);
        Event _event = this.getEvent(eventId);
        if(_attendee == null) throw new AttendeeNotFoundException();
        if(_event== null) throw new EventNotFoundException();
        if(_event.getAttendee(attendeeId) == null) throw new AttendeeNotInEventException();

        uoc.ds.pr.model.Rating _rating = new uoc.ds.pr.model.Rating(_attendee,  rating, message);
        _event.addRating(_rating);
    }

    @Override
    public Iterator<uoc.ds.pr.model.Rating> getRatingsByEvent(String eventId) throws EventNotFoundException, NoRatingsException {
        Event _event = this.events.getElement(eventId);
        if(_event == null) throw new EventNotFoundException();
        else {
            LinkedList<uoc.ds.pr.model.Rating> ratings = _event.getRatings();
            if(ratings.size() <= 0) throw new NoRatingsException();
            else return ratings.values();
        }
    }

    @Override
    public Attendee mostActiveAttendee() throws AttendeeNotFoundException {
        if(MOST_ACTIVE_ATTENDEE == null) throw new AttendeeNotFoundException();
        else return MOST_ACTIVE_ATTENDEE;
    }

    @Override
    public Event bestEvent() throws EventNotFoundException {
        throw new EventNotFoundException();
    }

    @Override
    public int numEntities() {
        return entities.getCurrentSize();
    }

    @Override
    public int numAttendees() {
        return attendees.getCurrentSize();
    }

    @Override
    public int numRequests() {
        return this.requests.size();
    }

    @Override
    public int numEvents() {
        return events.getCurrentSize();
    }

    @Override
    public int numEventsByAttendee(String attendeeId) {
        Attendee _attendee = this.getAttendee(attendeeId);
        return _attendee.getAttendedEvents().size();
    }

    @Override
    public int numAttendeesByEvent(String eventId) {
        Event _event = this.events.getElement(eventId);
        return _event.numAttendees();
    }

    @Override
    public int numSubstitutesByEvent(String eventId) {
        Event _event = this.events.getElement(eventId);
        return _event.getSubstitutesAmnt();
    }

    @Override
    public int numEventsByEntity(String entityId) {
        return this.events.numEventsByEntity(entityId);
    }

    @Override
    public int numRejectedRequests() {
        return this.rejectedRequests.size();
    }

    @Override
    public int numRatingsByEvent(String eventId) {
        return this.getEvent(eventId).numRatings();
    }


    public void addEvent(EventRequest eventToAdd){
        this.events.addElement( new Event(
                eventToAdd.getEventId(),
                eventToAdd.getEntityId(),
                eventToAdd.getDescription(),
                eventToAdd.getInstallationType(),
                eventToAdd.getResources(),
                eventToAdd.getMax(),
                eventToAdd.getStartDate(),
                eventToAdd.getEndDate(),
                eventToAdd.isAllowRegister()
        ));
    }

    @Override
    public Entity getEntity(String entityId) {
        return this.entities.getElement(entityId);
    }

    @Override
    public Attendee getAttendee(String attendeeId) {
        return this.attendees.getElement(attendeeId);
    }

    @Override
    public Event getEvent(String eventId) {
        return this.events.getElement(eventId);
    }
}
