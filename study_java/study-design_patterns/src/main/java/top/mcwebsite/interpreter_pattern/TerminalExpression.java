package top.mcwebsite.interpreter_pattern;

/**
 * @author mengchen
 * @time 19-2-21 下午8:46
 */
public class TerminalExpression extends Expression {

    // 通常终结符表达式只有一个，但是有多个实例
    @Override
    public Object interpreter(Context ctx) {
        return null;
    }
}
