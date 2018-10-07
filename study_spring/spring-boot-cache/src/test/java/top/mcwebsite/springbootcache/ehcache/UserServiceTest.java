package top.mcwebsite.springbootcache.ehcache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.mcwebsite.springbootcache.domain.User;

/**
 * @author mengchen
 * @time 18-10-7 下午7:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    @Qualifier("ehCacheUserService")
    private UserService userService;

    @Test
    public void testGetUser() {
        User user1 = new User("1", "w1");
        User userFetch1 = userService.getUser(user1);
        System.out.println(userFetch1);

        User userFetch2 = userService.getUser(user1);
        System.out.println(userFetch2);
    }
}
