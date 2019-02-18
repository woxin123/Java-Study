package top.mcwebsite.observer_pattern;

/**
 * @author mengchen
 * @time 19-2-13 下午6:29
 */
public class ConcreteSubject extends Subject {
    // 具体的业务方法
    public void doSomething() {
        // 业务逻辑
        super.notifyObserver();
    }
}
