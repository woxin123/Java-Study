package top.mcwebsite.memento_pattern.clone_memento_pattern.simplify;

/**
 * @author mengchen
 * @time 19-2-18 下午9:11
 */
public class Originator implements Cloneable{
    private Originator originator;

    private String state = "";

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    // 创建一个备忘录
    private void createMemento() {
        this.originator = this.clone();
    }

    // 恢复一个备忘录
    private void restoreMemento() {
        this.setState(this.originator.getState());
    }

    // 克隆当前对象
    @Override
    protected Originator clone()  {
        try {
            return (Originator) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
