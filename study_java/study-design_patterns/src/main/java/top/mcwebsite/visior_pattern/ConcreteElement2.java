package top.mcwebsite.visior_pattern;

/**
 * @author mengchen
 * @time 19-2-19 下午10:23
 */
public class ConcreteElement1 extends Element{


    @Override
    public void doSomething() {
        // 具体的业务逻辑
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
