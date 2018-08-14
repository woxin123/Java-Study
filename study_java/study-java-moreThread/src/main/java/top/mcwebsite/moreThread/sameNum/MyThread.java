package top.mcwebsite.moreThread.sameNum;

/**
 * @author mengchen
 * @time 18-8-13 下午4:32
 */
public class MyThread extends Thread {
    private int i = 5;

    @Override
    public void run() {
        System.out.println("i=" + (i--) + "threadName="
                + currentThread().getName());
    }
}
