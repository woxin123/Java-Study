package top.mcwebsite.concurrency.example.concurrent;

import lombok.extern.slf4j.Slf4j;
import top.mcwebsite.concurrency.annotations.ThreadSafe;

import java.util.Set;
import java.util.concurrent.*;

/**
 * 基于CopyOnWriteArrayList实现的
 * @author mengchen
 * @time 19-4-5 下午5:25
 */
@Slf4j
@ThreadSafe
public class CopyOnWriteArraySetExample {
    // 请求总数
    public static final int clientTotal = 5000;
    // 允许并发的线程总数
    public static final int threadTotal = 200;

    public static Set<Integer> set = new CopyOnWriteArraySet<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size: {}",  set.size());
    }

    private static void update(int i) {
        set.add(i);
    }
}
