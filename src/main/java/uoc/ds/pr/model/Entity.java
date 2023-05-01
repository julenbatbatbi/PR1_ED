package uoc.ds.pr.model;

import uoc.ds.pr.UniversityEvents;
import uoc.ds.pr.util.ElementWithId;

public class Entity extends ElementWithId {

    protected String name;
    protected String description;


    protected UniversityEvents.EntityType type;


    protected Entity(String id, String name, String description,  UniversityEvents.EntityType type){
        this.name = name;
        this.description = description;
        this.id = id;
        this.type = type;
    }

    public UniversityEvents.EntityType getType() {
        return type;
    }
    @Override
    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(UniversityEvents.EntityType type) {
        this.type = type;
    }
}
