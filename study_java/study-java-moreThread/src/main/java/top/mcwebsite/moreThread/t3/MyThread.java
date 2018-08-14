package top.mcwebsite.moreThread.t3;

/**
 * @author mengchen
 * @time 18-8-13 下午4:05
 */
public class MyThread extends Thread {
    private int count = 5;

    public MyThread(String name) {
        super();
        // 设置线程名称
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由 " + currentThread().getName()
                    + " 计算，count=" + count);
        }
    }
}
