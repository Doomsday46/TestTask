package com.example;

import java.util.*;

public class LinkedMySet<T> implements MySet {

    private List<Object> list;

    LinkedMySet(){
      this.list =  new LinkedList<>();
    }

    @Override
    public <T> boolean insert(T element) {
        if(containts(element)) {
            this.list.add(element);
            return true;
        }
        return false;

    }

    @Override
    public <T> void delete(T element) {
        this.list.remove(element);
    }

    @Override
    public void clear() {
        this.list.clear();
    }
    @Override
    public Iterator iteratot() {
        return this.list.iterator();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public <T> boolean containts(T element) {
        if(Collections.frequency(this.list,element) == 0) return true;
        return false;
    }

}
