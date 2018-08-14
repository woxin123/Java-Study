package top.mcwebsite.moreThread.stopThrowLock;

/**
 * @author mengchen
 * @time 18-8-14 下午2:40
 */
public class Run {
    public static void main(String[] args) {
        try {
            SynchronizedObject object = new SynchronizedObject();
            MyThread myThread = new MyThread(object);
            myThread.start();
            Thread.sleep(500);
            myThread.stop();
            System.out.println(object.getUsername() + " "
                    + object.getPassword());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
