package top.mcwebsite.moreThread.t4_threadsafe;

/**
 * @author mengchen
 * @time 18-8-13 下午4:28
 */
public class Run {
    public static void main(String[] args) {
        ALogin a = new ALogin();
        a.start();
        BLogin b = new BLogin();
        b.start();
    }
}
