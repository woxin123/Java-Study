package top.mcwebsite.chain_of_responsibility_pattern;

/**
 * @author mengchen
 * @time 18-11-2 下午9:09
 */
public class ConcreteHandler2 extends Handler {
    /**
     * 定义自己的处理级别
     *
     * @return
     */
    @Override
    public Level getHandlerLevel() {
        return null;
    }

    /**
     * 定义自己的处理逻辑
     *
     * @param request
     * @return
     */
    @Override
    public Response echo(Request request) {
        return null;
    }
}
