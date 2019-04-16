package top.mcwebsite.concurrency.example.blockingqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author mengchen
 * @time 19-4-14 下午12:48
 */
@Slf4j
public class PriorityBlockingQueueExample {

    private static PriorityBlockingQueue<Integer> blockingQueue = new PriorityBlockingQueue<>();


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

        log.info("这里因为是无界队列所以不会发生异常");
        blockingQueue.add(11);


        boolean offer = blockingQueue.offer(11);
        log.info("往阻塞队列中插入(offer)数据的时候，返回一个特殊值，{}", offer);

        log.info("往阻塞队列中插入(put)数据的时候，这里因为是无界队列，所以不会阻塞");
        blockingQueue.put(11);

        for (int i = 0; i < 10; i++) {
            Integer take = blockingQueue.take();
            log.info("从阻塞队列中取出一个元素：{}", take);
        }

    }



}
