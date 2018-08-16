package top.mcwebsite.moreThread.t17;

/**
 * yeild()方法的作用是放弃当前线程的CPU资源，将它让给其他任务去占用CPU执行时间，但放弃的时间不确定，有可能刚刚放弃了，马上有获得CPU时间。
 * yield 让步，放弃CPU，使当前线程进入就绪队列。
 *
 * @author mengchen
 * @time 18-8-16 下午3:42
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 5000000; i++) {
            // Thread.yield();
            count = count + (i + 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - beginTime) + "毫秒！");
    }

}
