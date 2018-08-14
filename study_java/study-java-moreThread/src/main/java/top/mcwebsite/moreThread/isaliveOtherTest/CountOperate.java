package top.mcwebsite.moreThread.isaliveOtherTest;

/**
 * 当线程以构造参数的方式传递给Thread对象进行start()启动线程，我们直接启动的线程实际是newThread，而作为构造参数的myThread，
 * 赋值给Thread类的属性target，之后在Thread的run方法调用target.run();
 * 此时的Thread.currentThread()是Thread中的引用newThread，而this依旧是MyThread的引用，打印的内容也不一样。
 * @author mengchen
 * @Override
 * public void run() {
 *     if (target != null) {
 *         target.run();
 *     }
 * }
 * @time 18-8-13 下午4:54
 */
public class CountOperate extends Thread {

    public CountOperate() {
        System.out.println("CountOperate----------begin");
        System.out.println("CountOperator--begin");
        System.out.println("Thread.currentThread().getName()="
                + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()="
                + Thread.currentThread().isAlive());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("this.isAlive()=" + this.isAlive());
        System.out.println("CountOperate----------end");
    }

    @Override
    public void run() {
        System.out.println("run----------begin");
        System.out.println("CountOperator--begin");
        System.out.println("Thread.currentThread().getName()="
                + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()="
                + Thread.currentThread().isAlive());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("this.isAlive()=" + this.isAlive());
        System.out.println("run----------end");
    }
}
