package top.mcwebsite.moreThread.threadlocals;

/**
 * @author mengchen
 * @time 18-8-5 下午1:48
 */
public class ThreadLocalTest {
    ThreadLocal<String> strLocal = ThreadLocal.withInitial(() -> Thread.currentThread().getName());


    public void set() {
        strLocal.set(Thread.currentThread().getName());
    }

    public String get() {
        return strLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest test = new ThreadLocalTest();
        test.set();
        System.out.println(test.get());

        Thread thread = new Thread(() -> {
            test.set();
            System.out.println(test.get());
        });
        thread.start();
        thread.join();

        System.out.println(test.get());

    }
}
