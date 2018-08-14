package top.mcwebsite.moreThread.t11;

/**
 * 停止一个线程可以使用Thread.stop()方法，但最好不要用它，虽然它可以停止一个
 * 正在运行的线程，但是这个方法是不安全的(unsafe)，而且是已经弃用作废的(deprecated)，
 * 在将来的Java版本中这个方法将不可用或不被支持。
 *
 * 大多数停止线程的操作使用Thread.interrupt()方法，尽管这个方法的名称是"停止，终止"的意思，
 * 但是这个方法并不会终止一个正在执行的线程，还需要加入一个判断才可以完成线程的停止。
 *
 * 在Java中有三种方法可以终止正在运行的线程
 * 1) 使用退出标志，使线程正常退出，也就是当run方法完成后线程终止。
 * 2）使用stop方法强制终止正在运行的线程，但是不推荐使用这种方法，因为stop和suspend及resume一样，都是过期作废的方法，
 * 使用它们可能产生不可预料的结果。
 * 3) 使用interrupt方法中断线程。
 * @author mengchen
 * @time 18-8-14 上午8:51
 */
public class MyThread extends Thread {

    /**
     * 一个停不了线程
     */

    @Override
    public void run() {
        for (int i = 0; i < 5000000; i++) {
            System.out.println("i=" + (i + 1));
        }
    }
}
