package top.mcwebsite.factory_pattern;

/**
 * @author mengchen
 * @time 18-9-3 下午5:46
 */
public abstract class AbstractHumanFactory {
    public abstract <T extends Human> T createHuman(Class<T> c);
}
