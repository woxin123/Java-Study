package top.mcwebsite.concurrency.threadlocal;

import java.lang.ref.WeakReference;

/**
 * @author mengchen
 * @time 18-11-15 下午12:27
 */
public class Car {
    private double price;
    private String colour;

    public Car(double price, String colour) {
        this.price = price;
        this.colour = colour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return colour + "car costs $" + price;
    }

}

class TestWeakReference {


    public static void main(String[] args) {
        B<String> b = new B("aaaa");
        while (b.returnValue() != null) {
            System.out.println("不为空");
        }
        System.out.println("空");

    }

}

class B<T> {

    C c;

    public B(T t) {
        this.c = new C(t);
    }

    class C extends WeakReference<T> {

        T t;

        public C(T referent) {
            super(referent);
            this.t = referent;
        }

        public T getT() {
            return this.t;
        }

    }

    public T returnValue() {
        return c.getT();
    }

}
