package top.mcwebsite.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author mengchen
 * @time 19-4-5 下午10:14
 */
@Slf4j
public class CyclicBarrierExample2 {

    private static CyclicBarrier barrier = new CyclicBarrier(5, () -> {
        log.info("callback is running");
    });

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            final int thread = i;
            exec.execute(() -> {
                try {
                    race(thread);
                } catch (Exception e) {
                    log.info("exception", e);
                }
            });
        }
        exec.shutdown();
    }

    private static void race(int threadNum) throws InterruptedException, TimeoutException, BrokenBarrierException {
        Thread.sleep(1000);
        log.info("{} is ready", threadNum);
        barrier.await();
        log.info("{} continue", threadNum);
    }
}
