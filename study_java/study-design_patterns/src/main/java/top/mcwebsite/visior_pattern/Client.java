package top.mcwebsite.visior_pattern;

/**
 * @author mengchen
 * @time 19-2-19 下午10:28
 */
public class Client {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            // 获得元素对象
            Element el = ObjectStruture.createElement();
            // 接受访问者访问
            el.accept(new ConcreteVisitor());
        }
    }
}
