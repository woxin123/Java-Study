package top.mcwebsite.moreThread.t3;

/**
 * @author mengchen
 * @time 18-8-13 下午4:09
 */
public class Run {
    public static void main(String[] args) {
        MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");
        a.start();
        b.start();
        c.start();
    }
}
