package top.mcwebsite.concurrency.example.singleton;

import top.mcwebsite.concurrency.annotations.NotThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用的时候创建
 * @author mengchen
 * @time 19-3-29 下午3:31
 */
@NotThreadSafe
public class SingletonExample1 {
    // 私有的构造函数
    private SingletonExample1() {

    }

    private static SingletonExample1 instance = null;

    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }

}
