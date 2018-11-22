package top.mcwebsite.singletonpointloginin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SingletonPointLoginInApplicationTests {

    @Test
    public void contextLoads() {
    }

}

class Test01 {
    public static void main(String[] args) {
        Object o = new Object();
        Class<?> aClass = o.getClass();
        Class<?> bClass = o.getClass();
        System.out.println(Object.class == Object.class);
    }
}