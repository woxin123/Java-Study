package top.mcwebsite.lambda;

public class ThreadDemoTest {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        }.start();

        // jdk8 lambda
        new Thread(() ->
                System.out.println("ok")
        ).start();
    }
}
