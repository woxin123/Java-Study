package top.mcwebsite.visior_pattern;

/**
 * @author mengchen
 * @time 19-2-19 下午10:23
 */
public interface Visitor {

    // 可以访问哪些元素
    void visit(ConcreteElement1 el1);
    void visit(ConcreteElement2 el2);
}
