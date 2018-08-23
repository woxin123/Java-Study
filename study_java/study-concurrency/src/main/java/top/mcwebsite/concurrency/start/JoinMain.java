package top.mcwebsite.concurrency.start;

/**
 * @author mengchen
 * @time 18-8-17 上午9:54
 */
public class JoinMain {

    public volatile static int i = 0;

    public static class AddThread extends Thread {
        @Override
        public void run() {
            for (i = 0; i < 100000000; i++) {

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread at = new AddThread();
        at.start();
        at.join();
        System.out.println(i);
    }

}