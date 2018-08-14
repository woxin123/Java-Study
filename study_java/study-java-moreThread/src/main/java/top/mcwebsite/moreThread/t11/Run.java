package top.mcwebsite.moreThread.t11;

/**
 * @author mengchen
 * @time 18-8-14 上午9:17
 */
public class Run {

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }

}
