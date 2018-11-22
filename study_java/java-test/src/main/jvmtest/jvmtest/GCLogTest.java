package jvmtest;

/**
 * @author mengchen
 * @time 18-11-2 上午10:54
 */
public class GCLogTest {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        Object o = new Object();
        o = null;
        System.gc();
    }
}
