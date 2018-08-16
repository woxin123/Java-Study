package top.mcwebsite.moreThread.suspend_resume_LockStop;

/**
 * @author mengchen
 * @time 18-8-16 上午11:28
 */
public class MyThread extends Thread {

    private long i = 0;

    @Override
    public void run() {
        while (true) {
            i++;
            System.out.println(i);
        }
    }
}
