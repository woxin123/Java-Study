package top.mcwebsite.spring.cache.cacheevict;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.mcwebsite.spring.cache.domain.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mengchen
 * @time 18-10-7 下午3:54
 */
@Service("cacheEvictUserService")
public class UserService {

    private Map<Integer, User> users = new HashMap<>();

    {
        users.put(1, new User("1", "cxh"));
        users.put(2, new User("2", "lkx"));
        users.put(3, new User("3", "wjg"));
    }

    @Cacheable(value = "users")
    public User getUser(int id) {
        System.out.println("User with id " + id + " requested");
        return users.get(id);
    }

    @CacheEvict("users")
    public void removeUser(int id) {
        users.remove(id);
    }


}
