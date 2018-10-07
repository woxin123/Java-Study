package top.mcwebsite.spring.cache.config;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import top.mcwebsite.spring.cache.domain.User;

/**
 * @author mengchen
 * @time 18-10-7 下午4:11
 */
@CacheConfig(cacheNames = "users", keyGenerator = "MyKeyGenerator")
public class UserService {

    @Cacheable
    public User findA(User user) {
        return null;
    }

    @Cacheable
    public User findB(User user) {
        return null;
    }

}
