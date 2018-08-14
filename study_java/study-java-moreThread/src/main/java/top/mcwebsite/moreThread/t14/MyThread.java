package top.mcwebsite.moreThread.t14;

/**
 * 通过沉睡让线程停止
 * @author mengchen
 * @time 18-8-14 上午11:00
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("run begin");
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止了！进入catch!" + this.isInterrupted());
            e.printStackTrace();
        }
    }
}
