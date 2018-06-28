package top.mcwebsite.moreThread.start;


/**
 * @auther 孟晨
 * @date 2018/6/28 19:46
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.start();
        myThread.start();
        System.out.println("运行结束");
    }
}
