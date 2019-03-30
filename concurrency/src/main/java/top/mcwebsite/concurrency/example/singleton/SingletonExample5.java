package top.mcwebsite.concurrency.example.singleton;

import top.mcwebsite.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式 -》 双重同步锁单例创建
 * 单例实例在第一次使用的时候创建
 * @author mengchen
 * @time 19-3-29 下午3:31
 */
@ThreadSafe
public class SingletonExample5 {
    // 私有的构造函数
    private SingletonExample5() {

    }

    // 1. memory = allocate()分配对象的内存空间
    // 2. ctorInstance()初始化对象
    // 3. instance = memory设置instance指向刚刚分配的内存

    // JVM和CPU优化，发生了指令重排

    // 1. memory = allocate()分配对象的内存空间
    // 3. instance = memory设置instance指向刚刚分配的内存
    // 2. ctorInstance()初始化对象

    // 单例对象 volatile + 双重检测机制 -> 禁止指令重排序
    private volatile static SingletonExample5 instance = null;

    /**
     * 双重检测
     * @return
     */
    public static SingletonExample5 getInstance() {
        if (instance == null) {
            // 同步锁
            synchronized (SingletonExample5.class) {
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        // 这里可能使用的是工作内存的值
        return instance;
    }
}
