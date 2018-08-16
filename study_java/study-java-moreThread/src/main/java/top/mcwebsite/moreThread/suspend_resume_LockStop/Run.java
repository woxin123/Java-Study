package top.mcwebsite.moreThread.suspend_resume_LockStop;

/**
 * @author mengchen
 * @time 18-8-16 上午11:29
 */
public class Run {

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.suspend();
            System.out.println("main end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
