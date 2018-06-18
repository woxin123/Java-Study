package org.example.test;


import java.util.ArrayList;
import java.util.Iterator;

public class TestArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        System.out.println(Thread.currentThread().getName());
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer);

        }
    }
}
