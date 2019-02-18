package top.mcwebsite.bean;

/**
 * @author mengchen
 * @time 19-1-30 下午1:59
 */
public class CircleB {

    private CircleC circleC;


    public void b() {
        circleC.c();
    }

    public void setCircleC(CircleC circleC) {
        this.circleC = circleC;
    }

    public CircleC getCircleC() {
        return circleC;
    }
}
