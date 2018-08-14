package top.mcwebsite.moreThread.runMethodUseStopMethod;

/**
 * 方法stop已经被废弃，如果让强制停止线程则可能使一些清理工作得不到完成。
 * 另外一种情况就是对锁对象进行了“解锁”，导致数据到不到同步的处理，出现数据不一致的情况
 * @author mengchen
 * @time 18-8-14 上午11:27
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            this.stop();
        } catch (ThreadDeath e) {
            e.printStackTrace();
        }
    }
}
