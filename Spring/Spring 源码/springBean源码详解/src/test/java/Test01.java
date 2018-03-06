import org.springframework.util.StringUtils;

public class Test01 {
    public static void main(String[] args) {
        String str = "         ";
        boolean a = StringUtils.hasText(str);
        System.out.println(a);
    }
}
