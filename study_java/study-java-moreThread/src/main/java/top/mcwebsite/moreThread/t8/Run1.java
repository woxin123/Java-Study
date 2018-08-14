package top.mcwebsite.moreThread.t8;

/**
 * @author mengchen
 * @time 18-8-13 下午7:09
 */
public class Run1 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println("begin =" + System.currentTimeMillis());
        myThread.run();
        System.out.println("end =" + System.currentTimeMillis());
    }
}
