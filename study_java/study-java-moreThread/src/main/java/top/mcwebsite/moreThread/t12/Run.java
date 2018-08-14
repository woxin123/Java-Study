package top.mcwebsite.moreThread.t12;

/**
 * @author mengchen
 * @time 18-8-14 上午9:52
 */
public class Run {

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            System.out.println("是否停止1？ =" + thread.interrupted());
            System.out.println("是否停止2？ =" + thread.interrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
