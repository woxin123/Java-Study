package top.mcwebsite.concurrency.renntrant_lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mengchen
 * @time 18-11-23 下午11:36
 */
public class ConditionLock {
    static int i = 0;
    public static void main(String[] args)  {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        Thread thread = (new Thread(() -> {
            reentrantLock.lock();
            for (int j = 0; j< 1000;j++) {
                i++;
                try {
                    System.out.println("累加：" + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            reentrantLock.unlock();
        }));
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            condition.await();
        } catch (Exception e) {
            System.out.println("aaa");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
