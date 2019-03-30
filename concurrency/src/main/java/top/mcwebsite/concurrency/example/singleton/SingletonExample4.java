package top.mcwebsite.concurrency.example.singleton;

import top.mcwebsite.concurrency.annotations.NotRecommend;
import top.mcwebsite.concurrency.annotations.NotThreadSafe;
import top.mcwebsite.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式 -》 双重同步锁单例创建   指令重排可能会出现错误
 * 单例实例在第一次使用的时候创建
 * @author mengchen
 * @time 19-3-29 下午3:31
 */
@NotThreadSafe
public class SingletonExample4 {
    // 私有的构造函数
    private SingletonExample4() {

    }

    // 1. memory = allocate()分配对象的内存空间
    // 2. ctorInstance()初始化对象
    // 3. instance = memory设置instance指向刚刚分配的内存

    // JVM和CPU优化，发生了指令重排

    // 1. memory = allocate()分配对象的内存空间
    // 3. instance = memory设置instance指向刚刚分配的内存
    // 2. ctorInstance()初始化对象

    private static SingletonExample4 instance = null;

    /**
     * 双重检测
     * @return
     */
    public static SingletonExample4 getInstance() {
        if (instance == null) {
            // 同步锁
            synchronized (SingletonExample4.class) {
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        // 这里可能使用的是工作内存的值
        return instance;
    }
}
