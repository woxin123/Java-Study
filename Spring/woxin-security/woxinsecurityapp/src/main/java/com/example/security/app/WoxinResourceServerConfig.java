package com.example.security.app;

import com.example.security.core.authentication.moblie.SmsCodeAuthenticationSecurityConfig;
import com.example.security.core.properties.SecurityConstants;
import com.example.security.core.properties.SecurityProperties;
import com.example.security.core.validate.core.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * @author: mengchen
 * Create by 18-4-17
 */
@Configuration
@EnableResourceServer
public class WoxinResourceServerConfig extends ResourceServerConfigurerAdapter {



    @Autowired
    private SecurityProperties securityProperties;


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationSuccessHandler woxinAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler woxinAuthenticationFailureHandler;


    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;


    @Autowired
    private SpringSocialConfigurer woxinSocialSecurityConfig;


    @Autowired
    public ValidateCodeSecurityConfig validateCodeSecurityConfig;


    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
//        tokenRepository.setCreateTableOnStartup(true);
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATTION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(woxinAuthenticationSuccessHandler)
                .failureHandler(woxinAuthenticationFailureHandler);
        http.apply(validateCodeSecurityConfig)
                .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                .apply(woxinSocialSecurityConfig)
                .and()
                .authorizeRequests() //授权配置
                .antMatchers(
                        SecurityConstants.DEFAULT_UNAUTHENTICATTION_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        securityProperties.getBrowser().getLoginPage(),
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                        securityProperties.getBrowser().getSignOutUrl(),
                        "/session/invalid")
                .permitAll()   // 这个url不需要身份认证
                .anyRequest()   // 任何请求
                .authenticated()   // 都需要身份认证
                .and()
                .csrf().disable();
    }
}
