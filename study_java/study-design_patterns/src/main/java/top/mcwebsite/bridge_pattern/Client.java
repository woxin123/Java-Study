package top.mcwebsite.bridge_pattern;

/**
 * @author mengchen
 * @time 19-2-23 下午5:16
 */
public class Client {
    public static void main(String[] args) {
        // 定义一个实现化角色
        Implementor impl = new ConcreteImplementor1();
        // 定义一个抽象化角色
        Abstraction abs = new RefinedAbstraction(impl);
        // 执行
        abs.request();
    }
}
