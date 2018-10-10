package top.mcwebsite.concurrency.aotmicdemo;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author mengchen
 * @time 18-10-10 下午5:35
 */
public class AtomicIntegerArrayDemo {

    static AtomicIntegerArray arr = new AtomicIntegerArray(10);

    public static class AddThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                arr.getAndIncrement(i % arr.length());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];

        for (int i = 0; i < 10; i++) {
            ts[i] = new Thread(new AddThread());
        }

        for (int i = 0; i < 10; i++) {
            ts[i].start();
        }

        for (int i = 0; i < 10; i++) {
            ts[i].join();
        }

        System.out.println(arr);
    }

}
