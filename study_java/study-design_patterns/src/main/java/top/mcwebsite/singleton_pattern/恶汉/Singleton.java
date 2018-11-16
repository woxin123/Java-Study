package top.mcwebsite.singleton_pattern.恶汉;

/**
 * @author mengchen
 * @time 18-11-16 下午4:43
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}
