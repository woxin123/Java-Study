package top.mcwebsite.concurrency.example.blockingqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author mengchen
 * @time 19-4-13 下午10:45
 */
@Slf4j
public class ArrayBlockingQueueExample {

    // 非公平的阻塞队列
    // private static ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

    // 公平的阻塞队列
    private static ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10, true);

    public static void main(String[] args) throws InterruptedException {
        // 放入10个元素
        for (int i = 0; i < 10; i++) {
            log.info("往阻塞队列中放入：{}", i);
            blockingQueue.put(i);
        }
        if (blockingQueue.remainingCapacity() > 0) {
            log.info("阻塞队列中没有空间了");
        } else {
            log.info("阻塞队列中的剩余空间：{}", blockingQueue.remainingCapacity());
        }
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                Integer take = blockingQueue.take();
                log.info("从阻塞队列中取出一个数据：{}", take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        log.info("往阻塞队列插入一个数据");

        try {
            blockingQueue.add(11);
        } catch (IllegalStateException e) {
            log.info("往阻塞队列中插入（add）数据的时候发生异常：{}", e);
        }

        boolean offer = blockingQueue.offer(11);
        log.info("往阻塞队列中插入(offer)数据的时候，返回一个特殊值，{}", offer);

        log.info("往阻塞队列中插入(put)数据的时候，一直阻塞");
        blockingQueue.put(11);

        for (int i = 0; i < 10; i++) {
            Integer take = blockingQueue.take();
            log.info("从阻塞队列中取出一个元素：{}", take);
        }

    }

}
