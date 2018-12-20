package top.mcwebsite.controller.portal;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.mcwebsite.common.Const;
import top.mcwebsite.common.ResponseCodeEnum;
import top.mcwebsite.common.ServerResponse;
import top.mcwebsite.pojo.User;
import top.mcwebsite.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * @author mengchen
 * @time 18-10-28 下午7:40
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @param session
     * @return
     */
    @PostMapping(value = "/login.do")
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session) {
        ServerResponse<User> response = userService.login(username, password);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    @PostMapping("logout.do")
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    @PostMapping("register.do")
    @ResponseBody
    public ServerResponse<String> register(User user) {
        return userService.register(user);
    }

    @PostMapping("check_valid.do")
    @ResponseBody
    public ServerResponse<String> checkValid(String str, String type) {
        return userService.checkValid(str, type);
    }

    @PostMapping("get_user_info.do")
    @ResponseBody
    public ServerResponse<User> getUserInfo(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user != null) {
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("用户未登录，无法获取当前用户的信息");
    }

    @PostMapping("forget_get_question.do")
    @ResponseBody
    public ServerResponse<String> forgetGetQuesting(String username) {
        return userService.selectQuesting(username);
    }

    @PostMapping("forget_check_answer.do")
    @ResponseBody
    public ServerResponse<String> forgetCheckAnswer(String username, String question, String answer) {
        return userService.checkAnswer(username, question, answer);
    }

    @PostMapping("forget_reset_password.do")
    @ResponseBody
    public ServerResponse<String> forgetResetPassword(String username, String password,
                                                      String forgetToken) {
        return userService.forgetResetPassword(username, password, forgetToken);
    }

    @PostMapping("reset_password.do")
    @ResponseBody
    public ServerResponse<String> resetPassword(HttpSession session, String passwordOld, String passwordNew) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return userService.resetPassowrd(passwordOld, passwordNew, user);
    }

    @PostMapping("update_information.do")
    @ResponseBody
    public ServerResponse<User> updateInformation(HttpSession session, User user) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        user.setId(currentUser.getId());
        user.setUsername(currentUser.getUsername());
        ServerResponse<User> response = userService.updateInformation(user);

        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }

        return response;
    }

    @PostMapping("get_information.do")
    @ResponseBody
    public ServerResponse<User> getInformation(HttpSession session) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createErrorByErrorCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),
                    "未登录，需要强制登录");
        }
        return userService.getInformation(currentUser.getId());
    }
}

