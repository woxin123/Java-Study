package top.mcwebsite.singleton_pattern.容器实现单例单例模式;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mengchen
 * @time 18-11-16 下午8:14
 */
public class SingletonManager {



    private static Map<String, Object> objMap = new HashMap<>();
    private SingletonManager() {

    }

    public static void registerService(String key, Object instance) {
        if (!objMap.containsKey(key)) {
            objMap.put(key, instance);
        }
    }
    public static Object service(String key) {
        return objMap.get(key);
    }
}
