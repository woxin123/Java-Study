package top.mcwebsite.state_pattern;

/**
 * @author mengchen
 * @time 19-2-20 下午8:49
 */
public class Context {
    // 定义状态
    public static final State STATE1 = new ConcreteState1();
    public static final State STATE2 = new ConcreteState2();

    // 当前状态
    private State currentState;

    // 获得当前状态
    public State getCurrentState() {
        return currentState;
    }

    // 设置当前状态
    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        // 切换状态
        this.currentState.setContext(this);
    }

    // 行为委托
    public void handle1() {
        this.currentState.handle1();
    }

    public void handle2() {
        this.currentState.handle2();
    }
}
