package top.mcwebsite.concurrency.example.singleton;

import top.mcwebsite.concurrency.annotations.NotThreadSafe;
import top.mcwebsite.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式 (如果构造函数有很多运算，可能会导致类加载很慢)
 * 单例实例在第一次使用的时候创建
 * @author mengchen
 * @time 19-3-29 下午3:31
 */
@ThreadSafe
public class SingletonExample2 {

    // 私有的构造函数
    private SingletonExample2() {

    }

    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance() {
        return instance;
    }

}
