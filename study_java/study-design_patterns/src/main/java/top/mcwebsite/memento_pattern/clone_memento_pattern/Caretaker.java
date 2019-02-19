package top.mcwebsite.memento_pattern.clone_memento_pattern;

/**
 * @author mengchen
 * @time 19-2-18 下午9:02
 */
public class Caretaker {
    // 发起人对象
    private Originator originator;

    public Originator getOriginator() {
        return originator;
    }

    public void setOriginator(Originator originator) {
        this.originator = originator;
    }
}
