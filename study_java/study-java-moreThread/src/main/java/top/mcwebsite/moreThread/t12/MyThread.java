package top.mcwebsite.moreThread.t12;

/**
 * 判断线程是否终止
 * 在Java的SDK中，Thread提供了两种方法：
 * 1) this.interrupt() : 测试当前线程是否中断。
 * 2) this.isInterrupt() : 测试线程是否已经中断。
 *
 * @author mengchen
 * @time 18-8-14 上午9:24
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 500000; ++i) {
            System.out.println("i = " + (i + 1));
        }
    }
}
