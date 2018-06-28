package top.mcwebsite.lambda;

import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class FunctionDemoTest {
    public static void main(String[] args) {
        // 断言函数
        IntPredicate predicate = i -> i > 0;
        System.out.println(predicate.test(2));

        // 消费者函数
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("输入的数据");
    }
}
