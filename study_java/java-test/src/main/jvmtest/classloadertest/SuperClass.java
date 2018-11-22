package classloadertest;

/**
 * 被动使用类的演示一：
 * 通过子类引用父类的静态字段，不会导致子类初始化
 * @author mengchen
 * @time 18-11-20 下午10:29
 */
public class SuperClass {

    static {
        System.out.println("SuperClass init");
    }

    public static int value = 123;
}
