package top.mcwebsite.common;


import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.google.common.cache.CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author mengchen
 * @time 18-11-4 下午10:38
 */
public class TokenCache {

    private static Logger logger = LoggerFactory.getLogger(TokenCache.class);

    private static LoadingCache<String, String> localCache = Caffeine.newBuilder()
            .initialCapacity(1000)
            .maximumSize(10000)
            .expireAfterAccess(12, TimeUnit.HOURS)
            .build(s -> "null");

    public static void setKey(String key, String value) {
        localCache.put(key, value);
    }

    public static String getKey(String key) {
        String value = null;
        value = localCache.get(key);
        if ("null".equals(value)) {
            return null;
        }
        return value;
    }

}
