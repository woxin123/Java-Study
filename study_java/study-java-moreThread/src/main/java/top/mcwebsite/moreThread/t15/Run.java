package top.mcwebsite.moreThread.t15;


/**
 * @author mengchen
 * @time 18-8-14 上午10:47
 */
public class Run {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        thread.interrupt();
        System.out.println("end!");
    }

}
