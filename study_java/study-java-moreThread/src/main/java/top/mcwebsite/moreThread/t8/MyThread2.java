package top.mcwebsite.moreThread.t8;

/**
 * @author mengchen
 * @time 18-8-13 下午7:25
 */
public class MyThread2 extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("run threadName=" + this.getName() + " begin ="
                    + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("run threadName=" + this.getName() + " end ="
                    + System.currentTimeMillis());
        } catch (Exception e) {

        }
    }
}
