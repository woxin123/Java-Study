package top.mcwebsite.concurrency.example.singleton;

import top.mcwebsite.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式 (如果构造函数有很多运算，可能会导致类加载很慢)
 * 单例实例在第一次使用的时候创建
 *
 * @author mengchen
 * @time 19-3-29 下午3:31
 */
@ThreadSafe
public class SingletonExample6 {

    // 私有的构造函数
    private SingletonExample6() {

    }

// 注意静态代码的执行顺序
//    static {
//        instance = new SingletonExample6();
//    }
//
//    private static SingletonExample6 instance = null;


    static {
        instance = new SingletonExample6();
    }

    private static SingletonExample6 instance = null;

    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }

}
