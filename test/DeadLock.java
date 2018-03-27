
public class DeadLock extends Thread{
    public static final Object LOCK1 = new Object();
    public static final Object LOCK2 = new Object();
    int flag;
    public static void main(String[] args) {
        DeadLock d1 = new DeadLock(1);
        DeadLock d2 = new DeadLock(2);
        d1.start();
        d2.start();
    }

    public DeadLock(int flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag == 1) {
            synchronized(LOCK1) {
                System.out.println("LOCK1 is locked");
                try {
                Thread.sleep(2000);
                } catch(Exception e) {
                    e.printStackTrace();
                }
                synchronized(LOCK2) {
                    System.out.println("LOCK2 is locked");
                }
            }
        }
        if (flag == 2) {
            synchronized(LOCK2) {
                System.out.println("LOCK2 is locked");
                try {
                    Thread.sleep(2000);
                } catch(Exception e) {
                    e.printStackTrace();
                }
                synchronized(LOCK1) {
                    System.out.println("LOCK1 is locked");
                }
            }
        }
    }
}