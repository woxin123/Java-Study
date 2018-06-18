package top.mcwebsite.springsecurityinaction.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()    // 基于表单的登录验证
                .loginPage("/login")
                .failureForwardUrl("/login-error")
                .and().rememberMe()
                .and()
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/index", "/login").permitAll() // 都可以访问
                .antMatchers("/users/**").hasRole("ADMIN")  // 需要ADMIN角色才能访问;
                .and()
                .csrf().disable();
    }
}
