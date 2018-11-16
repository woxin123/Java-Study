/**
 * @author mengchen
 * @time 18-11-13 下午8:46
 */
public class Test1 extends Thread {

    private static int i;

    int str;

    public Test1(int str) {
        this.str = str;
    }

    @Override
    public void run() {
        for(; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getId() + str + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = null;
        for (int i = 0;i < 100;i++){
//            System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getId());
            if (i == 20){
                new Test1(0).run();
                Test1.i = 0;
                thread = new Test1(2);
                thread.start();
                new Test1(2).start();
            }
        }
//        Thread.currentThread().join();
//        thread.join();
    }
}

