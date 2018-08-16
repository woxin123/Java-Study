package top.mcwebsite.moreThread.suspend_resume_test;

/**
 *
 * @author mengchen
 * @time 18-8-16 上午10:28
 */
public class MyThread extends Thread {

    private int i = 0;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }
}
