package top.mcwebsite.moreThread.t8;

/**
 * @author mengchen
 * @time 18-8-13 下午7:02
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("run threadName="
                    + currentThread().getName() + "begin");
            Thread.sleep(2000);
            System.out.println("run threadName="
                    + currentThread().getName() + "end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
