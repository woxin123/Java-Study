package top.mcwebsite.concurrency.example.singleton;

import top.mcwebsite.concurrency.annotations.Recommend;
import top.mcwebsite.concurrency.annotations.ThreadSafe;

/**
 * 枚举模式
 * @author mengchen
 * @time 19-3-29 下午3:52
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    // 私有的构造函数
    private SingletonExample7() {

    }

    private static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getSingleton();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7 singleton;

        // JVM保证这个方法绝对调用一次
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getSingleton() {
            return singleton;
        }
    }

}
