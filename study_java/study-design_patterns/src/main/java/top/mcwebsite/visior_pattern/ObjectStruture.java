package top.mcwebsite.visior_pattern;

import java.util.Random;

/**
 * @author mengchen
 * @time 19-2-19 下午10:27
 */
public class ObjectStruture {

    public static Element createElement() {
        Random random = new Random();
        if (random.nextInt(100) > 50) {
            return new ConcreteElement1();
        } else {
            return new ConcreteElement2();
        }
    }
}
