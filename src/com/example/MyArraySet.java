package com.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArraySet<T> implements MySet {

    private Object[] array;
    private int size,countElement;
    private static final int BASE_SIZEARRAY = 10;
    private static final int BASE_COUNTELEMENT = 0;


    MyArraySet(){
        this.size = BASE_SIZEARRAY;
        this.countElement = BASE_COUNTELEMENT;
        this.array = new Object[this.size];
    }

    MyArraySet(Object[] array){
        this.size = array.length;
        this.countElement = BASE_COUNTELEMENT;
        this.array = array;
    }

    @Override
    public <T> boolean insert(T element) {
        if(containts(element)) return  false;
        if(this.countElement == this.size ) {
            addMemory(this.array,element);
            return  true;
        }
        this.array[this.countElement] = element;
        setCountElement(getCountElement()+1);
        return true;
    }

    private <T> Iterator<T> getIterator(final T[] array, final int size) {
        return new Iterator<T>() {
            private int count = size;
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < count;
            }

            @Override
            public T next() {
                if (index < count) {
                    return array[index++];
                } else {
                    throw new NoSuchElementException("No such element.");
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Cannot remove item from array, pls used  method delete");
            }

        };
    }
    private  void addMemory(Object[] array,Object element) {
        int oldSize = getSize();
        setSize((int)(oldSize+(oldSize*0.5)));
        array = new Object [getSize()];
        array = copyingElements(array,oldSize);
        array[oldSize] = element;
        setCountElement(getCountElement()+1);
        this.array = array;
        return;
    }

    private Object[] copyingElements(Object[] array,int size) {
        for (int i = 0; i < size ; i++){
            array[i] = this.array[i];
        }
        return array;
    }


    @Override
    public void delete(Object element) {
        if(containts(element)) {
            for (int i = findIndexElement(element); i < getCountElement() - 1; i++) {
                this.array[i] = this.array[i + 1];
            }
            setCountElement(getCountElement() - 1);
        }
    }
    private int findIndexElement(Object element){
        for(int i=0;i < getCountElement();i++){
            if(this.array[i] == element){
                return i;
            }
        }
        return 0;
    }
    @Override
    public void clear() {
        setSize(10);
        setCountElement(0);
        this.array = new Object[getSize()];
    }

    @Override
    public boolean isEmpty() {
        return this.array.length > 0;
    }

    @Override
    public int size() {
        return getCountElement();
    }

    @Override
    public Iterator iteratot() {
        return getIterator(this.array,getCountElement());
    }

    @Override
    public <T> boolean containts(T element) {
        for(int i = 0; i < getCountElement();i++){
            if(this.array[i] == element){
                return true;
            }
        }
        return false;
    }

    private void setSize(int size) {
        this.size = size;
    }

    private int getSize() {
        return size;
    }

    private void setCountElement(int countElement) {
        this.countElement = countElement;
    }

    private int getCountElement() {
        return countElement;
    }
}
