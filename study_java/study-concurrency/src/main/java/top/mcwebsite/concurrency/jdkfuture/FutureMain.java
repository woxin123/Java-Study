package top.mcwebsite.concurrency.jdkfuture;

import java.util.concurrent.*;

/**
 * @author mengchen
 * @time 18-10-11 下午4:17
 */
public class FutureMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> future = new FutureTask<>(new RealData("name"));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(future);
        System.out.println("请求完毕");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("数据 = " + future.get());
    }
}
