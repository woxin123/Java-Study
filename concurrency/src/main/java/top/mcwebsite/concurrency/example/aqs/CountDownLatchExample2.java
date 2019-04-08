package top.mcwebsite.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author mengchen
 * @time 19-4-5 下午10:14
 */
@Slf4j
public class CountDownLatchExample2 {

    private static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                test(threadNum);
                countDownLatch.countDown();
            });
        }
        countDownLatch.await(10, TimeUnit.MICROSECONDS);
        log.info("finish");
        exec.shutdown();
    }

    private static void test(int threadNum) {
        log.info("{}", threadNum);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
