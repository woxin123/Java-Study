package top.mcwebsite.concurrency.start;


/**
 * @author mengchen
 * @time 18-8-17 上午10:28
 */
public class NoVisibility {

    private static boolean ready;

    private static int number;

    private static class ReaderThread extends Thread {

        @Override
        public void run() {
            while (!ready) {
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReaderThread readerThread = new ReaderThread();
        readerThread.start();
        Thread.sleep(1000);
        number = 42;
        ready = true;
        Thread.sleep(1000);
        readerThread.join();
    }

}
