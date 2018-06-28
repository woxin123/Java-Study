package top.mcwebsite.lambda;

import java.util.function.Function;

/**
 * 级联表达式和柯里化
 * 柯里化：把多个参数的函数转化成只有一个参数的函数
 * 柯里化的目标：函数标准化
 * 高阶函数：返回函数的函数
 * @auther 孟晨
 * @date 2018/6/28 10:21
 */

public class CurryDemoTest {
    public static void main(String[] args) {
        // 实现了 x + y 的级联表达式
        Function<Integer, Function<Integer, Integer>> fun = x -> y -> x + y;
        Function<Integer, Function<Integer, Integer>> function = x -> y -> x + y;
        System.out.println(fun.apply(2).apply(3));

        Function<Integer, Function<Integer, Function<Integer, Integer>>> fun2 = x -> y -> z -> x + y + z;
        System.out.println(fun2.apply(4).apply(1).apply(2));

        int[] nums = {1, 2, 3};
        Function f = fun2;
        for (int i = 0; i < nums.length; i++) {
            if (f instanceof Function) {
                Object obj = f.apply(nums[i]);
                if (obj instanceof Function) {
                    f = (Function) obj;
                } else {
                    System.out.println("调用结束：结果为：" + obj);
                }
            }
        }
    }
}
