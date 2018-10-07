package top.mcwebsite.spring.cache.initcache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.mcwebsite.spring.cache.domain.User;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mengchen
 * @time 18-10-7 下午4:25
 */
@Service("initUserService")
public class UserService {

    private Map<Integer, User> users = new HashMap<>();

    {
        users.put(1, new User("1", "w1"));
        users.put(2, new User("2", "w2"));
    }

    private CacheManager cacheManager;

    @Autowired
    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @PostConstruct
    public void setup() {
        Cache usersCache = cacheManager.getCache("users");
        for (Integer key : users.keySet()) {
            usersCache.put(key, users.get(key));
        }
    }

    @Cacheable(value = "users")
    public User getUser(int id) {
        System.out.println("User with id " + id + "requested. ");
        return users.get(id);
    }

}
