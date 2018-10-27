package top.mcwebsite.command_pattern;

/**
 * @author mengchen
 * @time 18-10-27 下午2:35
 */
public class Client {
    public static void main(String[] args) {
        // 首先声明调用者
        Invoker invoker = new Invoker();
        // 定义接收者
        Recevier recevier = new ConcreteReceiver1();
        // 定义一个发送给接收者的命令
        Command command = new ConcreteCommand1(recevier);
        // 把命令交接调用者去执行
        invoker.setCommand(command);
        invoker.action();
    }
}
