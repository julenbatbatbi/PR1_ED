package uoc.ds.pr.model;

import uoc.ds.pr.UniversityEvents;

public class Rating {

    private final Attendee attendee;
    private final Event event;
    private UniversityEvents.Rating rating;
    public Rating(Attendee attendee, Event event, UniversityEvents.Rating grade){
            this.attendee = attendee;
            this.event = event;
            this.rating = grade;
    }

    public Attendee getAttendee(){
        return null;
    }
}
