package com.example.security.browser;

import com.example.security.core.authentication.AbstractChannelSecurityConfig;
import com.example.security.core.authentication.moblie.SmsCodeAuthenticationSecurityConfig;
import com.example.security.core.authorize.AuthorizeConfigManager;
import com.example.security.core.properties.SecurityConstants;
import com.example.security.core.properties.SecurityProperties;
import com.example.security.core.validate.core.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {


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

    @Autowired
    private InvalidSessionStrategy invalidSessionStrategy;

    @Autowired
    private SessionInformationExpiredStrategy woxinInformationExpiredSessionStrategy;


    @Autowired
    private LogoutSuccessHandler woxinLogoutSuccessHandler;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
//        tokenRepository.setCreateTableOnStartup(true);
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    @Autowired
    private AuthorizeConfigManager woxinAuthorizeConfigManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        applyPasswordAuthenticationConfig(http);

        http.apply(validateCodeSecurityConfig)
                .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                .apply(woxinSocialSecurityConfig)
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(userDetailsService)   // remember-me配置
                .and()      // and
                .sessionManagement()
                .invalidSessionStrategy(invalidSessionStrategy)
                .maximumSessions(securityProperties.getBrowser().getSession().getMaximumSessions())
                .maxSessionsPreventsLogin(securityProperties.getBrowser().getSession().isMaxSessionPreventsLogin())     //当session达到最大的时候，阻止
                .expiredSessionStrategy(woxinInformationExpiredSessionStrategy)
                .and()
                .and()
                .logout()
                .logoutUrl("/signOut")
//                .logoutSuccessUrl("/woxin-logout.html")
                .logoutSuccessHandler(woxinLogoutSuccessHandler)
                .deleteCookies("JSESSIONID")
                .and()
                .csrf().disable();

        woxinAuthorizeConfigManager.config(http.authorizeRequests());
    }
}
