package top.mcwebsite.command_pattern;

/**
 * @author mengchen
 * @time 18-10-27 下午2:33
 */
public class Invoker {
    private Command command;
    /**
     * 接收命令
     * @param command
     */
    public void setCommand(Command command) {
        this.command = command;
    }
    public void action() {
        this.command.execute();
    }
}
