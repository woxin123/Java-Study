package top.mcwebsite.bean;

/**
 * @author mengchen
 * @time 19-1-30 下午1:59
 */
public class CircleA {
    private CircleB circleB;

    public void a() {
        circleB.b();
    }

    public CircleB getCircleB() {
        return circleB;
    }

    public void setCircleB(CircleB circleB) {
        this.circleB = circleB;
    }
}
