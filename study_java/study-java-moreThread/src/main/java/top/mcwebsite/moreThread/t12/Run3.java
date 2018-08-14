package top.mcwebsite.moreThread.t12;

/**
 * isInterrupted()方法，声明如下：
 * public boolean isInterrupted()
 * 从声明中可以看出isInterrupted()不是静态方法。
 *
 * 下面的程序中会输出两个true
 * 从结果可以看出isInterrupted()并未清除状态标志，所以打印了两个true
 *
 * 总结：
 * 1）this.interrupted() 测试当前线程是否已经是中断状态，执行后具有将标志为清除为false的功能
 * 2) this.isInterrupted():测试线程Thread对象是否已经是中断状态，但不清除状态标志
 *
 * @author mengchen
 * @time 18-8-14 上午10:09
 */
public class Run3 {

    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(1000);
            myThread.interrupt();
            System.out.println("是否停止1？ =" + myThread.isInterrupted());
            System.out.println("是否停止2？ =" + myThread.isInterrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }

}
