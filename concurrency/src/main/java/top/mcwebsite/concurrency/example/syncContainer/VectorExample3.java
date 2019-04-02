package top.mcwebsite.concurrency.example.syncContainer;

import top.mcwebsite.concurrency.annotations.ThreadSafe;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author mengchen
 * @time 19-4-2 下午4:27
 */
@ThreadSafe
public class VectorExample3 {

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test1(vector);
    }

    public static void test1(Vector<Integer> vector) {
        for (int i : vector) {
            if (i == 3) {
                vector.remove(i);
            }
        }
    }

    public static void test2(Vector<Integer> vector) {
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3)) {
                vector.remove(i);
            }
        }
    }

    // success
    public static void test3(Vector<Integer> vector) {
        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i) == 3) {
                vector.remove(i);
            }
        }
    }

}
