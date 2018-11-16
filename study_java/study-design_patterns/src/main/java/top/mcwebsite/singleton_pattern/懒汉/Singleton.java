package top.mcwebsite.singleton_pattern.懒汉;

/**
 * @author mengchen
 * @time 18-11-16 下午4:50
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
