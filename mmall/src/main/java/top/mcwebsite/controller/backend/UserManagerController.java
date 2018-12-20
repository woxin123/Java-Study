package top.mcwebsite.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.mcwebsite.common.Const;
import top.mcwebsite.common.ServerResponse;
import top.mcwebsite.pojo.User;
import top.mcwebsite.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * @author mengchen
 * @time 18-12-1 下午7:13
 */
@Controller
@RequestMapping("/manager/user")
public class UserManagerController {

    private final UserService userService;

    @Autowired
    public UserManagerController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session) {
        ServerResponse<User> response = userService.login(username, password);
        if (response.isSuccess()) {
            User user = response.getData();
            if (user.getRole() == Const.Role.ROLE_ADMIN) {
                // 说明登录的是管理员
                return  response;
            } else {
                return ServerResponse.createByErrorMessage("不是管理员,无法登录");
            }
        }
        return response;
    }
}
