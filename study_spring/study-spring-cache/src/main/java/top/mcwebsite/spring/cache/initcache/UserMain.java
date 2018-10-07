package top.mcwebsite.spring.cache.initcache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.mcwebsite.spring.cache.domain.User;

/**
 * @author mengchen
 * @time 18-10-7 下午4:39
 */
public class UserMain {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        UserService userService = (UserService) context.getBean("initUserService");

        User userFetch1 = userService.getUser(1);
        System.out.println(userFetch1);

        User userFetch2 = userService.getUser(2);
        System.out.println(userFetch2);
    }

}
