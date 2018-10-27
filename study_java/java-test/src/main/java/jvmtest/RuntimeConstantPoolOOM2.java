package jvmtest;

/**
 * @author mengchen
 * @time 18-10-23 下午4:56
 */
public class RuntimeConstantPoolOOM2 {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

}
