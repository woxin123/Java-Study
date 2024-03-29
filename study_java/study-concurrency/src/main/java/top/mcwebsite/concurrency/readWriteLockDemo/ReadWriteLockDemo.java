package top.mcwebsite.concurrency.readWriteLockDemo;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author mengchen
 * @time 18-8-30 上午11:01
 */
public class ReadWriteLockDemo {

    private static Lock lock = new ReentrantLock();

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static Lock readLock = readWriteLock.readLock();

    private static Lock writeLock = readWriteLock.writeLock();

    private int value;

    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            // 模拟读操作
            lock.lock();
            // 读操作耗时越多，读写锁的优势就越明显
            Thread.sleep(1000);
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock, int index) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            value = index;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = () -> {
            try {
//                demo.handleRead(readLock);
                 demo.handleRead(lock);
                System.out.println("run:" + (System.currentTimeMillis() - start));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable writeRunnable = () -> {
            try {
//                demo.handleWrite(writeLock, new Random().nextInt());
                 demo.handleWrite(lock, new Random().nextInt());
                System.out.println("run:" + (System.currentTimeMillis() - start));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 18; i++) {
            new Thread(readRunnable).start();
        }

        for (int i = 18; i < 20; i++) {
            new Thread(writeRunnable).start();
        }


    }

}
