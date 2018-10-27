package top.mcwebsite.mediator_pattern;

/**
 * @author mengchen
 * @time 18-10-23 下午9:15
 */
public class ConcreteMediator extends Mediator {

    @Override
    public void doSomething1() {
        // 调用同事类的方法
        super.c1.selfMethod1();
        super.c2.selfMethod2();
    }

    @Override
    public void doSomething2() {
        super.c1.selfMethod1();
        super.c2.selfMethod2();
    }
}
