package top.mcwebsite.concurrency.example.publish;

import lombok.extern.slf4j.Slf4j;
import top.mcwebsite.concurrency.annotations.NotThreadSafe;

import java.util.Arrays;

/**
 * 对象逸出：一种错误的发布，当一个对象还没有被构造完成时，就使它被其他线程所见
 * @author mengchen
 * @time 19-3-29 下午3:15
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {

    private String[] states = {"a", "b", "c", "d"};

    /**
     * 不安全的发布
     * 因为states可能被任何线程修改
     * @return
     */
    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
        unsafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
    }

}
