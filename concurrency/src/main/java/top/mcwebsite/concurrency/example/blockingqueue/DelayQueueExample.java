package top.mcwebsite.concurrency.example.blockingqueue;


import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author mengchen
 * @time 19-4-14 下午2:35
 */
@Slf4j
public class DelayQueueExample {

    static class MyDelayedClass implements Delayed {
        private long time;
        private int value;

        public MyDelayedClass(long time, int value) {
            this.time = System.nanoTime() + time;
            this.value = value;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(time - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (o == this) {
                return 0;
            }
            if (o instanceof MyDelayedClass) {
                MyDelayedClass x = (MyDelayedClass) o;
                long diff = time - x.time;
                if (diff < 0) {
                    return -1;
                } else if (diff > 0) {
                    return 1;
                } else {
                    return 0;
                }
            }

            long diff = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
            return (diff < 0) ? -1 : (diff > 0) ? 1 : 0;
        }
    }

    private static DelayQueue<MyDelayedClass> delayQueue = new DelayQueue<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            delayQueue.put(new MyDelayedClass(TimeUnit.NANOSECONDS.convert((i + 1) * 10, TimeUnit.SECONDS), i));
        }

        for (int i = 0; i < 10; i++) {
            log.info("从DelayQueue中获取元素，时间为：{}", new Date());
            MyDelayedClass take = delayQueue.take();
            log.info("从DelayQueue中获取元素成功，时间为：{}", new Date());
        }
    }

}
