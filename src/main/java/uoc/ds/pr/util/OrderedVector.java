package uoc.ds.pr.util;

import edu.uoc.ds.traversal.Iterator;

import java.util.Comparator;
import java.util.Vector;

public class OrderedVector<E> {

    private Vector<E> vector;
    private Integer vectorSize;
    private Integer currentSize = 0;

    public OrderedVector(Integer len, Comparator cmp){
        this.vectorSize = len;

    }

    public void update(Integer n){

    }

    public long size(){
        return this.vectorSize;
    }

    public Iterator values(){
        return null;
    }

    public void delete(Integer i){

    }

    public void add(E element){

    }


    public boolean isFull(){
        return false;
    }



}
