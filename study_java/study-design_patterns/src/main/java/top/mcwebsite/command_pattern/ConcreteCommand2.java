package top.mcwebsite.command_pattern;

/**
 * @author mengchen
 * @time 18-10-27 下午2:29
 */
public class ConcreteCommand2 extends Command {
    /**
     * 对哪一个接收者的命令进行处理
     */
    private Recevier recevier;

    public ConcreteCommand2(Recevier recevier) {
        this.recevier = recevier;
    }

    @Override
    public void execute() {
        this.recevier.doSomething();
    }
}
