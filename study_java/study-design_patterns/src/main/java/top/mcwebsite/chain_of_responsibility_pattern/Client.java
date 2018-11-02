package top.mcwebsite.chain_of_responsibility_pattern;

/**
 * @author mengchen
 * @time 18-11-2 下午9:16
 */
public class Client {
    public static void main(String[] args) {
        // 声明所有的处理节点
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler1();
        Handler handler3 = new ConcreteHandler1();

        // 设置链中处理阶段1-->2-->3
        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);
        // 提交请求，返回结果
        Response response = handler1.handlerMessage(new Request(new Level(2)));
    }
}
