package top.mcwebsite.observer_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengchen
 * @time 19-2-13 下午6:25
 */
public abstract class Subject {
    // 定义一个观察者
    private List<Observer> observerList = new ArrayList<>();

    // 添加观察者
    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }

    // 删除一个观察者
    public void delObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    // 通知所有观察者
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}
