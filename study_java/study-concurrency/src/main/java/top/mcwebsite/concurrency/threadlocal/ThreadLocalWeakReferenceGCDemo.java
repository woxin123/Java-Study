package top.mcwebsite.concurrency.threadlocal;

import java.util.*;

/**
 * @author mengchen
 * @time 18-11-15 上午11:15
 */
public class ThreadLocalWeakReferenceGCDemo {

    private static final int THREAD_LOOP_SIZE = 20;


    public static void main(String[] args) throws InterruptedException {

        try {
            //等待连接JConsole
            Thread.sleep(5000);
            System.gc();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < THREAD_LOOP_SIZE; i++) {
            ThreadLocal<Map<Byte[], String>> threadLocal = new ThreadLocal<>();
//            set.add(threadLocal);
            Map<Byte[], String> map = new HashMap<>();
            map.put(new Byte[1024 * 1024 * 3], "我是第" + i + "个ThreadLocal数据！");
            threadLocal.set(map);
            threadLocal = null;
//            Thread.sleep(3000);
        }
    }
}

