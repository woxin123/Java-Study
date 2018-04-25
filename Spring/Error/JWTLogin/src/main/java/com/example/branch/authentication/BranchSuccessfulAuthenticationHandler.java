package com.example.branch.authentication;

import com.example.branch.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author: mengchen
 * Create by 18-4-23
 */
@Component
public class BranchSuccessfulAuthenticationHandler implements AuthenticationSuccessHandler {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        ObjectMapper objectMapper = new ObjectMapper();
        String account = (String) request.getAttribute("account");
        response.setContentType("application/json;charset=UTF-8");
        String token = jwtUtil.generateToken(account);
        redisTemplate.opsForValue().set("branch" + account, token, 1, TimeUnit.DAYS);

        response.getWriter().write(objectMapper.writeValueAsString(token));
    }
}
