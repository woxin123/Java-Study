package top.mcwebsite.moreThread.isaliveOtherTest;

/**
 * @author mengchen
 * @time 18-8-13 下午5:04
 */
public class Run {

    public static void main(String[] args) {
        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);
        System.out.println("main begin t1 isAlive=" + c.isAlive());
        c.setName("A");
        c.start();
        System.out.println("main end t1 isAlive=" + c.isAlive());
    }

}
