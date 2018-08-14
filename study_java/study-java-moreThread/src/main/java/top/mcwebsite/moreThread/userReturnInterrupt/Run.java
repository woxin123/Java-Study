package top.mcwebsite.moreThread.userReturnInterrupt;

/**
 * @author mengchen
 * @time 18-8-14 下午2:58
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(2000);
        myThread.interrupt();
    }

}
