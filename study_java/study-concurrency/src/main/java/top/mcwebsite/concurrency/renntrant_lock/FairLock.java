package top.mcwebsite.concurrency.renntrant_lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mengchen
 * @time 18-8-18 下午4:17
 */
public class FairLock implements Runnable {

    public static ReentrantLock fairLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            while (true) {
                try {
                    fairLock.lock();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 获得锁");
                } finally {
                    fairLock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        FairLock r1 = new FairLock();
        Thread t1 = new Thread(r1, "Thread_t1");
        Thread t2 = new Thread(r1, "Thread_t2");
        t1.start();
        t2.start();
    }

}
