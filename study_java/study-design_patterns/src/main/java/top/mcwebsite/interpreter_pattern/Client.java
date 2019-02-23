package top.mcwebsite.interpreter_pattern;

import java.util.Stack;

/**
 * @author mengchen
 * @time 19-2-21 下午8:49
 */
public class Client {
    public static void main(String[] args) {
        Context ctx = new Context();
        // 通常定义一个语法容器，容纳具体的表达式，通常为ListArray、LinkedList、Stack等类型
        Stack<Expression> stack = new Stack<>();
        stack.push(new NonterminalExpression());
        for (;;) {
            // 进行语法判断，并产生递归调用
            break;
        }

        // 产生一个完整的语法时，对各个具体的语法分析进行解析
        Expression exp = stack.pop();
        // 具体元素进入场景
        exp.interpreter(ctx);
    }
}
