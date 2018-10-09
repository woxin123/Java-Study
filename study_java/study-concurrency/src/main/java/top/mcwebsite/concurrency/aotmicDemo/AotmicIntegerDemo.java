package top.mcwebsite.concurrency.aotmicDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mengchen
 * @time 18-10-9 下午5:56
 */
public class AotmicIntegerDemo {

    private static AtomicInteger i = new AtomicInteger();

    public static class AddThread implements Runnable {

        @Override
        public void run() {
            for (int k = 0; k < 1000; k++) {
                i.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        for (int k = 0; k < 10; k++) {
            ts[k] = new Thread(new AddThread());
        }
        for (int k = 0; k < 10; k++) {
            ts[k].start();
        }

        for (int k = 0; k < 10; k++) {
            ts[k].join();
            System.out.println(i);
        }
    }

}
