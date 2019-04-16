package top.mcwebsite.concurrency.example.threadpoll;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author mengchen
 * @time 19-4-16 下午3:58
 */
@Slf4j
public class ThreadPoolExample3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            final int index = i;

            executorService.execute(() -> {
                log.info("task: {}", index);
            });
        }
    }
}
