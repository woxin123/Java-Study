package top.mcwebsite.lambda;

@FunctionalInterface
interface Math {
    int add(int x, int y);
}

@FunctionalInterface
interface Math2 {
    int add(int x, int y);
}

public class TypeDemoTest {
    public static void main(String[] args) {
        // 变量类型定义
        Math lambda = (x, y) -> x + y;
        // 数组
        Math[] lambda1 = {(x, y) -> x + y};

        // 强转
        Object lambda2 = (Math) (x, y) -> x + y;
        // 通过返回类型

        Math createLambda = createLambda();

        TypeDemoTest demoTest = new TypeDemoTest();
        // 当有二义性的时候，使用墙砖对应的接口解决
        demoTest.test((Math) (x , y) -> x + y);
    }

    public void test(Math math) {
    }

    public void test(Math2 math2) {

    }

    public static Math createLambda() {
        return (x, y) -> x + y;
    }
}
