package top.mcwebsite.moreThread.t12;

/**
 * 下面的代码返回:
 * 是否停止1？ =true
 * 是否停止2？ =false
 * end!
 * interrupted
 * 测试当前线程是否已经中断。线程中断状态由该方法清除。换句话说，如果连续两次调用该方法，
 * 则第二次返回false(第一次调用已经清除了其中断状态，且第二次调用检测检测中断状态前，当线程再次中断的情况除外)。
 * interrupted()具有清除中断状态的作用。
 * @author mengchen
 * @time 18-8-14 上午10:01
 */
public class Run2 {

    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("是否停止1？ =" + Thread.interrupted());
        System.out.println("是否停止2？ =" + Thread.interrupted());
        System.out.println("end!");
    }
}
