package top.mcwebsite.moreThread.t4;

/**
 * @author mengchen
 * @time 18-8-13 下午4:09
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread a = new Thread(myThread, "A");
        Thread b = new Thread(myThread, "B");
        Thread c = new Thread(myThread, "C");
        Thread d = new Thread(myThread, "C");
        Thread e = new Thread(myThread, "C");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
