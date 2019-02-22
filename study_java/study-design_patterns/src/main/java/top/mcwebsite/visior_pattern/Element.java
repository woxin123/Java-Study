package top.mcwebsite.visior_pattern;

/**
 * @author mengchen
 * @time 19-2-19 下午10:22
 */
public class Element {
    private static Element ourInstance = new Element();

    public static Element getInstance() {
        return ourInstance;
    }

    private Element() {
    }
}
