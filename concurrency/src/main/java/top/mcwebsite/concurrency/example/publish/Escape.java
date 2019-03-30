package top.mcwebsite.concurrency.example.publish;

import lombok.extern.slf4j.Slf4j;
import top.mcwebsite.concurrency.annotations.NotRecommend;
import top.mcwebsite.concurrency.annotations.NotThreadSafe;

/**
 * 发布对象：是一个对象能够被当前范围之外的代码所使用
 * @author mengchen
 * @time 19-3-29 下午3:19
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    /**
     * 类没有被构造成功就被发布了
     * 所以不要在构造器中开启线程
     */
    public Escape() {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
