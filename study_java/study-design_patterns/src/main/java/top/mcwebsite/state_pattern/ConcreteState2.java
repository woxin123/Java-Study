package top.mcwebsite.state_pattern;

/**
 * @author mengchen
 * @time 19-2-20 下午8:51
 */
public class ConcreteState1 extends State {
    @Override
    public void hanle1() {
        // 本状态下必须处理的逻辑
    }

    @Override
    public void hanle2() {
        // 设置当前状态为state2
        super.context
    }
}
