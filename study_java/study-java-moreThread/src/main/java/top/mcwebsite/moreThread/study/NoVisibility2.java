package top.mcwebsite.moreThread.study;

import java.util.concurrent.TimeUnit;

/**
 * @author mengchen
 * @time 18-7-31 上午8:37
 */
class VisibilityThread extends Thread {
    private  boolean stop = false;

    @Override
    public void run() {
        int i = 0;
        System.out.println("start loop.");
        while(!getStop()) {
            i++;
        }
        System.out.println("finish loop,i=" + i);
    }

    public void stopIt() {
        stop = true;
    }

    public boolean getStop(){
        return stop;
    }
}

public class NoVisibility2 {
    public static void main(String[] args) throws Exception {
        VisibilityThread v = new VisibilityThread();
        v.start();
        //停顿1秒等待新启线程执行
        Thread.sleep(1000);
        System.out.println("即将置stop值为true");
        v.stopIt();
        Thread.sleep(1000);
        System.out.println("finish main");
        System.out.println("main中通过getStop获取的stop值:" + v.getStop());
    }
}
