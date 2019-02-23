package top.mcwebsite.visior_pattern;

/**
 * @author mengchen
 * @time 19-2-19 下午10:23
 */
public class ConcreteElement2 extends Element{


    @Override
    public void doSomething() {
        // 具体的业务逻辑
        System.out.println("ConcreteElement2");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
