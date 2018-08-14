package top.mcwebsite.moreThread.study;


/**
 * @author mengchen
 * @time 18-7-30 下午3:19
 */
public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
        number = 0;
    }
}
