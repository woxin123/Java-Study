package top.mcwebsite.decorator_pattern;

/**
 * @author mengchen
 * @time 18-11-20 下午12:17
 */
public class Decorator extends Component {

    private Component component = null;

    public Decorator(Component component) {
        this.component = component;
    }

    /**
     * 委托给被修饰者执行
     */
    @Override
    public void operate() {
        this.component.operate();
    }
}
