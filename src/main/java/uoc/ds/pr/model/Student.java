package uoc.ds.pr.model;

import uoc.ds.pr.UniversityEvents;

public class Student extends Entity{

    public Student(String identifier, String name, String description) {
        super(identifier, name, description,  UniversityEvents.EntityType.STUDENT);
    }
}
