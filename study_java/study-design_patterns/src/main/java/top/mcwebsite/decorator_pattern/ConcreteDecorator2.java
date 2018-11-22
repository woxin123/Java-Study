package top.mcwebsite.decorator_pattern;

/**
 * @author mengchen
 * @time 18-11-20 下午1:24
 */
public class ConcreteDecorator2 extends Decorator {
    // 定义被秀使者
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    /**
     * 定义自己的修饰方法
     */
    private void method2() {
        System.out.println("method1 修饰");
    }

    /**
     * 重写父类的修饰方法
     */
    @Override
    public void operate() {
        super.operate();
        this.method2();
    }
}
