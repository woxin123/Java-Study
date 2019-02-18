package top.mcwebsite.concurrency.example.atomic;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import top.mcwebsite.concurrency.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author mengchen
 * @time 19-1-23 下午6:22
 */
@ThreadSafe
@Slf4j
public class AtomicExample5 {

    public static final AtomicIntegerFieldUpdater<AtomicExample5> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    public volatile int count = 100;


    public static void main(String[] args) {
        AtomicExample5 atomicExample5 = new AtomicExample5();
        if (updater.compareAndSet(atomicExample5, 100, 120)) {
            log.info("update success 1, {}", atomicExample5.getCount());
        }
        if (updater.compareAndSet(atomicExample5, 100, 120)) {
            log.info("update success 2, {}", atomicExample5.getCount());
        } else {
            log.error("update fail, {}", atomicExample5.getCount());
        }
    }
}
