package top.mcwebsite.bean;

/**
 * @author mengchen
 * @time 19-1-30 下午1:59
 */
public class CircleC {
    private CircleA circleA;


    public void c() {
        circleA.a();
    }

    public CircleA getCircleA() {
        return circleA;
    }

    public void setCircleA(CircleA circleA) {
        this.circleA = circleA;
    }
}
