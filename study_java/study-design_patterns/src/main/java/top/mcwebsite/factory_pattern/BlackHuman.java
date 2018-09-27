package top.mcwebsite.factory_pattern;

/**
 * @author mengchen
 * @time 18-9-3 下午5:50
 */
public class BlackHuman implements Human {

    public void getColor() {
        System.out.println("黑色中的人皮肤是黑色的！");
    }

    public void talk() {
        System.out.println("黑色人种会说话，一般人听不懂");
    }
}
