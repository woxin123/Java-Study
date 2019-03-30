package top.mcwebsite.concurrency.example.singleton;

import top.mcwebsite.concurrency.annotations.NotRecommend;
import top.mcwebsite.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用的时候创建
 * @author mengchen
 * @time 19-3-29 下午3:31
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {
    // 私有的构造函数
    private SingletonExample3() {

    }

    private static SingletonExample3 instance = null;

    public synchronized static SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
