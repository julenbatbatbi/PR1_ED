package uoc.ds.pr.model;

import edu.uoc.ds.traversal.Iterator;
import edu.uoc.ds.traversal.IteratorArrayImpl;
import uoc.ds.pr.util.AbstractIdArryImpl;

import java.util.Arrays;


public class EventsList extends AbstractIdArryImpl<Event> {

    public EventsList(int length){
        this.array = new Event[length];
    }


    public int numEventsByEntity(String entityId){
        int total = 0;
        for(int i = 0; i < this.current_elements; i++){
            String event_entityId = this.array[i].getEntityId();
            if(event_entityId.equals(entityId)) total++;
        }
        return total;
    }

    public Iterator<Event> getEventsByEntity(String entityId){
       Event[] events =  Arrays
               .stream(this.array)
               .filter( event -> (event != null)
                    && (event.getEntityId()).equals(entityId))
               .toArray(Event[]::new);
       return new IteratorArrayImpl<>(events, events.length, 0);
    }

}


