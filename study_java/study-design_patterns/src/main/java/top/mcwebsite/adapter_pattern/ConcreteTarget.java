package top.mcwebsite.adapter_pattern;

/**
 * @author mengchen
 * @time 19-1-24 下午4:45
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("if you need any help, please call me!");
    }
}
