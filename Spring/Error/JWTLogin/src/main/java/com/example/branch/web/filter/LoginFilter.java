package com.example.branch.web.filter;

import com.example.branch.model.domain.AuthenticationBean;
import com.example.branch.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: mengchen
 * Create by 18-4-23
 */
public class LoginFilter extends UsernamePasswordAuthenticationFilter {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        if (request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)
                || request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {

            //use jackson to deserialize json
            ObjectMapper mapper = new ObjectMapper();
            UsernamePasswordAuthenticationToken authRequest = null;
            try (InputStream is = request.getInputStream()) {
                AuthenticationBean authenticationBean = mapper.readValue(is, AuthenticationBean.class);
                request.setAttribute("account", authenticationBean.getAccount());
                logger.info(authenticationBean.getPassword() + " " + authenticationBean.getPassword());
                authRequest = new UsernamePasswordAuthenticationToken(
                        authenticationBean.getAccount(), authenticationBean.getPassword());
            } catch (IOException e) {
                e.printStackTrace();
                new UsernamePasswordAuthenticationToken(
                        "", "");
            }

            setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
            //transmit it to UsernamePasswordAuthenticationFilter
        } else {
            return super.attemptAuthentication(request, response);
        }
    }

}
