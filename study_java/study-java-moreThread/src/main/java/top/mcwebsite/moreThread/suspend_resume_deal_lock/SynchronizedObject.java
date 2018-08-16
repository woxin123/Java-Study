package top.mcwebsite.moreThread.suspend_resume_deal_lock;

/**
 * @author mengchen
 * @time 18-8-16 上午10:55
 */
public class SynchronizedObject {

    synchronized public void printString() {
        System.out.println("begin");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("a线程永远suspend了！");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }

}
