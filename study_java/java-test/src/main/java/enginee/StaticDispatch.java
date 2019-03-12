package enginee;

/**
 * @author mengchen
 * @time 18-11-28 下午8:30
 */
public class StaticDispatch {

    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello,gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello,lady");
    }

    public static void main(String[] args) {
        Human human = new Man();
        Human women = new Woman();
        StaticDispatch sd = new StaticDispatch();
        sd.sayHello(human);
        sd.sayHello(women);

        // 实际类型变化
        Human man = new Man();
        man = new Woman();

        // 静态类型发生变化
        sd.sayHello((Human) man);
        sd.sayHello((Woman) man);
    }
}
