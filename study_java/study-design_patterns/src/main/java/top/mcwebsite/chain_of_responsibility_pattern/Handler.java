package top.mcwebsite.chain_of_responsibility_pattern;


/**
 * @author mengchen
 * @time 18-11-2 下午8:43
 */
public abstract class Handler {

    private Handler nextHandler;

    public final Response handlerMessage(Request request) {
        Response response = null;
        // 判断自己的处理级别
        if (this.getHandlerLevel().equals(request.getRequestLevel())) {
            response = this.echo(request);
        } else {
            // 不属于自己的处理级别
            // 判断是否有下一个处理者
            if (this.nextHandler != null) {
                response = this.nextHandler.handlerMessage(request);
            } else {
                // 没有适当的处理者，业务自行处理
            }
        }
        return response;
    }

    /**
     * 设置下一个处理者是谁
     * @param handler
     */
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    /**
     * 每一个处理者都有一个处理级别
     * @return
     */
    public abstract Level getHandlerLevel();

    /**
     * 每一个处理者都必须实现处理任务
     * @param request
     * @return
     */
    public abstract Response echo(Request request);

}
