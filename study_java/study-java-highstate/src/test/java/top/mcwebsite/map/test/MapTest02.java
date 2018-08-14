package top.mcwebsite.map.test;

/**
 * @author mengchen
 * @time 18-8-13 上午11:18
 */
public class MapTest02 {

    public static void main(String[] args) {
        System.out.println(tableSizeFor(100));
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }
}
