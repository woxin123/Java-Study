package top.mcwebsite.moreThread.threadlocals;

/**
 * @author mengchen
 * @time 18-8-5 下午6:28
 */
public class ThreadLocalTest2 {
    public static void main(String[] args) {
        A.prepare();
        B b = new B();
        System.out.println(b.get().integer);
    }
}

class A {

    public int integer;

    private A() {
    }

    private static ThreadLocal<A> a = new ThreadLocal<>();

    public static void prepare() {
        if (a.get() != null) {
            throw new RuntimeException();
        }
        a.set(new A());
    }

    public static A getA() {
        return a.get();
    }

    public int getInteger() {
        return integer;
    }

    public static void setA(ThreadLocal<A> a) {
        A.a = a;
    }
}

class B {
    private A a;

    public A get() {
        return a;
    }

    public A getA() {
        return a;
    }

    public B () {
        a = A.getA();
    }
}

class Handler {

    private Looper looper;

    public Handler() {

    }

    private void hanlderMessage() {

    }
}

class Looper {

    private static ThreadLocal<Looper> looperLocals = new ThreadLocal<>();

    private Looper() {
    }


    public static void prepare() {
        if (looperLocals.get() != null) {
            throw new RuntimeException();
        }
        looperLocals.set(new Looper());
    }

    public static Looper myLooper() {
        return looperLocals.get();
    }

    public void loop() {
        //
    }

}

class MessageQueue {

}

class Message {
    public Object what;
}
