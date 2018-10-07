package top.mcwebsite.spring.cache.mycache;

import top.mcwebsite.spring.cache.domain.User;

/**
 * @author mengchen
 * @time 18-10-7 下午2:14
 */
public class UserService {

    private CacheManager<User> cacheManager;

    public UserService() {
        cacheManager = new CacheManager<User>();
    }

    public User getUserById(String userId) {

        // 首先查询缓存
        User result = cacheManager.getValue(userId);
        if (result != null) {
            System.out.println("get from cache..." + userId);

            // 如果在缓存中，直接返回缓存结果
            return result;
        }

        // 否则从数据库中查询，然后更新结果到缓存
        result = getFromDB(userId);
        if (result != null) {
            cacheManager.addOrUpdateCache(userId, result);
        }

        return result;
    }

    public void reload() {
        cacheManager.evictCahce();
    }

    private User getFromDB(String userId) {
        System.out.println("real query db..." + userId);
        return new User(userId);
    }
}
