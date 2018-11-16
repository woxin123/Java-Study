package top.mcwebsite.singleton_pattern.双重检测;

/**
 * @author mengchen
 * @time 18-11-16 下午5:51
 */
public class Singleton {

    private volatile static Singleton instance;
    private Singleton() {

    }
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    private Object readResolve() {
        return instance;
    }
}
