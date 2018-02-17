package com.example;

import java.util.Iterator;

public interface MySet {

    <T> boolean insert(T element);

    <T> void delete(T element);

    void clear();

    boolean isEmpty();

    int size();

    Iterator iteratot();

    <T>boolean containts(T element);
}
