package top.mcwebsite.concurrency.producerandconsumer;

/**
 * @author mengchen
 * @time 18-10-11 下午2:39
 */
public final class PCData {
    private final int intData;

    public PCData(int intData) {
        this.intData = intData;
    }

    public PCData(String id) {
        intData = Integer.valueOf(id);
    }

    public int getIntData() {
        return this.intData;
    }

    @Override
    public String toString() {
        return "data:" + intData;
    }
}
