package top.mcwebsite.memento_pattern;

/**
 * @author mengchen
 * @time 19-2-17 下午11:27
 */
public class Originator {

    // 内部消息
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // 创建一个备忘录
    public Memento createMemento() {
        return new Memento(this.state);
    }

    // 恢复一个备忘录
    public void restoreMemento(Memento memento) {
        this.setState(memento.getState());
    }
}
