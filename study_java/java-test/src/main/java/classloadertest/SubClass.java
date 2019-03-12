package classloadertest;

/**
 * @author mengchen
 * @time 18-11-20 下午10:30
 */
public class SubClass extends SuperClass {

    static {
        System.out.println("Subclass init!");
    }

}
