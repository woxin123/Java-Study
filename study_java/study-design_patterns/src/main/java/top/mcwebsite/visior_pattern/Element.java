package top.mcwebsite.visior_pattern;

/**
 * @author mengchen
 * @time 19-2-19 下午10:22
 */
public abstract class Element {
    // 定义一些业务对象
    public abstract void doSomething();

    // 允许谁来访问
    public abstract void accept(Visitor visitor);
}
