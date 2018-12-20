package top.mcwebsite.spi;

/**
 * @author mengchen
 * @time 18-12-20 下午4:28
 */
public class TextHello implements HelloInterface{

    @Override
    public void sayHello() {
        System.out.println("TextHello");
    }
}
