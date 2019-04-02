package method_call;

/**
 * invokestatic：调用静态方法。
 *
 * invokespecial：调用实例构造器<init>方法、私有方法和父类方法。
 *
 * invokevirtual：调用所有的虚方法。
 *
 * invokeinterface：调用接口方法，会在运行期确定一个实现此接口的对象。
 *
 * invokedynamic：先在运行时动态解析出调用点限定符所引用的方法，然后再执行该方法，
 *              在此之前的4条调用指令，分派逻辑是固化在Java虚拟机内部的，而invokedynamic指令的分派逻辑是由用户所设定引导方法决定的。
 * 在这里可以被覆写的方法都可以称作虚方法，因此虚方法并不需要做特殊的声明，也可以理解为除了用static、final、private修饰之外的所有方法都是虚方法。
 * @author mengchen
 * @time 19-4-2 下午9:38
 */
public class MethodCallTest {

    public static void hello() {
        System.out.println("哈哈哈哈哈哈");
    }

    public static void main(String[] args) {
        // invokespecial #6  // Method method_call/Son."<init>":()V
        Son son = new Son();
        // invokevirtual #7  // Method method_call/Son.show:()V
        son.show();
        // invokestatic  #8  // Method hello:()V
        hello();

        People people = new Father();
        // invokeinterface #11,  1  // InterfaceMethod method_call/People.show:()V
        people.show();
    }

}

interface People {
    void show();
}

class Father implements People{
    private String descriptionFather;

    public Father() {
        descriptionFather = "I'm father";
    }

    @Override
    public void show() {
        System.out.println(descriptionFather);
    }


}

class Son extends Father{
    private String descriptionSon;

    public Son() {
        // invokespecial #1  // Method method_call/Father."<init>":()V
        super();
        descriptionSon = "I'm son";
    }

    @Override
    public void show() {
        showMe();
    }

    private void showMe() {
        // invokespecial #4   // Method showMe:()V
        System.out.println(descriptionSon);
    }
}