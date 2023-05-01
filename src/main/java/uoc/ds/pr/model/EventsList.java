package uoc.ds.pr.model;

import uoc.ds.pr.model.Event;
import uoc.ds.pr.util.AbstractIdArryImpl;

public class EventsList extends AbstractIdArryImpl<Event> {

    public EventsList(int length){
        this.array = new Event[length];
    }

}


