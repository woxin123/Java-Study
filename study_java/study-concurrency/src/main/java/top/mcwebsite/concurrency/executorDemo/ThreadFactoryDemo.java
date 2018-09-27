package top.mcwebsite.concurrency.executorDemo;

import java.util.concurrent.*;

/**
 * @author mengchen
 * @time 18-9-1 下午3:01
 */
public class ThreadFactoryDemo {
    public static void main(String[] args) throws InterruptedException {
        RejectThreadPoolDemo.MyTask myTask = new RejectThreadPoolDemo.MyTask();
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L,
                TimeUnit.MILLISECONDS,
                new SynchronousQueue<>(),
                r -> {
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    System.out.println("create it");
                    return t;
                });

        for (int i = 0; i < 5; i++) {
            es.submit(myTask);
        }
        Thread.sleep(2000);
    }

}