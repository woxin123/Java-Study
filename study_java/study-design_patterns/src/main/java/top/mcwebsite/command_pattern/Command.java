package top.mcwebsite.command_pattern;

/**
 * @author mengchen
 * @time 18-10-27 下午2:20
 */
public abstract class Command {
    /**
     * 每一个接收者都必须处理一定的业务逻辑
     */
    public abstract void execute();
}
