package top.mcwebsite.state_pattern;

/**
 * @author mengchen
 * @time 19-2-20 下午8:51
 */
public class ConcreteState1 extends State {
    @Override
    public void handle1() {
        // 本状态下必须处理的逻辑
        System.out.println("处理ConcreteState1的handle1");
    }

    @Override
    public void handle2() {
        // 设置当前状态为state2
        super.context.setCurrentState(Context.STATE2);
        super.context.handle2();
    }
}
