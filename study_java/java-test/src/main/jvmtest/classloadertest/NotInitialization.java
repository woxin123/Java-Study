package classloadertest;

/**
 * 非主动使用类字段演示
 * @author mengchen
 * @time 18-11-20 下午10:33
 */
public class NotInitialization {
    public static void main(String[] args) {
        // first
        // System.out.println(SubClass.value);
        // second using array
        // SuperClass[] sca = new SuperClass[10];
        System.out.println(ConstClass.HELLOWORLD);
    }
}
