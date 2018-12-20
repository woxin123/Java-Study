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

    ServerResponse<String> checkAnswer(String username, String question, String answer);

    ServerResponse<String> forgetResetPassword(String username, String password,
                                               String forgetToken);

    ServerResponse<String> resetPassowrd(String passwordOld, String passwordNew, User user);

    ServerResponse<User> updateInformation(User user);

    ServerResponse<User> getInformation(Integer userId);

    ServerResponse checkAdminRole(User user);
}