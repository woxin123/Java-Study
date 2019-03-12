package jvmtest;

/**
 * @author mengchen
 * @time 18-10-23 下午7:02
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, I'm still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize发方法的优先级很低，所以暂停0.5秒等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("No, I'm dead!");
        }

        // 下面的这段代码和上面的一样，但却拯救自己失败了
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize发方法的优先级很低，所以暂停0.5秒等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("No, I'm dead!");
        }
    }

}
