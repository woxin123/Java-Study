package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author: mengchen
 * Create by 18-4-23
 */
@Configuration
@EnableResourceServer
public class WebSecurityConfig  extends ResourceServerConfigurerAdapter {



    @Autowired
    private AuthenticationSuccessHandler woxinAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler woxinAuthenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/loginPage")
                .loginProcessingUrl("/login")
                .successHandler(woxinAuthenticationSuccessHandler)
                .failureHandler(woxinAuthenticationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/loginPage", "/auth/*", "/hello").permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }
}
