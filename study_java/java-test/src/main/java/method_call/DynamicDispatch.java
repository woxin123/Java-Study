package method_call;

/**
 * @author mengchen
 * @time 19-4-3 下午4:33
 */
public class DynamicDispatch {
    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {
        @Override
        protected void sayHello() {
            System.out.println("man say hello");
        }
    }


    static class Woman extends Human {
        @Override
        protected void sayHello() {
            System.out.println("woman say hello");
        }
    }


    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        // invokevirtual #6   // Method method_call/DynamicDispatch$Human.sayHello:()V
        man.sayHello();
        // invokevirtual #6   // Method method_call/DynamicDispatch$Human.sayHello:()V
        woman.sayHello();
        man = new Woman();
        // invokevirtual #6   // Method method_call/DynamicDispatch$Human.sayHello:()V
        man.sayHello();
    }
}
