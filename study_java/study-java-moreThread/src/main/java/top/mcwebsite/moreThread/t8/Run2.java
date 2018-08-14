package top.mcwebsite.moreThread.t8;

/**
 * @author mengchen
 * @time 18-8-14 上午8:42
 */
public class Run2 {

    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        System.out.println("begin =" + System.currentTimeMillis());
        myThread2.start();
        System.out.println("end =" + System.currentTimeMillis());
    }

}
