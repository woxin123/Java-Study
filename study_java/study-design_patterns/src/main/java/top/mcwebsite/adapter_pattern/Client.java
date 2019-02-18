package top.mcwebsite.adapter_pattern;

/**
 * @author mengchen
 * @time 19-1-24 下午4:50
 */
public class Client {

    public static void main(String[] args) {
        // 原有的业务逻辑
        Target target = new ConcreteTarget();
        target.request();
        // 现在增加了适配器角色的业务逻辑
        Target target2 = new Adapter();
        target2.request();
    }

}
