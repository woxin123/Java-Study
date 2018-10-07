package top.mcwebsite.spring.cache.cachegroup;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.mcwebsite.spring.cache.domain.User;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mengchen
 * @time 18-10-7 下午3:15
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-cache.xml");
        UserService userService = (UserService) context.getBean("cacheGroupUserService");

        Member member = new Member("1", "w1");
        Visitor visitor = new Visitor("2", "w2");

        User userFetch1 = userService.getUser(member);
        System.out.println(userFetch1);

        User userFetch2 = userService.getUser(visitor);
        System.out.println(userFetch2);

        CacheManager cacheManager = context.getBean(CacheManager.class);
        Cache visitors = cacheManager.getCache("visitors");
        System.out.println("visitors cache storage:" + ((ConcurrentHashMap) visitors.getNativeCache()).values());

        Cache members = cacheManager.getCache("members");
        System.out.println("visitors cache storage:" + ((ConcurrentHashMap) members.getNativeCache()).values());

    }

}
