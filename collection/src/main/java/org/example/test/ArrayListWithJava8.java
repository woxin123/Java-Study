package org.example.test;


import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.lang.reflect.Constructor;
import java.nio.channels.Channel;
import java.text.NumberFormat;
import java.util.*;

public class ArrayListWithJava8 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1; i++) {
            list.add(random.nextInt());
        }
        list.stream();
        Spliterator<Integer> spliterator = list.spliterator();
        System.out.println(spliterator.tryAdvance(o1-> System.out.println(o1)));
        System.out.println(spliterator.tryAdvance(o1-> System.out.println(o1)));
//        long character = list.spliterator().characteristics();
//
//        System.out.println(character);
//        list.sort((o1, o2)-> {
//            if (o1 > o2)
//                return 1;
//            return -1;
//        });
//        System.out.println(list);
//        System.out.println(list.spliterator().getComparator());

    }
}
