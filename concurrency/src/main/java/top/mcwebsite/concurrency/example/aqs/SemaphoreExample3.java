package top.mcwebsite.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author mengchen
 * @time 19-4-5 下午10:14
 */
@Slf4j
public class SemaphoreExample3 {

    private static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    if (semaphore.tryAcquire(3)) {   // 尝试获取许可
                        test(threadNum);
                        semaphore.release(3);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        log.info("finish");
        exec.shutdown();
    }

    private static void test(int threadNum) {
        log.info("{}", threadNum);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
