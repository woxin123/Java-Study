package top.mcwebsite.observer_pattern;

/**
 * @author mengchen
 * @time 19-2-13 下午6:31
 */
    public class ConcreteObserver implements Observer {
        @Override
        public void update() {
            System.out.println("接收到信息，并进行处理");
        }
    }
