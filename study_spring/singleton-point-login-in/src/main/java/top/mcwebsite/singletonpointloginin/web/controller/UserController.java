package top.mcwebsite.singletonpointloginin.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.mcwebsite.singletonpointloginin.common.ServerResponse;
import top.mcwebsite.singletonpointloginin.model.User;
import top.mcwebsite.singletonpointloginin.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author mengchen
 * @time 18-11-17 下午8:24
 */
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> login(String username, String password,
                                        HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        System.out.println(username + ":" + password);
        ServerResponse<String> result = userService.login(username, password);
        if (result.isSuccess()) {

            Cookie cookie = new Cookie("token", result.getData());
            cookie.setDomain("mengchen.com");
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
        }

        return result;
    }



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<User> index(HttpServletRequest request) throws IOException {
        Cookie[] cookies = request.getCookies();
        Cookie tokenCookie = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                tokenCookie = cookie;
            }
        }
        if (tokenCookie == null) {
            return ServerResponse.createByErrorMessage("用户没有登录");
        }
        String token = tokenCookie.getValue();
        return userService.getUserFromToken(token);
    }
}
