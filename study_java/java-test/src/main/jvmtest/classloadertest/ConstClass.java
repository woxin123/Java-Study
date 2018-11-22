package classloadertest;

/**
 * @author mengchen
 * @time 18-11-21 上午10:00
 */
public class ConstClass {

    static {
        System.out.println("Constant init!");
    }

    public static final String HELLOWORLD = "hello world!";

}
