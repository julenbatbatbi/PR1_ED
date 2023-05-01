package uoc.ds.pr.model;

import uoc.ds.pr.model.Entity;
import uoc.ds.pr.util.AbstractIdArryImpl;

public class EntityList extends AbstractIdArryImpl<Entity> {


    public EntityList(int size){
        this.array = new Entity[size];
    }


}
