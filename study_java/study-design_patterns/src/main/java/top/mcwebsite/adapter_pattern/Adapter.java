package top.mcwebsite.adapter_pattern;

/**
 * @author mengchen
 * @time 19-1-24 下午4:49
 */
public class Adapter extends Adaptee implements Target{
    @Override
    public void request() {
        super.doSomething();
    }
}