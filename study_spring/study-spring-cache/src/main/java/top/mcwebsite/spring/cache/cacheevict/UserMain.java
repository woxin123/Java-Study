package top.mcwebsite.spring.cache.cacheevict;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.mcwebsite.spring.cache.domain.User;

/**
 * @author mengchen
 * @time 18-10-7 下午4:05
 */
public class UserMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-cache.xml");
        UserService userService = (UserService) context.getBean("cacheEvictUserService");

        User userFetch1 = userService.getUser(1);
        System.out.println(userFetch1);

        User userFetch2 = userService.getUser(2);
        System.out.println(userFetch2);

        userService.removeUser(1);

        User userFetch3 = userService.getUser(1);
        System.out.println("Fetch user should be null: " + userFetch3);

    }

}
