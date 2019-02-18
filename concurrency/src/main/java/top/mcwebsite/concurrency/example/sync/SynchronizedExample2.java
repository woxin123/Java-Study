package top.mcwebsite.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author mengchen
 * @time 19-1-23 下午7:41
 */
@Slf4j
public class SynchronizedExample2 {

    /**
     * 修饰一个类
     */
    private void test1(int j) {
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1- {} - {}", j, i);
            }      
        }
    }

    /**
     * synchronized修饰静态方法
     * @param j
     */
    private static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {} -{}", j, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 synchronizedExample1 = new SynchronizedExample2();
        SynchronizedExample2 synchronizedExample2 = new SynchronizedExample2();
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
