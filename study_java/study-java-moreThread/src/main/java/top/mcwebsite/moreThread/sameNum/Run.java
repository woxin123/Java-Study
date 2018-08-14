package top.mcwebsite.moreThread.sameNum;

/**
 * @author mengchen
 * @time 18-8-13 下午4:34
 */
public class Run {
    public static void main(String[] args) {
        MyThread run = new MyThread();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);
        Thread t4 = new Thread(run);
        Thread t5 = new Thread(run);
        Thread t6 = new Thread(run);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
