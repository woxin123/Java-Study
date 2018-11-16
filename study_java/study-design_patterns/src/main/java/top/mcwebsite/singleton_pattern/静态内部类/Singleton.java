package top.mcwebsite.singleton_pattern.静态内部类;

/**
 * @author mengchen
 * @time 18-11-16 下午7:38
 */
public class Singleton {
    private Singleton() {

    }
    public static Singleton getInstance() {
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder {
        private static final Singleton sInstance = new Singleton();
    }
}
