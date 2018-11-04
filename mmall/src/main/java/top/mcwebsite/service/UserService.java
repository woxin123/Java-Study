package top.mcwebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import top.mcwebsite.common.ServerResponse;
import top.mcwebsite.dao.UserMapper;
import top.mcwebsite.pojo.User;

/**
 * @author mengchen
 * @time 18-10-28 下午7:44
 */
public interface UserService {

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String str, String type);

    ServerResponse<String> selectQuesting(String username);
}