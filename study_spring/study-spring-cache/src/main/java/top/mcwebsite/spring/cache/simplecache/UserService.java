package top.mcwebsite.spring.cache.simplecache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.mcwebsite.spring.cache.domain.User;

/**
 * @author mengchen
 * @time 18-10-7 下午2:29
 */
@Service
public class UserService {
    /**
     * 使用一个名为users的缓存
     */
    @Cacheable(cacheNames = "users")
    public User getUserById(String userId) {
        // 方法内部实现不考虑缓存逻辑，直接实现业务
        System.out.println("real query user..." + userId);
        return getFromDB(userId);
    }

    private User getFromDB(String userId) {
        System.out.println("real querying db..." + userId);
        return new User(userId);
    }
}
