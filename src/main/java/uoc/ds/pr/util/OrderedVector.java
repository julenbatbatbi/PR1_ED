package uoc.ds.pr.util;

import edu.uoc.ds.traversal.Iterator;

import java.util.Arrays;
import java.util.Comparator;

public class OrderedVector<E> {

    protected E[] vector;
    protected Integer vectorSize;
    protected Integer currentSize = 0;
    protected Comparator<E> comparator;

    public OrderedVector(Integer len, Comparator<E> cmp){
        this.vectorSize = len;
        this.vector =( E[]) new  Object[len];
        this.comparator = cmp;
    }


    public void update(E n){
        vector[currentSize++] = n;
        sort();
    }


    public void sort(){
        Iterator<E> it = (Iterator<E>) Arrays.stream(vector).sorted(comparator);
        int idx = 0;
        while(it.hasNext()){
            vector[idx] = it.next();
            idx++;
        }
    }




    public long size(){
        return this.vectorSize;
    }

    public Iterator<E> values(){
        return (Iterator<E>) Arrays.stream(vector);
    }

    public void delete(Integer i){

    }



    public boolean isFull(){
        return vectorSize <= currentSize;
    }



}
