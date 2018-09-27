import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author mengchen
 * @time 18-9-13 下午7:10
 */
public class Test {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("a");
        strs.add("z");
        strs.add("ab");
        strs.add("ac");
        strs.add("zac");

        strs.sort((o1, o2) -> {
            if (o1.length() - o2.length() != 0) {
                return o1.length() - o2.length();
            } else {
                return o1.compareTo(o2);
            }
        });
        System.out.println(strs);
    }
}
