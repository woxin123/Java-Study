package top.mcwebsite.moreThread.suspend_resume_deal_lock;

/**
 * @author mengchen
 * @time 18-8-16 上午10:56
 */
public class Run {

    public static void main(String[] args) {
        try {
            final SynchronizedObject object = new SynchronizedObject();
            Thread thread1 = new Thread(() -> object.printString());
            thread1.setName("a");
            thread1.start();
            Thread.sleep(1000);
            Thread thread2 = new Thread(() -> {
                System.out.println("thread2启动了，但进入不了printString()方法！只打印了一个begin");
                System.out.println("因为printString()方法被a线程锁定并且永远suspend暂停了!");
                object.printString();
            });
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
