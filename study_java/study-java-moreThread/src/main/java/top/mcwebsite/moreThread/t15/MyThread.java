package top.mcwebsite.moreThread.t15;

/**
 * @author mengchen
 * @time 18-8-14 上午11:00
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 300000; i++) {
                System.out.println("i=" + (i + 1));
            }
            System.out.println("run begin");
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("先停止，在遇到sleep!进入catch");
            e.printStackTrace();
        }
    }
}
