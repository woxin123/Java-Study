package top.mcwebsite.factory_pattern;

/**
 * @author mengchen
 * @time 18-9-3 下午5:56
 */
public class HumanFactory extends AbstractHumanFactory{

    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try {
            human = (T) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("人中生成错误！");
        }

        return (T) human;
    }
}
