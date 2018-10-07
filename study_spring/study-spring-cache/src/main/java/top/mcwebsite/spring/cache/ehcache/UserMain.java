package top.mcwebsite.spring.cache.ehcache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.mcwebsite.spring.cache.domain.User;

/**
 * @author mengchen
 * @time 18-10-7 下午3:41
 */
public class UserMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-ehcache.xml");
        UserService userService = (UserService) context.getBean("ehcacheUserService");

        User user1 = new User("2", "w2", 34);
        User userFetch1 = userService.getUser(user1);
        System.out.println(userFetch1);

        User userFetch2 = userService.getUser(user1);
        System.out.println(userFetch2);

        User user2 = new User("1", "w1", 37);
        User userFetch3 = userService.getUser(user2);
        System.out.println(userFetch3);

        User userFetch4 = userService.getUser(user2);
        System.out.println(userFetch4);

    }

}
