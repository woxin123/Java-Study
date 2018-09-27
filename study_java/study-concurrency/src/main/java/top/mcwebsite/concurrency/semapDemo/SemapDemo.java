package top.mcwebsite.concurrency.semapDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author mengchen
 * @time 18-8-29 下午9:46
 */
public class SemapDemo implements Runnable {

    final Semaphore semp = new Semaphore(5);

    @Override
    public void run() {
        try {
            semp.acquire();
            // 模拟耗时操作
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getId() + "done");
            semp.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemapDemo semapDemo = new SemapDemo();
        for (int i = 0; i < 50; i++) {
            exec.submit(semapDemo);
        }
    }
}
