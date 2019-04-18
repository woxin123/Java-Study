package top.mcwebsite.concurrency.example.deadlock;

import lombok.extern.slf4j.Slf4j;

/**
 * 死锁产生的四个条件：
 * 1. 互斥条件
 * 2. 请求和保持 ：保持自己的资源 请求新的资源
 * 3. 不可剥夺
 * 4. 环路等待条件
 *
 * 死锁避免
 * 1. 加锁顺序
 * 2. 每个线程加锁都有时限
 * 3. 死锁检测
 * @author men   gchen
 * @time 19-4-18 下午9:11
 */
@Slf4j
public class DeadLock implements Runnable {
    public static volatile int flag = 1;
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();


    @Override
    public void run() {
        log.info("flag: {}", flag);
        if (flag == 1) {
            synchronized (lock1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock2) {
                    log.info("1");
                }
            }
        }
        if (flag == 0) {
            synchronized (lock2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    log.info("2");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLock deadLock = new DeadLock();

        new Thread(deadLock).start();
        Thread.sleep(200);
        flag = 0;
        new Thread(deadLock).start();
    }
}
