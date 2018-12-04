package top.mcwebsite.concurrency.renntrant_lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mengchen
 * @time 18-8-17 下午4:44
 */
public class ReenterLock implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();

    public static int i = 0;

    @Override
    public void run() {

        for (int j = 0; j < 100000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                try {
                    System.out.println(i);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock tl = new ReenterLock();
        for (int j = 0; j < 40; j++) {
            Thread thread = new Thread(tl);
            thread.start();

        }

        System.out.println(i);
    }


}