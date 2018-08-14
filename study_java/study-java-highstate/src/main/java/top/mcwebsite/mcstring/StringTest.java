package top.mcwebsite.mcstring;

/**
 * @author mengchen
 * @time 18-8-5 下午2:25
 */
public class StringTest {

    public static void main(String[] args) {
        String str1 = "hello ";
        String str2 = "world";
        String str3 = new String("hello world");
        System.out.println((str1 + str2) == str3);
        System.out.println((str1 + str2).equals(str3));
    }
}
