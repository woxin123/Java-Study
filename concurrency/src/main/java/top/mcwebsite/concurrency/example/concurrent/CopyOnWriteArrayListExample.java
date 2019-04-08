package top.mcwebsite.concurrency.example.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * CopyOnWriteArrayList
 * add操作是在锁的保护下进行的
 *
 * 缺点：
 * 1. 因为是在写的时候复制一个副本，所以如果数据量过大的时候，容易触发GC。
 * 2.不能保障数据读的实时性。
 *
 * 设计思想：
 *  1. 读写分离。
 *  2. 最终一致性。
 *  3. 通过额外的空间，保证安全性。
 *
 * 场景：适合读多写少的场景。
 * @author mengchen
 * @time 19-4-4 下午10:44
 */
@Slf4j
public class CopyOnWriteArrayListExample {
    // 请求总数
    public static final int clientTotal = 5000;
    // 允许并发的线程总数
    public static final int threadTotal = 200;

    public static List<Integer> list = new CopyOnWriteArrayList<>();

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
        log.info("size: {}",  list.size());
    }

    private static void update(int i) {
        list.add(i);
    }
}
