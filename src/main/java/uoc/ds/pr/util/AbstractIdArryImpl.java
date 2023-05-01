package uoc.ds.pr.util;

import edu.uoc.ds.traversal.Iterator;
import edu.uoc.ds.traversal.IteratorArrayImpl;


public abstract class AbstractIdArryImpl<T extends ElementWithId> {

    protected  int MAXLENGTH = 10000;
    protected int current_elements = 0;
    protected T[] array;


    public T getElement(String id){
        for(int i = 0; i < array.length; i++){
            if(array[i] == null) return null;
            else if(array[i].getId().equals(id)) return array[i];
        }

        return null;
    }

    public void addElement(T el){
        for(int i = 0; i < current_elements; i++){
            if(this.array[i].getId().equals(el.getId())) {
                this.array[i] = el;
                return;
            }
        }
        this.array[current_elements++] = el;
    }

    public int getCurrentSize(){
        return this.current_elements;
    }

    public Iterator<T> getAll(){
        return new IteratorArrayImpl<>(this.array, current_elements, 0);
    }

}
