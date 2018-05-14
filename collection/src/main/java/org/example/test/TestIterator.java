package org.example.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: mengchen
 * Create by 18-4-26
 */
public class TestIterator {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < 500; i++) {
            nums.add(i);
        }
        Iterator<Integer> iterator = nums.iterator();
//        while (iterator.hasNext()) {
//            System.out.print(iterator.next());
//        }
//        iterator.forEachRemaining(num -> {
//            System.out.print(num);
//        });

        while (iterator.hasNext()) {
            int num = iterator.next();
            if (num < 100) {
                System.out.println(num);
            } else {
                iterator.remove();
            }
        }

        nums.forEach(num-> System.out.println(num));
    }
}
