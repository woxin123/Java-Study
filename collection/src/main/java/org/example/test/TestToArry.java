package org.example.test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: mengchen
 * Create by 18-4-26
 */
public class TestToArry {

    public static void main(String[] args) {
        List<Character> chs = new LinkedList<>();
        chs.add('a');
        Character[] x = new Character[] {
                'a',
                'b' };
        Character[] y = chs.toArray(x);
        for (Character ch : y) {
            System.out.println(ch);
        }
    }
}
