package top.mcwebsite.chain_of_responsibility_pattern;

/**
 * @author mengchen
 * @time 18-11-2 下午9:05
 */
public class Request {
    private Level level;

    public Request(Level level) {
        this.level = level;
    }

    public Level getRequestLevel() {
        return level;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
