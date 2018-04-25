package com.example.branch.config;

import com.example.branch.authentication.BranchSuccessfulAuthenticationHandler;
import com.example.branch.util.JwtUtil;
import com.example.branch.web.filter.JwtFilter;
import com.example.branch.web.filter.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mengchen
 * Create by 18-4-23
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();
        loginFilter.setAuthenticationSuccessHandler(branchSuccessfulAuthenticationHandler);
        loginFilter.setFilterProcessesUrl("/login");
        loginFilter.setAuthenticationManager(authenticationManager());
        return loginFilter;
    }

    @Autowired
    JwtUtil jwtUtil;

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        JwtFilter jwtFilter = new JwtFilter(jwtUtil);
        filterRegistrationBean.setFilter(jwtFilter);
        List<String> urls = new ArrayList<>();
        urls.add("/hello");
        urls.add("/world");
        filterRegistrationBean.setUrlPatterns(urls);
        return filterRegistrationBean;
    }


    @Autowired
    private BranchSuccessfulAuthenticationHandler branchSuccessfulAuthenticationHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/")
                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable();

        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
