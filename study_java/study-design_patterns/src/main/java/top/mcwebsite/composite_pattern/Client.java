package top.mcwebsite.composite_pattern;

/**
 * @author mengchen
 * @time 19-2-11 下午9:04
 */
public class Client {
    public static void main(String[] args) {
        // 创建一个根节点
        Composite root = new Composite();
        root.doSomething();
        // 创建一个树枝构建
        Composite branch = new Composite();
        // 创建一个叶子节点
        Leaf leaf = new Leaf();
        root.add(branch);

        branch.add(leaf);
    }

    // 通过递归遍历树
    public static void display(Composite composite) {
        for (Component component : composite.getChildren()) {
            if (component instanceof Leaf) {
                composite.doSomething();
            } else {
                display((Composite) component);
            }
        }
    }
}
