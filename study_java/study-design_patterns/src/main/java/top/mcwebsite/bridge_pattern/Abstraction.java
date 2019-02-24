package top.mcwebsite.bridge_pattern;

/**
 * @author mengchen
 * @time 19-2-23 下午5:13
 */
public abstract class Abstraction {
    // 定义对实现化角色的引用
    private Implementor impl;

    // 约束子类必须实现该构造函数
    public Abstraction(Implementor impl){
        this.impl = impl;
    }

    // 自身行为和属性
    public void request(){
        this.impl.doSomething();
    }

    // 获取实现化角色

    public Implementor getImpl() {
        return impl;
    }
}
