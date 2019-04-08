package top.mcwebsite.concurrency.example.lock;

import lombok.extern.slf4j.Slf4j;
import top.mcwebsite.concurrency.annotations.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *
 * @author mengchen
 * @time 19-4-6 下午1:20
 */
@Slf4j
@ThreadSafe
public class LockExample1 {
    // 请求总数
    public static final int clientTotal = 5000;
    // 允许并发的线程总数
    public static final int threadTotal = 200;

    public static int count = 0;

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

    private synchronized static void add() {
        count++;
    }
}
