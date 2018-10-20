package top.mcwebsite.prototype_pattern;

/**
 * @author mengchen
 * @time 18-10-20 下午5:21
 */
public class Thing implements Cloneable {

    public Thing() {
        System.out.println("构造函数被执行");
    }

    @Override
    protected Thing clone() {
        Thing thing = null;
        try {
            thing = (Thing) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return thing;
    }
}

class Client {
    public static void main(String[] args) {
        Thing thing = new Thing();
        Thing cloneThing =  thing.clone();
    }
}
