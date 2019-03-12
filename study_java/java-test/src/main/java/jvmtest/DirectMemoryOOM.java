package jvmtest;


import java.lang.reflect.Field;

/**
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * @author mengchen
 * @time 18-10-23 下午5:03
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

//    public static void main(String[] args) throws IllegalAccessException {
//        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
//        unsafeField.setAccessible(true);
//        Unsafe unsafe = (Unsafe) unsafeField.get(null);
//        short i = 1;
//        while (i != 0) {
//            i++;
//            unsafe.allocateMemory(_1MB);
//        }
//    }

}
