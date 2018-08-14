package top.mcwebsite.moreThread.t4;

/**
 * @author mengchen
 * @time 18-8-13 下午4:05
 */
public class MyThread extends Thread {
    private int count = 5;


    /**
     * 这里肯定得使用同步如果不使用就会产生线程安全问题，，
     */
    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println("由 " + currentThread().getName()
                + " 计算，count=" + count);
    }
}
