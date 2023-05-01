package uoc.ds.pr.model;

import uoc.ds.pr.UniversityEvents;

public class Organism extends  Entity {
    public Organism(String identifier, String name, String description ) {
        super(identifier, name, description, UniversityEvents.EntityType.OTHER);
    }
}
