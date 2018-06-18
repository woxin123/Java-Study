package top.mcwebsite.securityinaction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.xml.ws.Action;

/**
 * 安全配置类
 */
@Configuration
@EnableWebSecurity // 启用配置类
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 自定义配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()    // 基于表单的登录验证
//                .loginPage("/login")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/css/**", "/js/**", "/index", "/login").permitAll() // 都可以访问
//                .antMatchers("/users/**").hasRole("ADMIN")  // 需要ADMIN角色才能访问;
        http.httpBasic();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("woxin123").password("123456").roles("ADMIN");
//    }
}
