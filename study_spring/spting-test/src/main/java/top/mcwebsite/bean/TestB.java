package top.mcwebsite.bean;

/**
 * @author mengchen
 * @time 19-1-30 下午1:59
 */
public class TestB {

    private TestC testC;

    public TestB() {
    }

    public TestB(TestC testC) {
        this.testC = testC;
    }

    public void b() {
        testC.c();
    }

    public void setTestC(TestC testC) {
        this.testC = testC;
    }

    public TestC getTestC() {
        return testC;
    }
}
