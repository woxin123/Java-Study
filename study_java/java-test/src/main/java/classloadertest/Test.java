package classloadertest;

/**
 * @author mengchen
 * @time 18-11-22 下午2:01
 */
public class Test {
    static {
        i = 0;
        // System.out.println(i); // 非法的向前引用
    }
    static int i = 1;
}
