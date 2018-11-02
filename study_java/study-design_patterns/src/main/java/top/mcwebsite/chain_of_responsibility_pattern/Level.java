package top.mcwebsite.chain_of_responsibility_pattern;

/**
 * @author mengchen
 * @time 18-11-2 下午9:05
 */
public class Level {
    private int level;

    public Level(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
