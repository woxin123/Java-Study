package top.mcwebsite.client.interfaces;

/**
 * 创建代理类
 * @author mengchen
 * @time 18-9-19 下午8:24
 */
public interface ProxyCreator {

    /**
     * 创建代理类
     * @param type
     * @return
     */
    Object createProxy(Class<?> type);
}
