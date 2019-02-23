package top.mcwebsite.interpreter_pattern;

/**
 * @author mengchen
 * @time 19-2-21 下午8:45
 */
public abstract class Expression {
    // 每一个表达式必须有一个解析任务
    public abstract Object interpreter(Context ctx);

}
