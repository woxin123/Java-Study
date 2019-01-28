package top.mcwebsite.concurrency.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author mengchen
 * @time 19-1-23 下午7:41
 */
@Slf4j
public class SynchronizedExample1 {

    /**
     * 修饰一个代码块
     */
    private void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1- {} - {}", j, i);
            }      
        }
    }

    private synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {} -{}", j, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 synchronizedExample1 = new SynchronizedExample1();
        SynchronizedExample1 synchronizedExample2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            synchronizedExample1.test2(1);
        });
        executorService.submit(() -> {
            synchronizedExample2.test2(2);
        });
        executorService.shutdown();
    }
}
