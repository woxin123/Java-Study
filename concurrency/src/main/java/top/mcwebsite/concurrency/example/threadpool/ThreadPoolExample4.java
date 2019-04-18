package top.mcwebsite.concurrency.example.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author mengchen
 * @time 19-4-16 下午3:58
 */
@Slf4j
public class ThreadPoolExample4 {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

        for (int i = 0; i < 10; i++) {
            final int index = i;

            executorService.schedule(() -> {
                log.info("task: {}", index);
            }, 3, TimeUnit.SECONDS);
        }
        executorService.scheduleAtFixedRate(() -> {
            log.info("schedule run");
        }, 1, 3, TimeUnit.SECONDS);
//        executorService.shutdown();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.warn("timer run");
            }
        }, new Date(), 5 * 1000);
    }
}
