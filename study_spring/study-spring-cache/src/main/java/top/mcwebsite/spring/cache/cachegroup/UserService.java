package top.mcwebsite.spring.cache.cachegroup;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import top.mcwebsite.spring.cache.domain.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mengchen
 * @time 18-10-7 下午2:59
 */
@Service(value = "cacheGroupUserService")
public class UserService {

    private Map<Integer, User> pp1 = new HashMap<Integer, User>();

    {
        pp1.put(1, new Member("1", "w1"));
        pp1.put(2, new Visitor("2", "w2"));
    }

    @Caching(cacheable = {
            @Cacheable(value = "members", condition = "#obj instanceof T(top.mcwebsite.spring.cache.cachegroup.Member)"),
            @Cacheable(value = "visitors", condition = "#obj instanceof T(top.mcwebsite.spring.cache.cachegroup.Visitor)")
    })
    public User getUser(User obj) {
        return pp1.get(Integer.valueOf(obj.getUserId()));
    }
}
