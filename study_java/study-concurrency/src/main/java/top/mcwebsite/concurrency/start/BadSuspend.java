package top.mcwebsite.concurrency.start;

import java.lang.management.ManagementFactory;

/**
 * @author mengchen
 * @time 18-8-17 上午9:07
 */
public class BadSuspend {

    public static Object u = new Object();

    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {

        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                String name = ManagementFactory.getRuntimeMXBean().getName();
                System.out.println(name);
                // get pid
                String pid = name.split("@")[0];
                System.out.println("Pid is:" + pid);
                Thread.currentThread().suspend();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.resume();
        t2.resume();
        t1.join();
        t2.join();

    }
}
