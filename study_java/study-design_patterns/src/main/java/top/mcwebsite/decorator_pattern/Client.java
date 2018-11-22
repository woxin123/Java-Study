package top.mcwebsite.decorator_pattern;

/**
 * @author mengchen
 * @time 18-11-20 下午1:28
 */
public class Client {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        // 第一次修饰
        component = new ConcreteDecorator1(component);

        // 第二次修饰
        component = new ConcreteDecorator1(component);

        component.operate();
    }
}

