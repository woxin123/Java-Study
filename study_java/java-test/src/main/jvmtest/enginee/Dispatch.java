package enginee;

/**
 * @author mengchen
 * @time 18-11-28 下午9:31
 */
public class Dispatch {
    static class QQ {
    }
    static class _360 {
    }

    public static class Father {
        public void hardChoice(QQ arg) {
            System.out.println("father choice qq");
        }
        public void hardChoice(_360 arg) {
            System.out.println("father choice 360");
        }
    }
    public static class Son extends Father {
        @Override
        public void hardChoice(QQ arg) {
            System.out.println("son choice qq");
        }
        @Override
        public void hardChoice(_360 arg) {
            System.out.println("son choice 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }

}
