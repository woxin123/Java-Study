package top.mcwebsite.command_pattern;

/**
 * @author mengchen
 * @time 18-10-27 下午2:25
 */
public class ConcreteCommand1 extends Command {
    /**
     * 对哪一个接收者的命令进行处理
     */
    private Recevier recevier;

    public ConcreteCommand1(Recevier recevier) {
        this.recevier = recevier;
    }

    @Override
    public void execute() {
        this.recevier.doSomething();
    }
}
