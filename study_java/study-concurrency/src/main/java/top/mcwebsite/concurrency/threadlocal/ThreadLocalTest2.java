package top.mcwebsite.concurrency.threadlocal;

/**
 * @author mengchen
 * @time 18-11-6 上午11:32
 */
public class ThreadLocalTest2 {

    ThreadLocal<A> strLocal = new ThreadLocal<A>() {
        @Override
        protected void finalize() throws Throwable {
            System.out.println("我被回收了");
        }
    };

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest2 t2 = new ThreadLocalTest2();
        t2.strLocal.set(new A());
        System.out.println(t2.strLocal.get());
        System.gc();
        Thread.sleep(5000);
        System.out.println(t2.strLocal.get());
    }

}

class A {
    String str = "aaa";

    @Override
    protected void finalize() throws Throwable {
        System.out.println("回收");
    }
}
