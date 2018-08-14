package top.mcwebsite.moreThread.t7;

/**
 * @author mengchen
 * @time 18-8-13 下午4:50
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        System.out.println("begin ==" + myThread.isAlive());
        myThread.start();
        Thread.sleep(1000);
        System.out.println("end ==" + myThread.isAlive());
    }
}
