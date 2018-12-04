package top.mcwebsite.concurrency.renntrant_lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mengchen
 * @time 18-11-26 下午9:41
 */
public class TestReentrant extends Thread{

    @Override
    public void run() {
        reentrantLock.lock();
        System.out.println("我的");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static ReentrantLock  reentrantLock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        new TestReentrant().start();
        Thread.sleep(3000);
        new TestReentrant().start();
    }

}
