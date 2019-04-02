package top.mcwebsite.concurrency.example.syncContainer;

import top.mcwebsite.concurrency.annotations.ThreadSafe;

import java.util.Vector;

/**
 * set.get(i)可能会抛出ArrayIndexOutOfBoundsException异常，但是不能说明是线程不安全的
 * @author mengchen
 * @time 19-4-2 下午4:27
 */
@ThreadSafe
public class VectorExample2 {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }
            });
            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    // 这里可能会抛出ArrayIndexOutOfBoundsException，但是不能说明它是线程不安全的
                    vector.get(i);
                }
            });

            thread1.start();
            thread2.start();
        }
    }

}
