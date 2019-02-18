package top.mcwebsite.composite_pattern.transparency_composite_pattern;

import java.util.ArrayList;

/**
 * @author mengchen
 * @time 19-2-12 下午5:08
 */
public class Leaf extends Component {
    @Override
    @Deprecated
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public ArrayList<Component> getChildren() {
        throw new UnsupportedOperationException();
    }
}
