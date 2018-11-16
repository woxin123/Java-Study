package jvmtest;

/**
 * @author mengchen
 * @time 18-11-3 下午8:41
 */
public class TestClass<T> {
    private int m;

    public int intc() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }

    public T method(T data) {
        System.out.println(data);
        return data;
    }
}
