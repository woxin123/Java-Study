package top.mcwebsite.state_pattern;

/**
 * @author mengchen
 * @time 19-2-20 下午8:50
 */
public abstract class State {
    // 定义一个环境角色
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    // 行为1
    public abstract void handle1();

    // 行为2
    public abstract void handle2();
}
