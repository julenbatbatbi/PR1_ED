package uoc.ds.pr.model;

import uoc.ds.pr.model.Attendee;
import uoc.ds.pr.util.AbstractIdArryImpl;

public class AttendeeList extends AbstractIdArryImpl<Attendee> {
    public AttendeeList(int size){
        this.array = new Attendee[size];
    }
}
