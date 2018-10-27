package top.mcwebsite.mediator_pattern;

/**
 * @author mengchen
 * @time 18-10-23 下午8:59
 */
public class ConcreteColleague1 extends Colleague {
    // 通过构造函数传递中介者
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    // 自己的方法self-Method
    public void selfMethod1() {
        // 处理自己的逻辑
    }

    // 依赖方法dep-Method
    public void depMethod1() {
        // 自己无法处理的逻辑，委托给中介者
        super.mediator.doSomething2();
    }
}
