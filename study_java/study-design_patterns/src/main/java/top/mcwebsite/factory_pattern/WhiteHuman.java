package top.mcwebsite.factory_pattern;

/**
 * @author mengchen
 * @time 18-9-3 下午5:50
 */
public class WhiteHuman implements Human {

    public void getColor() {
        System.out.println("白色中的人皮肤是白色的！");
    }

    public void talk() {
        System.out.println("白色人种会说话，一般说的都是单字节");
    }
}
