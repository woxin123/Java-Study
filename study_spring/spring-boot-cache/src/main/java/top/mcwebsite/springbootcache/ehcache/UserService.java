package top.mcwebsite.springbootcache.ehcache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.mcwebsite.springbootcache.domain.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mengchen
 * @time 18-10-7 下午7:19
 */
@Service("ehCacheUserService")
public class UserService {

    private Map<Integer, User> users = new HashMap<>();

    {
        users.put(1, new User("1", "cxh"));
        users.put(2, new User("2", "lkx"));
        users.put(3, new User("3", "wjg"));
    }

    @Cacheable("myCache")
    public User getUser(User user) {
        System.out.println("querying from db...");
        return users.get(Integer.valueOf(user.getUserId()));
    }

}
