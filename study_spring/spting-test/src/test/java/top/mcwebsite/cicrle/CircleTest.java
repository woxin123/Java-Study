package top.mcwebsite.cicrle;

import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mengchen
 * @time 19-1-31 下午9:38
 */
public class CircleTest {

    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleByConstructor() throws Throwable {
        try {
            new ClassPathXmlApplicationContext("applicationCircleDep.xml");
        } catch (Exception e) {
            Throwable throwable = e.getCause().getCause().getCause();
            throw throwable;
        }
    }

    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleBySetter() throws Throwable {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationCircleDep.xml");
            context.getBean("testA");
        } catch (Exception e) {
            Throwable throwable = e.getCause().getCause().getCause();
            throw throwable;
        }
    }
}
