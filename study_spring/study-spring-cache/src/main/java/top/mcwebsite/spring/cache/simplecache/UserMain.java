package top.mcwebsite.spring.cache.simplecache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mengchen
 * @time 18-10-7 下午2:44
 */
public class UserMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-cache.xml");
        UserService userService = (UserService) context.getBean("accountServiceBean");

        System.out.println("first query...");
        userService.getUserById("somebody");

        System.out.println("second querying....");
        userService.getUserById("somebody");
    }
}
