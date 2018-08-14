package top.mcwebsite.map.test;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author mengchen
 * @time 18-8-10 下午11:40
 */
public class MapTest01 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put(String.valueOf((char)(i + 'a')), String.valueOf((char)(i + '0')));
        }
        String s = map.getOrDefault("d", "2");
        System.out.println(s);
        map.forEach(((s1, s2) -> System.out.println(s1 + ":" + s2)));
        String str1 = map.putIfAbsent("a", "a1");
        System.out.println(str1);
        String a = map.computeIfAbsent("f", (key) -> key + 'a');
        System.out.println(a);
        map.forEach(((s1, s2) -> System.out.println(s1 + ":" + s2)));
//        map.compute()
    }
}

class A implements Serializable {

}

interface B {

}

