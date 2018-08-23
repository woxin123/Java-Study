package top.mcwebsite.concurrency.start;

/**
 * @author mengchen
 * @time 18-8-17 上午11:22
 */
public class DaemonDemo {

    public static class DaemonT extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("I am alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new DaemonT();
        t.start();
        t.setDaemon(true);

        Thread.sleep(2000);
    }
}
