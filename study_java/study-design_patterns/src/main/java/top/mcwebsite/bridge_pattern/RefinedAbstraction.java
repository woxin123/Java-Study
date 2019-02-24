package top.mcwebsite.bridge_pattern;

/**
 * @author mengchen
 * @time 19-2-23 下午5:15
 */
public class RefinedAbstraction extends Abstraction {

    public RefinedAbstraction(Implementor impl) {
        super(impl);
    }

    // 修正父类的行为
    @Override
    public void request() {
        /**
         * 业务处理...
         */
        super.request();
        super.getImpl().doAnything();
    }
}
