package top.mcwebsite.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author mengchen
 * @time 19-4-8 下午9:50
 */
@Slf4j
public class FutureTaskExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            log.info("do something in callable");
            Thread.sleep(100000);
            return "Done";
        });

        new Thread(futureTask).start();
        log.info("do something in main");
        String result = futureTask.get(260, TimeUnit.SECONDS);
        log.info("result: {}", result);
    }
}
