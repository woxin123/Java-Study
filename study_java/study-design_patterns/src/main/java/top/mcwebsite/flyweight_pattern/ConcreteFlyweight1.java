package top.mcwebsite.flyweight_pattern;

/**
 * @author mengchen
 * @time 19-2-22 下午8:20
 */
public class ConcreteFlyweight1 extends Flyweight {

    public ConcreteFlyweight1(String extrinsic) {
        super(extrinsic);
    }

    // 根据外部状态进行逻辑处理
    @Override
    public void operate() {
        // 业务逻辑
    }
}
