package top.mcwebsite.moreThread.t7;

/**
 * @author mengchen
 * @time 18-8-13 下午4:49
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("run=" + this.isAlive());
    }
}
