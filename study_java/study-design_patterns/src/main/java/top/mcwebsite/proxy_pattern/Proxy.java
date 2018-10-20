package top.mcwebsite.proxy_pattern;

/**
 * @author mengchen
 * @time 18-10-13 下午3:37
 */
public class Proxy implements Subject {

    /**
     * 要代理的类
     */
    private Subject subject;

    public Proxy() {
        this.subject = new Proxy();
    }

    /**
     * 通过构造函数传递代理类
     */
    public Proxy(Subject... subjects) {

    }

    /**
     * 实现接口中定义的方法
     */
    public void request() {
        before();
        this.subject.request();
        after();
    }

    /**
     * 预处理
     */
    private void before() {

    }

    /**
     * 后处理
     */
    private void after() {

    }
}
