package top.mcwebsite.moreThread.study;

import java.util.concurrent.TimeUnit;

/**
 * 一个没有被完全创建而发布的例子
 * @author mengchen
 * @time 18-8-6 下午2:42
 */
public class NoCompleteCreate {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.initialize();
        new Thread(() -> {
            String dogSay = dog.getSayStr();
            System.out.println(dog.getSayStr());
        }).start();

        System.out.println(dog.getSayStr());

    }
}

class Dog {

    private String sayStr;

    public String getSayStr() {
        return sayStr;
    }

    public void initialize() {
        // 执行一个耗时操作
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sayStr = "I'm a dog";
    }
}