package top.mcwebsite.moreThread.t13forprint;

/**
 * @author mengchen
 * @time 18-8-14 上午10:43
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            if (this.interrupted()) {
                System.out.println("已经是停止状态！我要退出了！");
                break;
            }
            System.out.println("i=" + i + 1);
        }
        System.out.println("我被输出了，如果此代码是for有继续执行，线程并未停止！");
    }
}
