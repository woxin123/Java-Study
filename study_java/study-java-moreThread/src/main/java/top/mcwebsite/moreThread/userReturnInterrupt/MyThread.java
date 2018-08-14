package top.mcwebsite.moreThread.userReturnInterrupt;

/**
 * @author mengchen
 * @time 18-8-14 下午2:54
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        while (true) {
            if (this.isInterrupted()) {
                System.out.println("停止了！");
                return;
            }
            System.out.println("time=" + System.currentTimeMillis());
        }
    }
}
