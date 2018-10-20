package top.mcwebsite.concurrency.start;

/**
 * @author mengchen
 * @time 18-8-16 下午5:02
 */
public class MultiThreadLong {

    public static long t = 0;

    public static class ChangeT implements Runnable {

        private long to;

        public ChangeT(long to) {
            this.to = to;
        }

        public void run() {
            while (true) {
                MultiThreadLong.t = to;
                Thread.yield();
            }
        }
    }

    public static class ReadT implements Runnable {

        public void run() {
            while (true) {
                long tmp = MultiThreadLong.t;
                if (tmp != 111L && tmp != -999L && tmp != 333L && tmp != -444L) {
                    System.out.println(tmp);
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ChangeT(111L)).start();
        new Thread(new ChangeT(-999)).start();
        new Thread(new ChangeT(333)).start();
        new Thread(new ChangeT(-444)).start();
        new Thread(new ReadT()).start();
    }

}