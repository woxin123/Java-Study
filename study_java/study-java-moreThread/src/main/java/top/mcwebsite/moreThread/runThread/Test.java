package top.mcwebsite.moreThread.runThread;

/**
 * @author mengchen
 * @time 18-8-14 上午8:46
 */
public class Test {

    public static void main(String[] args) {
        Thread runThread = Thread.currentThread();
        // 取得线程名称和id
        System.out.println(runThread.getName() + " " + runThread.getId());
    }
}
