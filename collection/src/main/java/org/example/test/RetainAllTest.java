package org.example.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RetainAllTest {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>();
        a.add(2);

        List<Integer> b = new ArrayList<>();

        b.add(3);
        b.add(2);
        b.retainAll(a);
        System.out.println(b);
    }
}
