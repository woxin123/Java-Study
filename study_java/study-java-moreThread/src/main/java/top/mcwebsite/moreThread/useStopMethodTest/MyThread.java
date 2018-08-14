package top.mcwebsite.moreThread.useStopMethodTest;

/**
 * @author mengchen
 * @time 18-8-14 上午11:20
 */
public class MyThread extends Thread {

    private int i = 0;

    @Override
    public void run() {
       try {
           while (true) {
               i++;
               System.out.println("i=" + i);
               Thread.sleep(1000);
           }
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }
}
