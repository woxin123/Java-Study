package top.mcwebsite.memento_pattern;

/**
 * @author mengchen
 * @time 19-2-17 下午11:28
 */
public class Memento {
    // 发起人的内部状态
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
