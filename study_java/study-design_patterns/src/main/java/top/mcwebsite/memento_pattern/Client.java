package top.mcwebsite.memento_pattern;

/**
 * @author mengchen
 * @time 19-2-17 下午11:43
 */
public class Client {
    public static void main(String[] args) {
        // 定义一个发起人
        Originator originator = new Originator();
        // 定义出备忘录的管理者
        Caretaker caretaker = new Caretaker();
        // 创建一个备忘录
        caretaker.setMemento(originator.createMemento());
        // 恢复一个备忘录
        originator.restoreMemento(caretaker.getMemento());
    }
}
