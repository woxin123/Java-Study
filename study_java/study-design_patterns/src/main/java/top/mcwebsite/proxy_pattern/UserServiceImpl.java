package top.mcwebsite.proxy_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mengchen
 * @time 18-10-13 下午3:58
 */
public class UserServiceImpl implements UserService{

    private static Map<Integer, User> users = new HashMap<>();

    static {
        users.put(1, new User(1, "张三"));
        users.put(2, new User(2, "李四"));
    }

    @Override
    public boolean login(int id) {
        if (users.containsKey(id)) {
            return true;
        } else {
            return false;
        }
    }

}
