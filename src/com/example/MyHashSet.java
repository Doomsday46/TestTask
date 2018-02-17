package com.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyHashSet<T> implements MySet {

    private Object[] array;
    private int countElement;
    private int size;

    private static final int BASE_SIZEARRAY = 40;
    private static final int BASE_COUNTELEMENT = 0;

    MyHashSet() {
        this.array = new Object[BASE_SIZEARRAY];
        setCountElement(BASE_COUNTELEMENT);
        setSize(BASE_SIZEARRAY);
    }

    MyHashSet(int capacity) {
        this.array = new Object[capacity];
        setCountElement(BASE_COUNTELEMENT);
        setSize(capacity);
    }


    @Override
    public <T> boolean insert(T element) {
        if(containts(element)) return  false;
        if(this.countElement   >= this.size*0.7 ) {
            addMemory(getArray(),element);
            return  true;
        }
        int hashkey = getHashCode(element);
        add(hashkey,element);
        setCountElement(getCountElement()+1);
        return true;
    }
    private boolean add(int key,Object element){
        if(containts(element)) return false;
        int gethashcode = getHashCode(key);
        while(this.array[gethashcode] != null)
        {
            gethashcode++;
            gethashcode %= getSize();
        }
        this.array[gethashcode] = element;
        return true;
    }



    @Override
    public <T> void delete(T element) {
        if(containts(element)) {
            for (int i = getHashCode(element); i < getSize() - 1; i++) {
                this.array[i] = this.array[i + 1];
            }
            setCountElement(getCountElement() - 1);
        }
    }

    private <T> int getHashCode(T element) {
        return element.hashCode()%getSize();
    }

    @Override
    public void clear() {
        setSize(getSize());
        setCountElement(BASE_COUNTELEMENT);
        setArray(new Object[getSize()]);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return getCountElement();
    }

    @Override
    public Iterator iteratot() {
        return getIterator(getArray(), getSize());
    }

    @Override
    public <T> boolean containts(T element) {
        if(getFindElement(element) == null) return false;
        return true;
    }

    private <T> Object getFindElement(T element){
        int gethashcode = getHashCode(element);
        while(this.array[gethashcode] != null)
        {
            if(this.array[gethashcode].equals(element))
                return this.array[gethashcode];
            gethashcode++;
            gethashcode %= getSize();
        }
        return null;
    }

    private void addMemory(Object[] array, Object element) {
        int oldSize = getSize();
        setSize(oldSize*2);
        array = new Object[getSize()];
        array = copyingElements(array, oldSize);
        array[oldSize] = (T) element;
        setCountElement(getCountElement() + 1);
        setArray(array);
        return;
    }

    private Object[] copyingElements(Object[] array, int size) {
        for (int i = 0; i < size; i++) {
            array[i] = this.array[i];
        }
        return array;
    }

    private static <T> Iterator<T> getIterator(final T[] array, final int size) {
        return new Iterator<T>() {
            private int count = size;
            private int index = 0;

            @Override
            public boolean hasNext() {
                for(int i = index; i < count; i++){
                    if(array[i] != null) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public T next() {
                for(int i = index; i < count; i++){
                    if(array[i] != null) {
                        index = i+1;
                        return array[i];
                    }
                }
                 throw new NoSuchElementException("No such element.");
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Cannot remove item from array, pls used base method delete");
            }
        };
    }

    public int getCountElement() {
        return countElement;
    }

    public void setCountElement(int countElement) {
        this.countElement = countElement;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }
}
