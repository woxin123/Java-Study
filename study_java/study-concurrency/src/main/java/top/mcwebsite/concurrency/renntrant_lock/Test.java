package top.mcwebsite.concurrency.renntrant_lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mengchen
 * @time 18-9-17 下午9:52
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();

        Runnable r1 = () -> {
            lock.lock();
            try {
                System.out.println("aaaaaaa");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        };

        Runnable r2 = () -> {
            lock.lock();
            try {
                System.out.println("bbbb");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        Thread.sleep(2000);
        t2.start();
        t1.join();
        t2.join();
    }
}
