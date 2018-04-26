package org.example.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mengchen
 * Create by 18-4-26
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < 500; i++) {
            nums.add(i);
        }
        long aa = nums.stream().filter(num -> num > 200).count();
        System.out.println(aa);

    }

}
