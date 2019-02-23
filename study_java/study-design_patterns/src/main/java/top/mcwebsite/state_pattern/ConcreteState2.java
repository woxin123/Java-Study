package top.mcwebsite.state_pattern;

/**
 * @author mengchen
 * @time 19-2-20 下午8:51
 */
public class ConcreteState2 extends State {
    @Override
    public void handle1() {
        // 设置当前状态为state1 处理handle1的时候趋向STATE1，然后执行STATE1的handle1方法
        super.context.setCurrentState(Context.STATE1);
        super.context.handle1();
    }

    @Override
    public void handle2() {
        // 本状态下必须处理的逻辑
        System.out.println("处理ConcreteState2 handle2");
    }
}
