package jvmtest;

/**
 * VM参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 * @author mengchen
 * @time 18-11-2 上午11:29
 */
public class BigObjectOldGen {

    private static final int _1MB = 1024 * 1024;

    public static void testPretenureSizeThreshould() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testPretenureSizeThreshould();
    }

}
