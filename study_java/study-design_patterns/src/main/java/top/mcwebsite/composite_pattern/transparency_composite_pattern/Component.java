package top.mcwebsite.composite_pattern.transparency_composite_pattern;

import java.util.ArrayList;

/**
 * @author mengchen
 * @time 19-2-12 下午5:06
 */
public abstract class Component {
    // 个体和整体都有的共享
    public void doSomething() {
        // 编写业务逻辑
    }

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract ArrayList<Component> getChildren();
}
