package top.mcwebsite.concurrency.example.atomic;

import lombok.extern.slf4j.Slf4j;
import top.mcwebsite.concurrency.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author mengchen
 * @time 19-1-23 下午6:22
 */
@ThreadSafe
@Slf4j
public class AtomicExample4 {

    public static final AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0, 2);  // count = 2
        count.compareAndSet(1, 4);  //
        count.compareAndSet(2, 5);  // count = 5
        count.compareAndSet(5, 4);  // count = 4
        log.info("count:{}", count.get());
    }
}
