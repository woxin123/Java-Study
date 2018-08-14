package top.mcwebsite.moreThread.t13_1;

/**
 * @author mengchen
 * @time 18-8-14 上午10:43
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 500000; i++) {
                if (MyThread.interrupted()) {
                    System.out.println("已经是停止状态！我要退出了！");
                    throw new InterruptedException();
                }
                System.out.println("i=" + i + 1);
            }
            System.out.println("我在for下面");
        } catch (InterruptedException e) {
            System.out.println("进MyThread.java类run方法的catch了！");
            e.printStackTrace();
        }
    }
}
