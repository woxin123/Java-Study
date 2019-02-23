package top.mcwebsite.state_pattern;

/**
 * @author mengchen
 * @time 19-2-20 下午9:01
 */
public class Client {

    public static void main(String[] args) {
        // 定义环境角色
        Context context = new Context();
        // 初始状态
        context.setCurrentState(Context.STATE1);
        // 行为执行
        context.handle1();
        context.handle2();
    }
}
