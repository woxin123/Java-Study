package top.mcwebsite.prototype_pattern;

/**
 * @author mengchen
 * @time 18-10-20 下午5:04
 */
public class PrototypeCLass implements Cloneable {

    @Override
    protected Object clone()  {
        PrototypeCLass prototypeCLass = null;
        try {
            prototypeCLass = (PrototypeCLass) super.clone();
        } catch (CloneNotSupportedException e) {
            // 异常处理
        }

        return prototypeCLass;
    }
}
