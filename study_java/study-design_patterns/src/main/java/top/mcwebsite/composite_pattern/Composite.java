package top.mcwebsite.composite_pattern;

import java.util.ArrayList;

/**
 * @author mengchen
 * @time 19-2-11 下午8:59
 */
public class Composite extends Component {
    // 构建容器
    private ArrayList<Component> componentArrayList = new ArrayList<>();

    // 增加一个叶子构成的节点
    public void add(Component component) {
        this.componentArrayList.add(component);
    }

    // 获得分支下面所有的叶子构件和树枝构建
    public ArrayList<Component> getChildren() {
        return this.componentArrayList;
    }
}
