/**
 * @author mengchen
 * @time 18-10-25 下午4:08
 */
public class BarrierTest {
    volatile static int i = 0;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            i++;
            i++;
            i++;

        });
        thread.start();
        System.out.println(i);
    }
}
