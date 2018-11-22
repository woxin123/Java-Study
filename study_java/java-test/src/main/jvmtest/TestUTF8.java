import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * @author mengchen
 * @time 18-10-17 下午5:25
 */
public class TestUTF8 {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        System.out.println(Charset.defaultCharset());
//        String string = new String("å\u0095\u008Aå\u0095\u008Aå\u0095\u008A\n");
//        System.out.println(new String(string.getBytes("GBK")));
//        System.out.println(new String(string.getBytes("iso8859-1")));
        String str = new String("啊啊啊".getBytes(), Charset.forName("GBK"));
        System.out.println(str);
        System.out.println(new String("啊啊啊".getBytes("UTF-8")));
        if (str.equals(new String("啊啊啊".getBytes("UTF-8")))) {
            System.out.println("UTF-8");
        }
    }

}
