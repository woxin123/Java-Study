package top.mcwebsite.composite_pattern.transparency_composite_pattern;


import java.util.ArrayList;

/**
 * @author mengchen
 * @time 19-2-11 下午8:59
 */
public class Composite extends Component {
    // 构建容器
    private ArrayList<Component> componentArrayList = new ArrayList<>();

    // 增加一个叶子构成的节点
    @Override
    public void add(Component component) {
        this.componentArrayList.add(component);
    }

    @Override
    public void remove(Component component) {
        this.componentArrayList.remove(component);
    }

    // 获得分支下面所有的叶子构件和树枝构建
    @Override
    public ArrayList<Component> getChildren() {
        return this.componentArrayList;
    }
}
