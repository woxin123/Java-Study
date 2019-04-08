package top.mcwebsite.concurrency.example.concurrent;

import lombok.extern.slf4j.Slf4j;
import top.mcwebsite.concurrency.annotations.ThreadSafe;

import java.util.Map;
import java.util.concurrent.*;

/**
 *
 * @author mengchen
 * @time 19-4-2 下午3:51
 */

@Slf4j
@ThreadSafe
public class ConcurrentSkipListExample {

    // 请求总数
    public static final int clientTotal = 5000;
    // 允许并发的线程总数
    public static final int threadTotal = 200;

    public static Map<Integer, Integer> map = new ConcurrentSkipListMap<>();

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
        log.info("size: {}",  map.size());
    }

    private static void update(int i) {
        map.put(i, i);
    }
}
