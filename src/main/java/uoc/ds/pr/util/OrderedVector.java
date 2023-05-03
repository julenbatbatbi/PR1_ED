package uoc.ds.pr.util;

import edu.uoc.ds.traversal.Iterator;
import edu.uoc.ds.traversal.IteratorArrayImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class OrderedVector<E> {

    protected E[] vector;
    protected Integer vectorSize;
    protected Integer currentSize = 0;
    protected Comparator<E> comparator;

    public OrderedVector(Integer len, Comparator<E> cmp){
        this.vectorSize = len;
        this.vector =(E[]) new  Object[len];
        this.comparator = cmp;
    }


    public void update(E n){
        if((currentSize < vectorSize)) vector[currentSize++] = n;
        else if(comparator.compare(n, vector[vectorSize -1] ) ==  1){
            vector[vectorSize -1] = n;
        } else return;
        sort();
    }


    public void sort(){
      E[] _newValues = (E[])  Arrays.stream(vector, 0, currentSize).sorted(comparator).toArray(Object[]::new);
      for(int i = 0; i < _newValues.length; i++){
          this.vector[(currentSize -1) - i] = _newValues[i];
      }
    }




    public long size(){
        return this.currentSize;
    }

    public Iterator<E> values(){
        return new IteratorArrayImpl<>(this.vector, currentSize, 0);
    }

    public void delete(E e){
        int  i = findIndex(e);
        E[] _sliceOne = this.slice(this.vector,0, i);
        E[] _sliceTwo = this.slice(this.vector, i+1, currentSize);

        this.currentSize--;
        E[] merged = merge(currentSize, _sliceOne, _sliceTwo);
        setIntoArray(this.vector, merged);
    }

    protected void setIntoArray(E[] into, E[] from ){
        for(int i = 0; i < into.length; i++){
            into[i] = i < from.length ? from[i] : null;
        }
    }


    protected E[] slice(E[] vector, int from, int to){
        E[] _sliceReturn =  (E[]) new Object[to - from];

        for(int i = 0; i < _sliceReturn.length; i++){
            _sliceReturn[i] = vector[from + i];
        }

        return _sliceReturn;
    }


    protected int findIndex(E e){
        for(int i = 0; i < currentSize; i++){
           if( comparator.compare(this.vector[i], e ) == 0) return i;
        }
        return -1;
    }

    protected E[] merge(int size, E[] ...slices){
        E[] _f = (E[]) new Object[size];

        int currentIndex = 0;
        for(E[] slice: slices){
            for (E e : slice) {
                _f[currentIndex++] = e;
            }
        }

        return  _f;
    }



    public boolean isFull(){
        return vectorSize <= currentSize;
    }

}
