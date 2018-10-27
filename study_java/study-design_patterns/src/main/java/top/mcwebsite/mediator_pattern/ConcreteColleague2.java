package top.mcwebsite.mediator_pattern;

/**
 * @author mengchen
 * @time 18-10-23 下午9:20
 */
public class ConcreteColleague2 extends Colleague {
    // 通过构造函数传递中介者
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    // 自己的方法self-method
    public void selfMethod2() {
        // 处理自己的逻辑
    }

    // 依赖的方法dep-Method
    public void depMethod() {
        // 自己处理不了的业务逻辑
        // 委托给中介者处理
        super.mediator.doSomething2();
    }
}
