package top.mcwebsite.flyweight_pattern;

import java.util.HashMap;

/**
 * @author mengchen
 * @time 19-2-22 下午8:22
 */
public class FlyweightFactory {
    // 定义一个池容器
    private static HashMap<String, Flyweight> pool = new HashMap<>();

    // 享元工厂
    public static Flyweight getFlyweiht(String extrinsic) {
        // 需要返回的对象
        Flyweight flyweight = null;
        if (pool.containsKey(extrinsic)) {
            flyweight = pool.get(extrinsic);
        } else {
            // 根据外部状态创建享元对象
            flyweight = new ConcreteFlyweight1(extrinsic);
            // 放入池中
            pool.put(extrinsic, flyweight);
        }
        return flyweight;
    }
}
