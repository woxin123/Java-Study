package top.mcwebsite.lambda;

import java.util.function.*;

class Dog {
    private String name = "哮天犬";

    private int food = 10;


    public Dog() {

    }

    public Dog(String name) {
        this.name = name;
    }


    /**
     * 静态
     * @param dog
     */
    public static void bark(Dog dog) {
        System.out.println(dog + "叫了");
    }

    /**
     * 吃狗粮
     * JDK会把当前实例默认触传递到非静态方法，参数是第一个
     * @param num
     * @return 还剩多少斤
     */
    public int eat(int num) {
        System.out.println("吃了" + num + "斤狗粮");
        this.food -= num;
        return food;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class MethodRefrenceDemoTest {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat(1);
        // 方法引用
        Consumer<String> consumer = System.out::println;
        consumer.accept("接收数据");
        // 静态方法引用
        Consumer<Dog> consumer2 = Dog::bark;
        consumer2.accept(new Dog());

        // 非静态方法使用实例来引用
//        Function<Integer, Integer> function = dog::eat;
//        UnaryOperator<Integer> function = dog::eat;
        IntUnaryOperator function = dog::eat;
        System.out.println("还剩下：" + function.applyAsInt(2) + "斤");

        // 使用类名引用方法
        BiFunction<Dog, Integer, Integer> eatFunction = Dog::eat;
        System.out.println("还剩下" + eatFunction.apply(dog, 2) + "斤");

        // 构造函数的方法引用
        Supplier<Dog> supplier = Dog::new;
        System.out.println("创建了新对象 " + supplier.get());

        // 带参数的构造方法的引用
        Function<String, Dog> function2 = Dog::new;
        System.out.println("创建了新对象 " + function2.apply("旺旺"));
    }
}
