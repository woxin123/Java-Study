package top.mcwebsite.concurrency.example.lock;

import lombok.extern.slf4j.Slf4j;
import top.mcwebsite.concurrency.annotations.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 * - 可重入锁
 * - 锁的实现
 * - 性能的区别
 * - 功能区别
 *
 * ReentrantLock独有的功能
 * - 可指定公平锁还是非公平锁
 * - 提供了一个Condition类，可以分组唤醒需要唤醒的线程
 * - 提供了能够中断等待锁的线程机制，lock.lockInterruptibly()
 *
 * @author mengchen
 * @time 19-4-6 下午1:20
 */
@Slf4j
@ThreadSafe
public class LockExample2 {
    // 请求总数
    public static final int clientTotal = 5000;
    // 允许并发的线程总数
    public static final int threadTotal = 200;

    public static int count = 0;

    private final static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count: " + count);
    }

    private static void add() {
        lock.lock();
        count++;
        lock.unlock();
    }
}
