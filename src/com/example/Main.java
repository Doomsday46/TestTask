package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyHashSet<Integer> mas = new MyHashSet(50);
        mas.insert(4);
        mas.insert(3);
        mas.insert(6);
        mas.insert(4);
        Iterator<Integer> iter = mas.iteratot();
        while(iter.hasNext()){
            System.out.print(iter.next());

        };
        System.out.print(mas.containts(6));
//        mas.delete(4);
//        while(iter.hasNext()){
//            System.out.print(iter.next());
//
//        };
//        while(iter.hasNext()){
//            System.out.print(iter.next());
//
//        };
    }

}
