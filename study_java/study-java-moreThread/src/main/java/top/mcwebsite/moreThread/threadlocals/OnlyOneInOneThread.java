package top.mcwebsite.moreThread.threadlocals;

/**
 * @author mengchen
 * @time 18-8-11 上午10:39
 */
public class OnlyOneInOneThread {

    private static ThreadLocal<OnlyOneInOneThread> oneInOneThreadThreadLocal;

    private OnlyOneInOneThread() {
    }

    public static void onlyOneInOneThread() throws Exception {
        if (oneInOneThreadThreadLocal.get() != null) {
            throw new Exception("This thread has One!");
        }
        oneInOneThreadThreadLocal.set(new OnlyOneInOneThread());
    }

    public static OnlyOneInOneThread getOnlyOneInOneThread() {
        return oneInOneThreadThreadLocal.get();
    }
}
