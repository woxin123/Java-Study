package top.mcwebsite.bean;

/**
 * @author mengchen
 * @time 19-1-30 下午1:59
 */
public class TestC {
    private TestA testA;

    public TestC() {

    }

    public TestC(TestA testA) {
        this.testA = testA;
    }

    public void c() {
        testA.a();
    }

    public TestA getTestA() {
        return testA;
    }

    public void setTestA(TestA testA) {
        this.testA = testA;
    }
}
