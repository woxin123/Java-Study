package top.mcwebsite.visior_pattern;

/**
 * @author mengchen
 * @time 19-2-19 下午10:26
 */
public class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ConcreteElement1 el1) {
        el1.doSomething();
    }

    @Override
    public void visit(ConcreteElement2 el2) {
        el2.doSomething();
    }
}
