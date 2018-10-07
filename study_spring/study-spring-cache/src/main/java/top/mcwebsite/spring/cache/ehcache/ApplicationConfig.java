package top.mcwebsite.spring.cache.ehcache;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.hibernate.EhCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;

/**
 * @author mengchen
 * @time 18-10-7 下午7:40
 */
//@Configuration
//@EnableCaching
//@ComponentScan("top.mcwebsite.spring.cache.ehcache")
public class ApplicationConfig {

    @Bean
    public CacheManager cacheManager() {
        EhCacheManagerFactoryBean cacheManager = new EhCacheManagerFactoryBean();
        cacheManager.setConfigLocation(new DefaultResourceLoader().getResource("classpath:ehcache.xml"));
        return cacheManager.getObject();
    }

    @Bean
    public EhCacheCacheManager ehCacheCacheManager() {
        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
        ehCacheCacheManager.setCacheManager(cacheManager());
        return ehCacheCacheManager;
    }
}
