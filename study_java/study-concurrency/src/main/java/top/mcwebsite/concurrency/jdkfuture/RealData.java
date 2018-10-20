package top.mcwebsite.concurrency.jdkfuture;

import java.util.concurrent.Callable;

/**
 * @author mengchen
 * @time 18-10-11 下午4:13
 */
public class RealData implements Callable<String> {

    private String para;

    public RealData(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            Thread.sleep(1000);
        }
        return sb.toString();
    }



}
