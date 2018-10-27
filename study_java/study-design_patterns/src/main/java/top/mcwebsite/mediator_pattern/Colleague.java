package top.mcwebsite.mediator_pattern;

/**
 * @author mengchen
 * @time 18-10-23 下午9:16
 */
public class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
