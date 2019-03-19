package study.spring.aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mengchen
 * @time 19-3-19 上午8:17
 */
public class TestAware {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-core-aware.xml");
        User user = context.getBean(User.class);
        System.out.println(user);

        User2 user2 = context.getBean(User2.class);
        System.out.println(user2);
    }
}
