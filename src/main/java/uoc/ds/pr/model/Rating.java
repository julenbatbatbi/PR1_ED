package uoc.ds.pr.model;

import uoc.ds.pr.UniversityEvents;

public class Rating {

    private final Attendee attendee;

    private UniversityEvents.Rating rating;
    private  String message;

    public Rating(Attendee attendee,  UniversityEvents.Rating grade, String message){
            this.attendee = attendee;
            this.rating = grade;
            this.message = message;
    }

    public Attendee getAttendee() {
        return attendee;
    }

    public UniversityEvents.Rating getRating() {
        return rating;
    }

    public String getMessage() {
        return message;
    }
}
