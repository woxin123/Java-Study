package top.mcwebsite.concurrency.example.threadlocal;

/**
 * @author mengchen
 * @time 19-3-30 下午10:55
 */
public class RequestHolder {
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static Long getId() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }
}
