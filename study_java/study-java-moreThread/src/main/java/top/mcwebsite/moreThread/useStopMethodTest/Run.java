package top.mcwebsite.moreThread.useStopMethodTest;

/**
 * @author mengchen
 * @time 18-8-14 上午11:24
 */
public class Run {

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(8000);
            thread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
