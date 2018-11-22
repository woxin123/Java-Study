package top.mcwebsite.decorator_pattern;

/**
 * @author mengchen
 * @time 18-11-20 下午12:16
 */
public class ConcreteComponent extends Component {
    /**
     * 具体实现
     */
    @Override
    public void operate() {
        System.out.println("doSomething");
    }
}
