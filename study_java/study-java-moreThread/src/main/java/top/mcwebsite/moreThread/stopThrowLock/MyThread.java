package top.mcwebsite.moreThread.stopThrowLock;

/**
 * @author mengchen
 * @time 18-8-14 下午2:38
 */
public class MyThread extends Thread {

    private SynchronizedObject object;


    public MyThread(SynchronizedObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.printString("b", "bb");
    }
}
