package top.mcwebsite.observer_pattern;

/**
 * @author mengchen
 * @time 19-2-13 下午6:32
 */
public class Client {
    public static void main(String[] args) {
        // 创建一个被观察者
        ConcreteSubject subject = new ConcreteSubject();
        // 定义一个观察者
        Observer observer = new ConcreteObserver();
        // 观察者观察被观察者
        subject.addObserver(observer);
        // 被观察者开始或者
        subject.doSomething();
    }
}
